package jtodos.web;

import jtodos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxfan on 9/28/15.
 */

@Controller
public class WebViewController {

    @Autowired
    private jtodos.repository.UserService userService;

    @RequestMapping("/web")
    public String index(Model model) {
        model.addAttribute("name", "fanyangxi");
        return "web";
    }

    @RequestMapping("/todos/{userid}")
    public String greeting2(@PathVariable long userid, @RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "todos";
    }
}
