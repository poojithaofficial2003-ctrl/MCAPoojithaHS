package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ConnectionDemo {
    public static void main(String[] args) {
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

        String selectByName_HQL = "FROM Users user WHERE user.name= 'poojitha'";
        Query<Users> query = session.createQuery(selectByName_HQL, Users.class);
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
}
