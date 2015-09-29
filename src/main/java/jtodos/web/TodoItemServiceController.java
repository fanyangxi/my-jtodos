package jtodos.web;

import jtodos.domain.Todoitem;
import jtodos.domain.User;
import jtodos.repository.TodoitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxfan on 9/28/15.
 */

@RestController
public class TodoitemServiceController {

    @Autowired
    private jtodos.repository.UserService userService;

    @Autowired
    private TodoitemService todoitemService;

    @RequestMapping("/todo")
    public Todoitem GetTodoitem(long id) {
        Todoitem result = this.todoitemService.getItem(id);
        return result;
    }

    @RequestMapping("/user-todos")
    public Iterable<Todoitem> GetUserSpecificTodoitems(long userid) {
        Iterable<Todoitem> results = this.todoitemService.queryItems(userid);
        return results;
    }
}
