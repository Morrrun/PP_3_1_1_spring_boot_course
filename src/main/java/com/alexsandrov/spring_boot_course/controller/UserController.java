package com.alexsandrov.spring_boot_course.controller;

import com.alexsandrov.spring_boot_course.model.User;
import com.alexsandrov.spring_boot_course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showUsers(Model model) {

        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "users/out_users";
    }

    @GetMapping("/update")
    public String newUser(@ModelAttribute("user") User user) {

        return "users/info_users";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users/";
    }

    @PatchMapping("/update")
    public String updateUser(@RequestParam(value = "id", required = false) Long id,
                             Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/info_users";
    }

    @DeleteMapping("/remove")
    public String removeUser(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteUser(id);
        return "redirect:/users/";
    }
}
