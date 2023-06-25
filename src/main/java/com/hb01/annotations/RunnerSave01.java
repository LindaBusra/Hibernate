package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//this class is used to store objects to database
public class RunnerSave01 {

    public static void main(String[] args) {

        //Hibernate : advance form of JDBC to communicate database

        //Create objects from Student01 class
        Student01 student1 = new Student01();
        student1.setId(1);
        student1.setName("Jace");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(2);
        student2.setName("John");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(3);
        student3.setName("Mark");
        student3.setGrade(90);



        //introducing configuration file and entity class to hibernate
        ////Configuration coming from org.hibernate.cfg
        //Specifying the configuration file, and the class that I would like to use this configuration with to Hibernate
        //to save these objects:

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);


        //to open my room, like just design patterns, I need these steps
        SessionFactory sf = con.buildSessionFactory();  //create session
        Session session = sf.openSession();     //create our room
        Transaction tx = session.beginTransaction();        //transaction:actions you will make it in your session
                                                            //getting your codes with transaction


        //to save an object to your database
        session.saveOrUpdate(student1);
        session.saveOrUpdate(student2);
        session.saveOrUpdate(student3);


        tx.commit();  //without commit() data will not be sent to DB
        session.close();
        sf.close();





    }
}
