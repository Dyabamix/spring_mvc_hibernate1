package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;
import web.service.ServiceUser;

import java.util.List;

@Controller
public class UserController {

    private ServiceUser serviceUser;

    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping(value = "/")
    public String CrudUsers(ModelMap modelMap){
        serviceUser.add(new User("1", "11", 11, "111@mail.ru"));
        serviceUser.add(new User("2", "12", 12, "112@mail.ru"));
        serviceUser.add(new User("3", "13", 13, "113@mail.ru"));

        List<User> users = serviceUser.getAllUsers();

        modelMap.addAttribute("users", users);

        return "index";
    }
}
