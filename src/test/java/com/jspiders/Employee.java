package com.jspiders;

import jakarta.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "empno")
    private Long empNo;

    @Column(name = "ename",nullable = false)
    private String empName;

    @Column(name = "email",nullable = false,unique = true)
    private String empEmail;


}
