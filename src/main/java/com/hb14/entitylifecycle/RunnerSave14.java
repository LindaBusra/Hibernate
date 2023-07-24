package com.hb14.entitylifecycle;

import com.hb13.detandloadmethod.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student14.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        Student14 student1 = new Student14();   //Transients state. Hibernate has no responsibility
        student1.setName("John");
        student1.setGrade(90);

        session.save(student1);     //persistent state... hibernate will track with my object

//        //update name
        student1.setName("Mike");       //I updated the name, name will be Mike on DB

//        //I can get bach the changing:
//        //session.close();          //1.way
        session.evict(student1);    //2.way   detached state

        student1.setName("Mary");        //detached state obj will be taken in persistent state.

        session.merge(student1);



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
