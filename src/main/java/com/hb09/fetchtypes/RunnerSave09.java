package com.hb09.fetchtypes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {


        //create Student objects
        Student09 student1 = new Student09();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student09 student2 = new Student09();
        student2.setId(1002L);
        student2.setName("John");
        student2.setGrade(90);

        Student09 student3 = new Student09();
        student3.setId(1003L);
        student3.setName("Mark");
        student3.setGrade(90);


        //create Book objects
        Book09 book1 = new Book09();
        book1.setId(101L);
        book1.setName("Math Book");

        Book09 book2 = new Book09();
        book2.setId(102L);
        book2.setName("Physics Book");

        Book09 book3 = new Book09();
        book3.setId(103L);
        book3.setName("Chemistry Book");

        Book09 book4 = new Book09();
        book4.setId(104L);
        book4.setName("Java Book");

        Book09 book5 = new Book09();
        book5.setId(105L);
        book5.setName("Hibernate Book");

        //set students to the books
        // the owner relation  is book class , so we have to set otherwise foreign key will be null

        book1.setStudent(student1);
        book2.setStudent(student1);

        book3.setStudent(student2);
        book4.setStudent(student2);

        book5.setStudent(student3);

        //If you use CascadeType.PERSIST, you need to set the other side of the relation too.
        //Set the Books to the students
        //Since we are using CaseCadeType.PERSIST we have to sett books to the students

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);
        student2.getBookList().add(book4);

        student3.getBookList().add(book5);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        //save students
        session.save(student1);
        session.save(student2);
        session.save(student3);

        //save books

        //When we use cascade = CascadeType.ALL(PERSIST)  we do not need to store child class
        //You don't necessarily need to save the other objects too in a relations
        //if you try to save books you will not give any Exception .
//        session.save(book1);
//        session.save(book2);
//        session.save(book3);
//        session.save(book4);
//        session.save(book5);


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}