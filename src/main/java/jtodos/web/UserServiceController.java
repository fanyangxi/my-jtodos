package jtodos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxfan on 9/28/15.
 */

@RestController
public class UserServiceController {

    @Autowired
    private jtodos.repository.UserRepository hotelRepo;

    @RequestMapping("/")
    public String index () {

//        // Retrive all
//        Iterable<User> all = hotelRepo.findAll();
//        for (User item : all) {
//            String aaa = item.getName();
//        }

        return "hi, ...x";
    }

}
