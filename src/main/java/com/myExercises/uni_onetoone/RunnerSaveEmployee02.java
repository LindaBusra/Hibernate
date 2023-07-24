package com.myExercises.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveEmployee02 {

    public static void main(String[] args) {

        //create some objects
        Employee02 employee1 = new Employee02();
        employee1.setId(1001);
        employee1.setName("Nora");
        employee1.setJob("Teacher");

        Employee02 employee2 = new Employee02();
        employee2.setId(1002);
        employee2.setName("Emily");
        employee2.setJob("Police");

        Employee02 employee3 = new Employee02();
        employee3.setId(1003);
        employee3.setName("Ada");
        employee3.setJob("Lawyer");


        //create DiaryForCustomer object
        Job02 job1 = new Job02();
        job1.setId(101);
        job1.setName("Nora's job");
        job1.setEmployee(employee1);

        Job02 job2 = new Job02();
        job2.setId(102);
        job2.setName("Emily's job");
        job2.setEmployee(employee1);

        Job02 job3 = new Job02();
        job3.setId(103);
        job3.setName("Ada's job");
        job3.setEmployee(employee1);

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee02.class)
                .addAnnotatedClass(Job02.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(employee1);
        session.saveOrUpdate(employee2);
        session.saveOrUpdate(employee3);

        session.saveOrUpdate(job1);
        session.saveOrUpdate(job2);
        session.saveOrUpdate(job3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
