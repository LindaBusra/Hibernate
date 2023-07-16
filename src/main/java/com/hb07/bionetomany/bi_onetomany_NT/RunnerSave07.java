package com.hb07.bionetomany.bi_onetomany_NT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {

    public static void main(String[] args) {

        //Student07 obj using parameters
        Student07 student1 = new Student07(1001, "Emily", 95);

        //Student07 obj empty constructor
        Student07 student2 = new Student07();
        student2.setId(1002);
        student2.setName("John");
        student2.setGrade(90);

        //create book object
        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Math Book");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("Chemistry Book");

        Book07 book3 = new Book07();
        book3.setId(103);
        book3.setName("Arts Book");


        //set book to student
        //when we use mappedBy, the owner of relationship will be book side.
//        student1.getBookList().add(book1);
//        student1.getBookList().add(book2);

        //set student to book
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);



        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book07.class)
                .addAnnotatedClass(Student07.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        session.save(book1);
        session.save(book2);
        session.save(book3);




        tx.commit();
        session.close();
        sessionFactory .close();

    }
}
