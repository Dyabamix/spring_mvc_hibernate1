package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            return "redirect:/";
        }

        List<User> users = serviceUser.getAllUsers();

        modelMap.addAttribute("users", users);

        return "index";
    }

    @GetMapping(value = "/form_User")
    public String formUser(@RequestParam(value = "user_id", required = false) int id,
                                     Model userModel,
                                     Model buttonNameModel){
        String buttonName;
        User user = null;
        if (id == 0){
            buttonName = "Create";
            user = new User();
        } else {
            buttonName = "Update";
            user = serviceUser.getUser(id);
        }

        buttonNameModel.addAttribute("button_name", buttonName);
        userModel.addAttribute("user", user);

        return "newOrUpdate";
    }

    @PostMapping
    public String createOrUpdateUser(@ModelAttribute("user") User user){
        if (user.getId() == 0){
            serviceUser.add(user);
        } else {
            serviceUser.update(user);
        }
        return "redirect:/";
    }
}
