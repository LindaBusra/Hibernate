package com.hb14.entitylifecycle.somemethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchEmployee {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("get method call");
        Employee employee1 = session.get(Employee.class, 1L);

        System.out.println("Delete method is called...");
        session.delete(employee1);




        tx.commit();
        session.close();
        sessionFactory.close();
    }

}


