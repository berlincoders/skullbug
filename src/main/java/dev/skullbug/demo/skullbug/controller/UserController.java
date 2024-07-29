package dev.skullbug.demo.skullbug.controller;

import dev.skullbug.demo.skullbug.model.User;
import dev.skullbug.demo.skullbug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Displays the registration form
    @GetMapping("/users/register")
    public String showRegistrationForm() {
        return "register"; // This should correspond to src/main/resources/templates/register.html
    }

    // Handles user registration
    @PostMapping("/users/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        // Create a new User object and set its properties
        User user = new User();
        user.setUsername(username);
        user.setPassword(userService.encodePassword(password)); // Ensure the password is encoded

        // Save the user to the database
        userService.saveUser(user);

        // Redirect to a success page or login page
        return "redirect:/users/success";
    }

    // Displays a success page after registration
    @GetMapping("/users/success")
    public String registrationSuccess() {
        return "success"; // This should correspond to src/main/resources/templates/success.html
    }

    // Optionally, handle errors and display appropriate messages
    @GetMapping("/users/error")
    public ModelAndView handleError() {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "An error occurred during registration.");
        return mav;
    }
}
