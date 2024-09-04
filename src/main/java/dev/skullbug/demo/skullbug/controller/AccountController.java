package dev.skullbug.demo.skullbug.controller;

import dev.skullbug.demo.skullbug.model.Account; // Updated import statement
import dev.skullbug.demo.skullbug.dto.AccountDTO;
import dev.skullbug.demo.skullbug.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        // Convert DTO to Entity
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setEmail(accountDTO.getEmail());

        Account createdAccount = accountService.createAccount(account);

        // Convert Entity to DTO
        AccountDTO createdAccountDTO = new AccountDTO(
                createdAccount.getId(),
                createdAccount.getUsername(),
                createdAccount.getEmail()
        );

        return ResponseEntity.ok(createdAccountDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.getAccount(id);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            AccountDTO accountDTO = new AccountDTO(
                    account.getId(),
                    account.getUsername(),
                    account.getEmail()
            );
            return ResponseEntity.ok(accountDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add other endpoints as necessary
}
