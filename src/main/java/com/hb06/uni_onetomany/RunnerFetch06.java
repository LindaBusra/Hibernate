package com.hb06.uni_onetomany;

import com.hb05.uni_manytoone.Student05;
import com.hb05.uni_manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student06.class)
                .addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        //Get the student with id 1001
        Student06 student1 = session.get(Student06.class, 1001L);
        System.out.println(student1);



        // Get/fetch the student's book id&name with id 1001 using HQL
        System.out.println("\n---------------------Get/fetch the student's book id&name with id 1001 using HQL--------------");

        //I can not use FETCH here, because I can not access students inside book class., but I can access from students to books
        //instead of access a class, I tried to access an object, so I removed FETCH keyword from this query.
        String hql1 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001L";
        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();

        for(Object[] objArr : resultList1) {
            System.out.println(Arrays.toString(objArr));
        }


        System.out.println("\n--------------Fetch the books of the student whose id is 1001 ---------------");

        //1.way
        System.out.println("\n----Second way--------");
        Student06 student2 = session.get(Student06.class, 1001L);
        System.out.println(student2.getBookList());


        //2.way
        List<Book> list = session.get(Student06.class,1001L).getBookList();

        for(Book w : list){

            System.out.println(w.getName());
        }


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
