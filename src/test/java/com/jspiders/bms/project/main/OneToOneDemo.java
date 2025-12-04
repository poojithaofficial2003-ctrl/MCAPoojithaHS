package com.jspiders.bms.project.main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

        static SessionFactory sessionFactory;

        static
        {
            //Step : Load Configuration
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            //Step : Build SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        }

        public static void addAudiAddress()
        {
            Session session = sessionFactory.openSession();

            //Step : Begin Transaction
            Transaction transaction = session.beginTransaction();

            Auditorium audi1 = new Auditorium();
            AudiAddress audiAddress = new AudiAddress();

            audi1.setName("Audi-1");
            audi1.setSeat_rows(30);
            audi1.setSeat_columns(6);

            audiAddress.setStreetName("street-1");
            audiAddress.setAreaName("HBR");
            audiAddress.setCity("BLR");
            audiAddress.setPincode(678912);

            //Linking Audi to AudiAddress
            audi1.setAudiAddress(audiAddress);

            //Save--> Insert
            session.persist(audi1);

            //Step : Commit transacton
            transaction.commit();

            session.close();
        }

        //select
        public static void getAudiDetails(Long id)
        {
            Session session = sessionFactory.openSession();

            //begin transaction
            Transaction transaction = session.beginTransaction();

            //find audi details
            Auditorium a1 = session.find(Auditorium.class,id);//Select * from audi where id = 2

            System.out.println();

            System.out.println("============Audi Details===========");
            System.out.println("Id           : "+a1.getId());
            System.out.println("Name         : "+a1.getName());
            System.out.println("Seat Rows    : "+a1.getSeat_rows());
            System.out.println("Seat Columns : "+a1.getSeat_columns());

            System.out.println("Street    : "+a1.getAudiAddress().getStreetName());
            System.out.println("Area      : "+a1.getAudiAddress().getAreaName());
            System.out.println("City      : "+a1.getAudiAddress().getCity());
            System.out.println("PINCODE   : "+a1.getAudiAddress().getPincode());
            System.out.println("============Audi Details===========");

            System.out.println();

            transaction.commit();
            session.close();
        }

        public static void getAudiAddressDetails(Long id)
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            AudiAddress ad1 = session.find(AudiAddress.class,id);
            System.out.println("Id         :"+ad1.getId());
            System.out.println("StreetName      : "+ad1.getStreetName());
            System.out.println("Area      "+ad1.getAreaName());
            System.out.println("City     :"+ad1.getCity());
            System.out.println("Pincode     :"+ad1.getPincode());


            System.out.println("============Audi Details===========");

            System.out.println("Id            :"+ad1.getAuditorium().getId());
            System.out.println(ad1.getAuditorium().getName());
            System.out.println(ad1.getAuditorium().getSeat_rows());
            System.out.println(ad1.getAuditorium().getSeat_columns());

        }

        public static void main(String[] args) {

            System.out.println("Program starts...");

            //addAudiAddress();

            getAudiDetails(2l);

            //Step : Close SessionFactory
            sessionFactory.close();

            System.out.println("Program ends...");

        }
    }
