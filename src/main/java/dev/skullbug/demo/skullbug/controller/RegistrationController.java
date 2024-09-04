package dev.skullbug.demo.skullbug.controller;

import dev.skullbug.demo.skullbug.model.Account;
import dev.skullbug.demo.skullbug.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final AccountRepository accountRepository; // Updated to AccountRepository
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository; // Updated to AccountRepository
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new Account()); // Updated to Account
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Account account, Model model) { // Updated to Account
        // Encrypt the password before saving the user
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account); // Updated to AccountRepository

        // Redirect to login page after successful registration
        return "redirect:/login?success";
    }
}
