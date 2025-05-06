package it.rss.ing.controller;

import it.rss.ing.repository.UserRepository;
import it.rss.ing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import it.rss.ing.model.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired //DependencyInjection
    private UserService userService;

    @GetMapping
    public String getUser(Model model) {
        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);
        return "insert-user";
    }

    @PostMapping("/insert")
    public String insertUser(User user,Model model ){

        userService.insertUser(user);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "insert-user";
    }



}
