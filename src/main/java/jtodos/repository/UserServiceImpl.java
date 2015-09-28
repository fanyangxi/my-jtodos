package jtodos.repository;

import jtodos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

/**
 * Created by yxfan on 9/28/15.
 */

@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User GetUser(long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User GetUser(String userName) {
        Assert.notNull(userName, "The filter user-name cannot be null");
        return null;
    }

    @Override
    public Iterable<User> QueryUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public Iterable<User> QueryUsers(String searchText) {
        return null;
    }

    @Override
    public void Create(User newItem) {

        Assert.notNull(newItem);
        Assert.notNull(newItem.getName());

        this.userRepo.save(newItem);
    }

    @Override
    public void Update(User updatedItem) {

        Assert.notNull(updatedItem);
        Assert.notNull(updatedItem.getName());

        User theItem = this.userRepo.findOne(updatedItem.getId());
        theItem.setName(updatedItem.getName());
        theItem.setAddress(updatedItem.getAddress());
        theItem.setZip(updatedItem.getZip());
        this.userRepo.save(theItem);
    }

    @Override
    public void Delete(long id) {

        User theItem = this.userRepo.findOne(id);
        if (theItem == null) {
            return;
        }

        this.userRepo.delete(id);
    }
}
