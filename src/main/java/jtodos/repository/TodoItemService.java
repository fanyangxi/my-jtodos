package jtodos.repository;

import jtodos.domain.TodoItem;

import java.util.List;

/**
 * Created by yxfan on 9/28/15.
 */

public interface TodoItemService {

    TodoItem getItem(long id);

    TodoItem getItem(String name);

    Iterable<TodoItem> queryItems();

    Iterable<TodoItem> queryItems(long userid);

    void create(TodoItem newItem);

    void update(TodoItem updatedItem);

    void delete(long id);
}
