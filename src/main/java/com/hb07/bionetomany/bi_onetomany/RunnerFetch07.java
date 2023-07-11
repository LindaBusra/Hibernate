package com.hb07.bionetomany.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book07.class)
                .addAnnotatedClass(Student07.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //Get the student with ID 1001, using method
        Student07 student1 = session.get(Student07.class, 1001L);
//        System.out.println(student1);

        //Get the books of student1
//        List<Book07> bookList = student1.getBookList();
//        System.out.println(bookList);
//        student1.getBookList().forEach(stu-> System.out.println(stu));      //2.nd way


        //Get the book with ID:101
        Book07 book1 = session.get(Book07.class, 101L);
        System.out.println("Book 1: " + book1);

        //Get the student information from the book object:
//        System.out.println(book1.getStudent());


        // Fetch the assigned student name and book names, using SQL from Student
        String sqlQuery1 = "SELECT s.stu_name, b.name FROM t_student07 s INNER JOIN t_book07 b ON s.id=b.stu_id";    //Book class line 19     @JoinColumn(name = "stu_id")
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();

        for(Object[] obj :  resultList1) {
            System.out.println(Arrays.toString(obj));
        }



        System.out.println("=====================================================================================");



        //Do the upper task with HQL
        String hqlQuery1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN Book07 b ON s.id=b.student.id";    //Book class line 19     @JoinColumn(name = "stu_id")
        List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();                            //b.student.id-->in book class, in student, go to id

        for(Object[] obj :  resultList2) {
            System.out.println(Arrays.toString(obj));
        }

        //or
//        resultList2.forEach(obj-> System.out.println(obj));
//        resultList2.forEach(System.out::println);

        //Delete all the records from Book07 with SQL
//        String sqlQuery2 = "DELETE FROM t_book07";
//        int deletedRowCount = session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Deleted Row count: " + deletedRowCount);

        //Delete all the records from Student07 with HQL
//        String hqlQuery2 = "DELETE FROM Student07";
//        int deletedRowCount2 = session.createQuery(hqlQuery2).executeUpdate();         //here I use remove
//        System.out.println("Deleted Row count: " + deletedRowCount2);

        /*
        A Book (0)      -> Student07.getBookList().set(0, null);
        B Book (1)      ->
         */

        System.out.println("---------------------------------------------");

        student1.getBookList().set(0, null);        //orphan removal



        System.out.println("----------------------------------------------------------");

// write a HQL query which will  bring students whose book name has word "Arts";

        // Write an HQL Query, which will bring students whose book name contains the word "Book".
        String hqlQuery3 = "SELECT s FROM Student07 s JOIN s.bookList b WHERE b.name LIKE '%Book%'";
        List<Student07> resultList3 = session.createQuery(hqlQuery3, Student07.class).getResultList();
        for (Student07 stu : resultList3){
            System.out.println(stu);
        }


// write a HQL query which will  bring students whose book name has word "Arts";


        tx.commit();
        session.close();
        sessionFactory .close();


    }
}
