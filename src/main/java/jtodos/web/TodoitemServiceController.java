package jtodos.web;

import jtodos.domain.Todoitem;
import jtodos.domain.User;
import jtodos.repository.TodoitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxfan on 9/28/15.
 */

@RequestMapping("/{userid}/todoitems")
@RestController
public class TodoitemServiceController {

    @Autowired
    private jtodos.repository.UserService userService;

    @Autowired
    private TodoitemService todoitemService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Todoitem> getTodoitems(@PathVariable long userid) {
        Iterable<Todoitem> results = this.todoitemService.queryItems(userid);
        return results;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createTodoitem(@PathVariable long userid, Todoitem newItem) {
        newItem.setUserid(userid);
        this.todoitemService.create(newItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Todoitem getTodoitem(@PathVariable long userid, @PathVariable long id) {

        //todo: filter by userid first
        Todoitem result = this.todoitemService.getItem(id);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateTodoitem (@PathVariable long userid, @PathVariable long id, Todoitem updatedItem) {
        updatedItem.setUserid(id);
        updatedItem.setUserid(userid);
        this.todoitemService.update(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTodoitem (@PathVariable long userid, @PathVariable long id) {

        //todo: filter by userid first
        this.todoitemService.delete(id);
    }
}
