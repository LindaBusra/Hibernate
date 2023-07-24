package com.hb14.entitylifecycle.somemethod;

import com.hb14.entitylifecycle.Student14;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveEmployee {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Tom Hanks");
        employee1.setSalary(9000.0);



        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        session.save(employee1);


        tx.commit();
        session.close();
        sessionFactory.close();
    }

}



