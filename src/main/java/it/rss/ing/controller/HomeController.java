package it.rss.ing.controller;

import it.rss.ing.service.UserDetailsServiceImpl;
import it.rss.ing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class HomeController {

    @Autowired //DependencyInjection
    private UserService userService;


    @GetMapping("/")
    public String getHome(){
        System.out.println("ciao ciao sono nella home");
        return "home";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        //Mi prendo i dati dell utente loggato
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username );

        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login personalizzato
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.userExists(username)) {
            model.addAttribute("error", "Username già esistente");
            return "register";
        }

        userService.registerUser(username, password);
        return "redirect:/login?registered";
    }

}
