package com.example.bankapp.service;

import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.User;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    // ✅ CREATE ACCOUNT
    public String createAccount(String username) {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            return "User not found!";
        }

        if (user.getAccount() != null) {
            return "Account already exists!";
        }

        Account account = new Account();

        String accountNumber = "ACC" + System.currentTimeMillis();

        account.setAccountNumber(accountNumber);
        account.setBalance(0);
        account.setUser(user);
        account.setAccountHolderName(username);

        accountRepository.save(account);

        return "Account created successfully. Account Number: " + accountNumber;
    }

    // ✅ DEPOSIT
    public String deposit(String accountNumber, double amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            return "Account not found!";
        }

        if (amount <= 0) {
            return "Enter valid amount!";
        }

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        return "Deposit successful. Balance: " + account.getBalance();
    }

    // ✅ WITHDRAW
    public String withdraw(String accountNumber, double amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            return "Account not found!";
        }

        if (amount <= 0) {
            return "Enter valid amount!";
        }

        if (account.getBalance() < amount) {
            return "Insufficient balance!";
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        return "Withdraw successful. Balance: " + account.getBalance();
    }

    // ✅ CHECK BALANCE
    public double checkBalance(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new RuntimeException("Account not found!");
        }

        return account.getBalance();
    }
}