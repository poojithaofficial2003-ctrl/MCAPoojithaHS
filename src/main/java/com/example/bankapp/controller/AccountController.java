package com.example.bankapp.controller;

import com.example.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestParam String username) {
        return accountService.createAccount(username);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber,
                          @RequestParam double amount) {
        return accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber,
                           @RequestParam double amount) {
        return accountService.withdraw(accountNumber, amount);
    }

    @GetMapping("/balance")
    public double checkBalance(@RequestParam String accountNumber) {
        return accountService.checkBalance(accountNumber);
    }
}