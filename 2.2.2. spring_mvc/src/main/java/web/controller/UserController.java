package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Role;
import web.models.User;
import web.service.ServiceUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final ServiceUser serviceUser;
    private String buttonName;

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
    public String updateUser(@RequestParam("user_id") int id,
                             Model model,
                             Model b_model,
                             Model action){
        User user;
        String nameAction;
        String nameButton;
        if (id != 0) {
            user = serviceUser.getUser(id);
            nameAction = "/update";
            nameButton = "Update";
        } else {
            user = new User();
            nameAction = "/create";
            nameButton = "Create";
        }

        model.addAttribute("user", user);
        b_model.addAttribute("button_name", nameButton);
        action.addAttribute("action", nameAction);

        return "newOrUpdate";
    }

    @PostMapping(value = "/create")
    public String create(@RequestParam("name") String name,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("age") Integer age,
                         @RequestParam("email") String email,
                         @RequestParam("role") int role_id,
                         Model model,
                         Model textModel) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(serviceUser.getRole(role_id));
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setRoles(roles);

        serviceUser.add(user);

        model.addAttribute("user", user);

        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String update(){
        return "redirect:/";
    }

}
