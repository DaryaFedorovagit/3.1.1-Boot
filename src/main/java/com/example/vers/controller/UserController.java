package com.example.vers.controller;

import com.example.vers.model.User;
import com.example.vers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("ListOfUsers", userService.getAllUsers());
        return "primary";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("editUser", userService.getUserById(id));
        return "edit";
    }

    @PutMapping("/edit")
    public String update(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}