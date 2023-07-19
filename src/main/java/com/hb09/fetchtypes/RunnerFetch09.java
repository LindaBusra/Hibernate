package com.hb09.fetchtypes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //get students using get method ()
        Student09 student1=  session.get(Student09.class,1001L);
        //when we don't print it with sout, when I run it I have just one query

        //System.out.println(student1);   //because of toString we have bookList information
        //when I run it now there is to queries, one comes from student, the other ones comes from Book


        //I am just getting students  -->Lazy (just necessary information comes)
        //if fetch is EAGER-->it will select all and gets all (getting all information in one query)



        //So we called the student with ID 1001, but it didn't fetch the books at first. Why?
        //FetchTypes


        //get book using get method ()

//          Book09 book1=   session.get(Book09.class,102);
////            for (Book09 book2: student1.getBookList()){
////                System.out.println(book2);
////            }


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
