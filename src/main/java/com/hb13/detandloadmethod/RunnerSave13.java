package com.hb13.detandloadmethod;

import com.hb12.cashing.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        //create object:
        Student13 student1 = new Student13();
        student1.setName("John");
        student1.setGrade(95);

        Student13 student2 = new Student13();
        student2.setName("Jace");
        student2.setGrade(90);

        Student13 student3 = new Student13();
        student3.setName("Mark");
        student3.setGrade(96);


        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student13.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sessionFactory.close();
    }
}

