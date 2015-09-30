package jtodos.repository;

import jtodos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

/**
 * Created by yxfan on 9/28/15.
 */

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUser(long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User getUser(String userName) {
        Assert.notNull(userName, "The filter user-name cannot be null");
        return null;
    }

    @Override
    public Iterable<User> queryUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public Iterable<User> queryUsers(String searchText) {
        return null;
    }

    @Override
    public void create(User newItem) {

        Assert.notNull(newItem);
        Assert.notNull(newItem.getName());

        this.userRepo.save(newItem);
    }

    @Override
    public void update(User updatedItem) {

        Assert.notNull(updatedItem);
        Assert.notNull(updatedItem.getName());

        User theItem = this.userRepo.findOne(updatedItem.getId());
        theItem.setName(updatedItem.getName());
        theItem.setGender(updatedItem.getGender());
        theItem.setBio(updatedItem.getBio());
        this.userRepo.save(theItem);
    }

    @Override
    public void delete(long id) {

        User theItem = this.userRepo.findOne(id);
        if (theItem == null) {
            return;
        }

        this.userRepo.delete(id);
    }
}
