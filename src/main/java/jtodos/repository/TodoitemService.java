package jtodos.repository;

import jtodos.domain.Todoitem;

/**
 * Created by yxfan on 9/28/15.
 */

public interface TodoitemService {

    Todoitem getItem(long id);

    Todoitem getItem(String name);

    Iterable<Todoitem> queryItems();

    Iterable<Todoitem> queryItems(long userid);

    void create(Todoitem newItem);

    void update(Todoitem updatedItem);

    void delete(long id);
}
