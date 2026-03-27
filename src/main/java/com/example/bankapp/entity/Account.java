package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // ✅ IMPORTANT
    private String accountNumber;

    private double balance;

    private String accountHolderName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}