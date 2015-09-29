package jtodos.repository;

import jtodos.domain.User;

import java.util.Iterator;

/**
 * Created by yxfan on 9/28/15.
 */

public interface UserService {

    User getUser(long id);

    User getUser(String userName);

    Iterable<User> queryUsers();

    Iterable<User> queryUsers(String searchText);

    void create(User newItem);

    void update(User updatedItem);

    void delete(long id);
}
