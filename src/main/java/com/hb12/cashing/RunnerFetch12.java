package com.hb12.cashing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student12.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("First get method for student whose Id is 1L");
        Student12 student1 = session.get(Student12.class, 1L);

        //session.clear();        //it is clear cash memory, if we don't use this, it gets one query


        System.out.println("Second get method for student whose Id is 1L");
        Student12 student2 = session.get(Student12.class, 1L);

        tx.commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();

        System.out.println("Third get method for student whose Id is 1L");
        Student12 student3 = session2.get(Student12.class, 1L);

        tx2.commit();
        session2.close();
        sessionFactory.close();
    }
}
