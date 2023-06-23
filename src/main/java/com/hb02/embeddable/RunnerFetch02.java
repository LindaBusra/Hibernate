package com.hb02.embeddable;

import com.hb01.annotations.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

    public static void main(String[] args) {

        //Getting the Configuration
        Configuration con = new Configuration()    //get Configuration from org.hibernate.cfg
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);        //which class we are going to use

        SessionFactory sessionFactory = con.buildSessionFactory();  //create session
        Session session = sessionFactory.openSession();     //session is interface, it means create our room
        Transaction transaction = session.beginTransaction();       //Transaction coming from org.hibernate


        //Create data
        Student02 student1= session.get(Student02.class, 1);
        System.out.println(student1);

        //get address for this student
        System.out.println(student1.getAddress());




        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
