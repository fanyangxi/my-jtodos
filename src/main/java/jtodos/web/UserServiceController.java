package jtodos.web;

import jtodos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxfan on 9/28/15.
 */

@RestController
public class UserServiceController {

    @Autowired
    private jtodos.repository.UserService userService;

    @RequestMapping("/")
    public String index() {

//        // Retrive all
//        Iterable<User> all = hotelRepo.findAll();
//        for (User item : all) {
//            String aaa = item.getName();
//        }

        return "hi, ...x";
    }

    @RequestMapping("/user-info")
    public User GetUserInfo(long id) {
        User result = this.userService.GetUser(id);
        return result;
    }
}
