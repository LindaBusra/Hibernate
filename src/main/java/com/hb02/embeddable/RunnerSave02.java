package com.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

        Student02 student1 = new Student02();
        student1.setId(1);
        student1.setName("Jace");
        student1.setGrade(90);

        Address address = new Address("Apple Street", "New York", "USA", "01-001");
        student1.setAddress(address);
        //or
//        student1.setAddress(new Address("Apple Street", "New York", "USA", "01-001"));



        Student02 student2 = new Student02();
        student2.setId(2);
        student2.setName("John");
        student2.setGrade(90);
        student2.setAddress(new Address("Queens", "New York", "USA", "01-001"));



        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sessionFactory = con.buildSessionFactory();  //create session
        Session session = sessionFactory.openSession();     //create our room
        Transaction transaction = session.beginTransaction();


        session.saveOrUpdate(student1);
        session.saveOrUpdate(student2);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
