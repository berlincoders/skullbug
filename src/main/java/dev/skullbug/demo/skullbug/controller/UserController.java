package dev.skullbug.demo.skullbug.controller;

import dev.skullbug.demo.skullbug.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // returns the register.html template
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Save the user to the database (this code is an example)
        // userService.save(user);

        model.addAttribute("message", "User registered successfully!");
        return "login";  // redirect to the login page after registration
    }
}
