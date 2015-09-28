package jtodos.repository;

import jtodos.domain.TodoItem;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

/**
 * Created by yxfan on 9/28/15.
 */

@Transactional
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepo;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepo) {
        this.todoItemRepo = todoItemRepo;
    }

    @Override
    public TodoItem GetItem(long id) {
        return this.todoItemRepo.findOne(id);
    }

    @Override
    public TodoItem GetItem(String name) {
        return null;
    }

    @Override
    public Iterable<TodoItem> QueryItems() {
        return this.todoItemRepo.findAll();
    }

    @Override
    public Iterable<TodoItem> QueryItems(String searchText) {
        return null;
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
