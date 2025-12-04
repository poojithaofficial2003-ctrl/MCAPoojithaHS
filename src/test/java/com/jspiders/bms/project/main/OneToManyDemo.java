package com.jspiders.bms.project.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo {

    static SessionFactory sessionFactory;

    static
    {
        //Step : Load Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Step : Build SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }
    public static void saveAudi(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Creating auditorium");
        Auditorium a1 = new Auditorium();
        a1.setName("Audi-10");
        a1.setSeat_rows(50);
        a1.setSeat_columns(30);
        System.out.println("Creating show-1");
        Shows s1 = new Shows();
        s1.setShowTime(LocalDate.now());
        s1.setEndTime(LocalDate.now());
        s1.setStatus("AVAILABLE");

        System.out.println("Creating show-2");
        Shows s2 = new Shows();
        s2.setShowTime(LocalDate.now());
        s2.setEndTime(LocalDate.now());
        s2.setStatus("AVAILABLE");


        a1.getShows().add(s1);
        a1.getShows().add(s2);

        System.out.println("save audi");
        session.persist(a1);
        transaction.commit();
        session.close();


        //Step : Close SessionFactory



    }

    public static void getShowsByAudi(Long AudiId){
        Session  session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Getting shows by Audi");
        Auditorium auditorium = session.find(Auditorium.class,AudiId);
        List<Shows> shows =  auditorium.getShows();
        System.out.println("======================= SHOW DETAILS ================");
        for(int i=0;i <= shows.size()-1;i++){
            System.out.println();
            System.out.println(shows.get(i).getShowTime());
            System.out.println(shows.get(i).getEndTime());
            System.out.println(shows.get(i).getStatus());
            System.out.println();
        }
        System.out.println("======================= SHOW DETAILS ================");
        transaction.commit();
        session.close();
    }
    public static  void addShow(Long audiId){
        Session  session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Adding show to Audi");
        Shows show = new Shows();
        show.setShowTime(LocalDate.now());
        show.setEndTime(LocalDate.now());
        show.setStatus("new-show -1");
        System.out.println("Finding  audi with "+audiId);
        Auditorium a1 = session.find(Auditorium.class,audiId);
        a1.getShows().add(show);

        session.persist(show);
        System.out.println("Adding show to Audi");

        transaction.commit();
        session.close();
    }
    public static void deleteShow(Long audiId,Long showId){
        Session  session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       Auditorium a1 = session.find(Auditorium.class,audiId);
        Shows s1 = session.find(Shows.class,showId);

        List<Shows> shows = a1.getShows();
        for(int i=0;i<=shows.size()-1;i++){
            if(shows.get(i).getId() == showId){
                shows.remove(i);
                break;
            }
        }
        session.merge(a1);
//        session.remove(s1);
        transaction.commit();
        session.close();

    }

    public static void main(String[] args) {

        System.out.println("Program starts...");
//       saveAudi();
//        getShowsByAudi(5l);
//        addShow(5l);
        deleteShow(7l,7l);
        sessionFactory.close();
        System.out.println("Program ends...");

    }
}
