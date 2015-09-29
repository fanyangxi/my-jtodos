package jtodos.repository;

import jtodos.domain.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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
    public TodoItem getItem(long id) {
        return this.todoItemRepo.findOne(id);
    }

    @Override
    public TodoItem getItem(String name) {
        TypedQuery<TodoItem> query = em.createQuery("select t from TodoItem t where t.name = ?1", TodoItem.class);
        query.setParameter(1, name);
        return query.getResultList().get(0);
    }

    @Override
    public Iterable<TodoItem> queryItems() {
        return this.todoItemRepo.findAll();
    }

    @Override
    public Iterable<TodoItem> queryItems(long userid) {

        TypedQuery<TodoItem> query = em.createQuery("select t from TodoItem t where t.userid = ?1", TodoItem.class);
        query.setParameter(1, userid);
        return query.getResultList();

//        return this.todoItemRepo.findUserSpecificTodoItems(userid);
    }

    @Override
    public void create(TodoItem newItem) {

        Assert.notNull(newItem);
        Assert.notNull(newItem.getName());
        Assert.notNull(newItem.getUserid());

        this.todoItemRepo.save(newItem);
    }

    @Override
    public void update(TodoItem updatedItem) {

        Assert.notNull(updatedItem);
        Assert.notNull(updatedItem.getName());
        Assert.notNull(updatedItem.getUserid());

        TodoItem theItem = this.todoItemRepo.findOne(updatedItem.getId());
        theItem.setName(updatedItem.getName());
        theItem.setContent(updatedItem.getContent());
        this.todoItemRepo.save(theItem);
    }

    @Override
    public void delete(long id) {

        TodoItem theItem = this.todoItemRepo.findOne(id);
        if (theItem == null) {
            return;
        }

        this.todoItemRepo.delete(id);
    }
}
