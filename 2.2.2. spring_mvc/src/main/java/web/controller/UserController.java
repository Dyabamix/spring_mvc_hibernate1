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

import java.util.HashSet;
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

    @GetMapping(value = "/create_or_update")
    public String createOrUpdateUser(@RequestParam("user_id") int id,
                                     Model modelUser,
                                     Model b_model,
                                     Model action,
                                     Model title) {
        User user;
        String nameAction;
        String nameButton;
        String textTitle;
        if (id != 0) {
            user = serviceUser.getUser(id);
            nameAction = "/update";
            nameButton = "Update";
            textTitle = "Update user";
        } else {
            user = new User();
            user.setRoles(new HashSet<>());
            nameAction = "/create";
            nameButton = "Create";
            textTitle = "Create new user";
        }

        modelUser.addAttribute("user", user);
        modelUser.addAttribute("allRoles", serviceUser.getAllRoles());
        b_model.addAttribute("button_name", nameButton);
        action.addAttribute("action", nameAction);
        title.addAttribute("title", textTitle);

        return "newOrUpdate";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute("user") User user) {

        user.getRoles().forEach(role -> {
            if (role.getUser() != null){
                role.getUser().add(user);
            } else {
                role.setUser(new HashSet<>());
                role.getUser().add(user);
            }
        });
        serviceUser.add(user);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("user") User user) {
        user.getRoles().forEach(role -> {
            if (!role.getUser().isEmpty()){
                role.getUser().add(user);
            } else {
                role.setUser(new HashSet<>());
                role.getUser().add(user);
            }
        });
        serviceUser.update(user);
        return "redirect:/";
    }

}
