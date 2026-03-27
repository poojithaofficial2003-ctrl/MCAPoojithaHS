package com.example.bankapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
