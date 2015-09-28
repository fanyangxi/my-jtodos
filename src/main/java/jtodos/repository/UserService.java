package jtodos.repository;

import jtodos.domain.User;

import java.util.Iterator;

/**
 * Created by yxfan on 9/28/15.
 */

public interface UserService {

    User GetUser(long id);

    User GetUser(String userName);

    Iterable<User> QueryUsers();

    Iterable<User> QueryUsers(String searchText);

    void Create (User newItem);

    void Update (User updatedItem);

    void Delete (long id);
}
