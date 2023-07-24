package com.myExercises.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchEmployee01 {

    public static void main(String[] args) {

        //introducing configuration file and entity class to hibernate

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee01.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Employee01 employee1 = session.get(Employee01.class, 1001);
        System.out.println(employee1);
        System.out.println(employee1.getAddress());
        System.out.println(employee1.getJob());
        System.out.println(employee1.getName());

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
