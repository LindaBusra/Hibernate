package com.myExercises.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveKids {

    //this class is used to store objects to database
    public static void main(String[] args) {


        //Create objects from Kids class
        Kids kid1 = new Kids();
        kid1.setName("Emily");
        kid1.setId(1);
        kid1.setAge(5);

        Kids kid2 = new Kids();
        kid2.setName("Denis");
        kid2.setId(2);
        kid2.setAge(7);

        Kids kid3 = new Kids();
        kid3.setName("Anna");
        kid3.setId(3);
        kid3.setAge(8);


        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Kids.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(kid1);
        session.saveOrUpdate(kid2);
        session.saveOrUpdate(kid3);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
