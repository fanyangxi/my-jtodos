package jtodos.repository;

import jtodos.domain.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by yxfan on 9/28/15.
 */

@Component("todoItemService")
@Transactional
public class TodoItemServiceImpl implements TodoItemService {

    private TodoItemRepository todoItemRepo;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepo) {
        this.todoItemRepo = todoItemRepo;
    }

    @Override
    public TodoItem GetItem(long id) {
        return this.todoItemRepo.findOne(id);
    }

    @Override
    public TodoItem GetItem(String name) {
        TypedQuery<TodoItem> query = em.createQuery("select t from todoitems t where t.name = ?1", TodoItem.class);
        query.setParameter(1, name);
        return query.getResultList().get(0);
    }

    @Override
    public Iterable<TodoItem> QueryItems() {
        return this.todoItemRepo.findAll();
    }

    @Override
    public Iterable<TodoItem> QueryItems(String userid) {

        TypedQuery<TodoItem> query = em.createQuery("select t from todoitems t where t.userid = ?1", TodoItem.class);
        query.setParameter(1, userid);
        return query.getResultList();
    }

    @Override
    public void Create(TodoItem newItem) {

        Assert.notNull(newItem);
        Assert.notNull(newItem.getName());
        Assert.notNull(newItem.getUserid());

        this.todoItemRepo.save(newItem);
    }

    @Override
    public void Update(TodoItem updatedItem) {

        Assert.notNull(updatedItem);
        Assert.notNull(updatedItem.getName());
        Assert.notNull(updatedItem.getUserid());

        TodoItem theItem = this.todoItemRepo.findOne(updatedItem.getId());
        theItem.setName(updatedItem.getName());
        theItem.setContent(updatedItem.getContent());
        this.todoItemRepo.save(theItem);
    }

    @Override
    public void Delete(long id) {

        TodoItem theItem = this.todoItemRepo.findOne(id);
        if (theItem == null) {
            return;
        }

        this.todoItemRepo.delete(id);
    }
}
