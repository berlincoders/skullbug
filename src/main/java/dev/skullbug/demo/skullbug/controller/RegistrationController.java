package dev.skullbug.demo.skullbug.controller;

import dev.skullbug.demo.skullbug.model.Account;
import dev.skullbug.demo.skullbug.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute Account account, Model model) {
        // Encrypt the password before saving the account
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountService.createAccount(account);

        // Redirect to a success page
        return "registration-success";
    }


}
