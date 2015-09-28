package jtodos.repository;

import jtodos.domain.TodoItem;

/**
 * Created by yxfan on 9/28/15.
 */

public interface TodoItemService {

    TodoItem GetItem (long id);

    TodoItem GetItem (String name);

    Iterable<TodoItem> QueryItems ();

    Iterable<TodoItem> QueryItems (String searchText);

    void Create (TodoItem newItem);

    void Update (TodoItem updatedItem);

    void Delete (long id);
}
