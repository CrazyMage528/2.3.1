package org.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.example.models.User;
import org.example.services.UsersService;

import javax.validation.Valid;

@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String users(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", usersService.findAll());
        return "users";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users"; // возвращаем на страницу с ошибками
        }
        usersService.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        usersService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") long id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users"; // возвращаем на страницу с ошибками
        }
        usersService.update(id, user);
        return "redirect:/";
    }
}
