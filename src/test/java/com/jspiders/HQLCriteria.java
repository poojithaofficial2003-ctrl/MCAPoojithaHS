package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.Scanner;

public class HQLCriteria {
    public static void main(String[] args) {
        
    }
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
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
        cb.createQuery(Users.class)


        //logics

        //close session
        session.close();
        System.out.println("session closed");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFatory closed  successfully");
        System.out.println("program ends.....");
    }
}
