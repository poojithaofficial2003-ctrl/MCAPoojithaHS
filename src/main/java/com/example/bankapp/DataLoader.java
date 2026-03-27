package com.example.bankapp;

import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.User;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public void run(String... args) {

        // ✅ Run only if DB is empty
        if (userRepository.count() == 0) {

            // 👉 Create User 1
            User user1 = new User();
            user1.setUsername("poojitha");
            userRepository.save(user1);

            // 👉 Create Account for User 1
            Account acc1 = new Account();
            acc1.setAccountNumber("ACC" + System.currentTimeMillis());
            acc1.setBalance(5000);
            acc1.setUser(user1);
            acc1.setAccountHolderName(user1.getUsername());
            accountRepository.save(acc1);


            // 👉 Create User 2
            User user2 = new User();
            user2.setUsername("testuser");
            userRepository.save(user2);

            // 👉 Create Account for User 2
            Account acc2 = new Account();
            acc2.setAccountNumber("ACC" + (System.currentTimeMillis() + 1));
            acc2.setBalance(10000);
            acc2.setUser(user2);
            acc2.setAccountHolderName(user2.getUsername());
            accountRepository.save(acc2);

            System.out.println("✅ Sample users and accounts created!");
        } else {
            System.out.println("⚡ Data already exists, skipping DataLoader...");
        }
    }
}