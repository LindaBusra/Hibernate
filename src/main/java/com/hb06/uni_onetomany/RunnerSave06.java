package com.hb06.uni_onetomany;

import com.hb05.uni_manytoone.Student05;
import com.hb05.uni_manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave06 {
    public static void main(String[] args) {


        //create students objects
        Student06 student1 = new Student06();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student06 student2 = new Student06();
        student2.setId(1002L);
        student2.setName("John");
        student2.setGrade(90);

        Student06 student3 = new Student06();
        student3.setId(1003L);
        student3.setName("Mark");
        student3.setGrade(90);



        //create Books objects
        Book book1 = new Book();
        book1.setId(101L);
        book1.setName("Math Book");

        Book book2 = new Book();
        book2.setId(102L);
        book2.setName("Hibernate Book");

        Book book3 = new Book();
        book3.setId(103L);
        book3.setName("Java Book");


        //1st way
//        List<Book> bookList = new ArrayList<>();
//        bookList.add(book1);
//        bookList.add(book2);
//        bookList.add(book3);
//
//        student1.setBookList(bookList);


        //2nd way
        student1.getBookList().add(book1);      //you can not give this book to two students sama time
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);



        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Student06.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();



        session.saveOrUpdate(student1);
        session.saveOrUpdate(student2);
        session.saveOrUpdate(student3);
        session.saveOrUpdate(book1);
        session.saveOrUpdate(book2);
        session.saveOrUpdate(book3);



        tx.commit();
        session.close();
        sessionFactory .close();

    }
}
