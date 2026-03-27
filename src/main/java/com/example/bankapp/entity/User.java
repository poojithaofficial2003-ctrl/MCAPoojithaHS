package com.example.bankapp.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String secret; // for OTP

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
}
