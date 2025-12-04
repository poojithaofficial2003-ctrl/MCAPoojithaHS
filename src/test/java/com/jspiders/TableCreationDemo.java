package com.jspiders;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TableCreationDemo {
    public static void main(String[] args) {
        System.out.println("Program stars...");
        System.out.println("Loading configuration..");
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        System.out.println("Build sessionfactory..");
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("Open session");
        Session session = sessionFactory.openSession();
         //logics
        System.out.println("Execute logics");
        session.close();
        System.out.println("Closed session");
        sessionFactory.close();
        System.out.println("Closed sessionFactory");

    }
}
