package com.example.bankapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
