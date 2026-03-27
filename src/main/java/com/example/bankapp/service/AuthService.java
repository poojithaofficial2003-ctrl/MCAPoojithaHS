package com.example.bankapp.service;

import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.User;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.repository.UserRepository;
import com.example.bankapp.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public String register(String username) throws Exception {

        User existing = userRepository.findByUsername(username);

        if (existing != null) {
            return "User already exists!";
        }

        String secret = SecretKeyGenerator.generateSecret();

        User user = new User();
        user.setUsername(username);
        user.setSecret(secret);

        userRepository.save(user);

        // create account
        Account account = new Account();
        account.setAccountNumber("ACC" + System.currentTimeMillis());
        account.setBalance(0);
        account.setAccountHolderName(username);
        account.setUser(user);

        accountRepository.save(account);

        String otpURL = QRCodeUtil.getQRCodeURL(username, "BankApp", secret);

        String qrImage = QRCodeUtil.generateQRCodeImage(otpURL);

        return qrImage;
    }

    public String login(String username, String otp) {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            return "User not found!";
        }

        boolean isValid = OTPValidator.verifyCode(user.getSecret(), otp);

        if (isValid) {
            return "Login Successful ✅";
        } else {
            return "Invalid OTP ❌";
        }
    }
}