package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.ServiceUser;

import java.util.List;

@Controller
public class UserController {

    private final ServiceUser serviceUser;

    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping(value = "/")
    public String getListUsersAndDeleteUser(@RequestParam(name = "user_id", required = false) Integer user_id,
                                            ModelMap modelMap) {
        if (user_id != null) {
            serviceUser.delete(user_id);
        }

        List<User> users = serviceUser.getAllUsers();

        modelMap.addAttribute("users", users);

        return "index";
    }

    @GetMapping(value = "/form_User")
    public String createOrUpdateUser(@RequestParam(name = "user_id", required = false) Integer user_id,
                                     Model buttonNameModel){
        String buttonName;
        if (user_id == null){
            buttonName = "Create user";
        } else {
            buttonName = "Update user";
        }
        buttonNameModel.addAttribute("button_name", buttonName);

        return "newOrUpdate";
    }
}
