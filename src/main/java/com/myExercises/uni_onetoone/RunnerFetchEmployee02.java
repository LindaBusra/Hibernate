package com.myExercises.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchEmployee02 {

    public static void main(String[] args) {

//introducing configuration file and entity class to hibernate

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee02.class)
                .addAnnotatedClass(Job02.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("using get() fetch Employee");
        Employee02 employee1 = session.get(Employee02.class, 1001);
        System.out.println(employee1);

        System.out.println("\n\nusing get() fetch Job03");
        Job02 job1 = session.get(Job02.class, 101);
        System.out.println(job1);

        System.out.println("\n\nusing get() fetch employee from job");
        System.out.println(job1.getEmployee());

        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
