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

//        // Create new
//        User newHotel = new User();
//        newHotel.setName("the new hotel v5");
//        newHotel.setAddress("some place");
//        newHotel.setZip("95004");
//        hotelRepo.save(newHotel);

        // Update existing
        jtodos.domain.User theItem = hotelRepo.findOne(7l);
        theItem.setName(theItem.getName() + "wakkakak");
        hotelRepo.save(theItem);

//        //Delete
//        hotelRepo.delete(6l);

        return "hi, ...x";
    }
}
