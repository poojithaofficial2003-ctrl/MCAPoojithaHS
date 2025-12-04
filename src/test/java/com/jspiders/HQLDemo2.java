package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class HQLDemo2 {

    public static void login(){
        System.out.println("Program starts.....");
        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("SessionFactory created");

        //get session from session factory
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Scanner sc = new Scanner(System.in);
        String loginHQL = "FROM Users user WHERE user.mobile= :mobile  AND user.password = :password";
        Query<Users> query = session.createQuery(loginHQL, Users.class);
        System.out.println("Enter user mobile)");
        String mobile = sc.next();
        System.out.println("Enter user password");
        String password = sc.next();
        query.setParameter("mobile", mobile);
        query.setParameter("password", password);
        Users users = query.uniqueResult();
        System.out.println(users);


        //logics

        //close session
        session.close();
        System.out.println("session closed");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFatory closed");
        System.out.println("program ends.....");
    }
    public static void main(String[] args) {
        login();

    }
}
