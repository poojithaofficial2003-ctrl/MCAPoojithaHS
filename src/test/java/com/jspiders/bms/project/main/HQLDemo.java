package com.jspiders.bms.project.main;

import com.jspiders.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo {
    public static void main(String[] args) {
        System.out.println("Program starts.....");
        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("SessionFactory created");

        //get session from session factory
        Session session = sessionFactory.openSession();
        System.out.println("session created");

//        String selectByName_HQL = "FROM Movie mv WHERE mv.status= 'AVAILABLE'";
//        Query<Movie> query = session.createQuery(selectByName_HQL, Movie.class);
//        List<Movie> movie = query.getResultList();
//       for(Movie mov: movie){
//           System.out.println(mov);
//       }

        Scanner sc = new Scanner(System.in);
        String selectByName_HQL2 = "FROM Movie mv WHERE mv.status= :status";
        Query<Movie> query2 = session.createQuery(selectByName_HQL2, Movie.class);
        System.out.println("Enter movie status to search");
        String status = sc.next();
        query2.setParameter("status",MovieStatus.valueOf(status));
        List<Movie> movie2 = query2.getResultList();
        for(Movie mov2: movie2){
            System.out.println(mov2);
        }

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

