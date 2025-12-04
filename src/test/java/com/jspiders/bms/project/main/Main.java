package com.jspiders.bms.project.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program sarts ....");
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Auditorium audi1 = new Auditorium();
        AudiAddress audiAddress1 = new AudiAddress();

        audi1.setName("Audi-1");
        audi1.setSeat_rows(30);
        audi1.setSeat_columns(6);

        audiAddress1.setStreetName("street-1");
        audiAddress1.setAreaName("area-1");
        audiAddress1.setCity("city-1");
        audiAddress1.setPincode(498839);

        audi1.setAudiAddress(audiAddress1);

        session.persist(audi1);
        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("Program ends ....");
    }
}
