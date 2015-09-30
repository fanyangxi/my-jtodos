package jtodos.web;

import jtodos.domain.Todoitem;
import jtodos.domain.User;
import jtodos.repository.TodoitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Todoitem> getTodoitems(@PathVariable long userid) {
        Iterable<Todoitem> results = this.todoitemService.queryItems(userid);
        return results;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTodoitem(@PathVariable long userid, @RequestBody Todoitem newItem) {
        newItem.setId(0);
        newItem.setUserid(userid);
        this.todoitemService.create(newItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Todoitem getTodoitem(@PathVariable long userid, @PathVariable long id) {

        //todo: filter by userid first
        Todoitem result = this.todoitemService.getItem(id);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTodoitem (@PathVariable long userid, @PathVariable long id, @RequestBody Todoitem updatedItem) {
        updatedItem.setId(id);
        updatedItem.setUserid(userid);
        this.todoitemService.update(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTodoitem (@PathVariable long userid, @PathVariable long id) {

        //todo: filter by userid first
        this.todoitemService.delete(id);
    }
}
