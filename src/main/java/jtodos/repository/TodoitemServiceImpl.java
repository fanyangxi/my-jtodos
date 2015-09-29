package jtodos.repository;

import jtodos.domain.Todoitem;
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

@Component("todoitemService")
@Transactional
public class TodoitemServiceImpl implements TodoitemService {

    private TodoitemRepository todoitemRepo;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public TodoitemServiceImpl(TodoitemRepository todoitemRepo) {
        this.todoitemRepo = todoitemRepo;
    }

    @Override
    public Todoitem getItem(long id) {
        return this.todoitemRepo.findOne(id);
    }

    @Override
    public Todoitem getItem(String name) {
        TypedQuery<Todoitem> query = em.createQuery("select t from Todoitem t where t.name = ?1", Todoitem.class);
        query.setParameter(1, name);
        return query.getResultList().get(0);
    }

    @Override
    public Iterable<Todoitem> queryItems() {
        return this.todoitemRepo.findAll();
    }

    @Override
    public Iterable<Todoitem> queryItems(long userid) {

        TypedQuery<Todoitem> query = em.createQuery("select t from Todoitem t where t.userid = ?1", Todoitem.class);
        query.setParameter(1, userid);
        return query.getResultList();
    }

    @Override
    public void create(Todoitem newItem) {

        Assert.notNull(newItem);
        Assert.notNull(newItem.getName());
        Assert.notNull(newItem.getUserid());

        this.todoitemRepo.save(newItem);
    }

    @Override
    public void update(Todoitem updatedItem) {

        Assert.notNull(updatedItem);
        Assert.notNull(updatedItem.getName());
        Assert.notNull(updatedItem.getUserid());

        Todoitem theItem = this.todoitemRepo.findOne(updatedItem.getId());
        theItem.setName(updatedItem.getName());
        theItem.setContent(updatedItem.getContent());
        this.todoitemRepo.save(theItem);
    }

    @Override
    public void delete(long id) {

        Todoitem theItem = this.todoitemRepo.findOne(id);
        if (theItem == null) {
            return;
        }

        this.todoitemRepo.delete(id);
    }
}
