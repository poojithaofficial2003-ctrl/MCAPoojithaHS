package com.jspiders.bms.project.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;
import java.util.Scanner;

public class HQLDemo3 {
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

        //sep :1 get criteria
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
        JpaCriteriaQuery<Movie> query = cb.createQuery(Movie.class);
        JpaRoot<Movie> table = query.from(Movie.class);
        JpaPredicate condition1 = cb.equal(table.get("status"), MovieStatus.AVAILABLE);
        JpaPredicate condition2 = cb.equal(table.get("title"), "K.G.F");

        query.select(table).where(condition1,condition2);

        Query<Movie> query1 = session.createQuery(query);
        List<Movie> movies = query1.getResultList();


        for(Movie movie : movies){
            System.out.println(movie);
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
