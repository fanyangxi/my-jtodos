package jtodos.web;

import jtodos.domain.Todoitem;
import jtodos.domain.User;
import jtodos.repository.TodoitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yxfan on 9/28/15.
 */

@RequestMapping("/users")
@RestController
public class UserServiceController {

    @Autowired
    private jtodos.repository.UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return this.userService.queryUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody User newUser) {
        this.userService.create(newUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        User result = this.userService.getUser(id);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User updatedUser) {
        this.userService.update(updatedUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        this.userService.delete(id);
    }
}
