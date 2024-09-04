package dev.skullbug.demo.skullbug.services;
import dev.skullbug.demo.skullbug.model.Account;
import dev.skullbug.demo.skullbug.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    // Add other methods as necessary
}
