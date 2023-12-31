package com.hb07.bionetomany.bi_onetomany_NT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch07 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book07.class)
                .addAnnotatedClass(Student07.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();



        /*

        //fetch the student which id is 1001 using get()
        Student07 student1= session.get(Student07.class, 1001);
        System.out.println(student1);


        //using student object, get book
        System.out.println(student1.getBookList());

        //with Lambda expression
        student1.getBookList().forEach(std-> System.out.println(std));


        //fetch the book which id is 102 using get()
        Book07 book1= session.get(Book07.class, 102);
        System.out.println(book1);

        //using book, get students
        System.out.println(book1.getStudent());




        System.out.println("---------------------------------------");

        //Use INNER JOIN to fetch student name and book name using SQL from student who has book.
        //in sql we use these names: tbl_book07,, std_id is foreign key from student, for book
        String sqlQuery1= "SELECT s.std_name ,b.name FROM tbl_student07 s INNER JOIN tbl_book07 b ON s.id=b.std_id";

        List<Object[]>   resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
        resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));






        System.out.println("--------------------------------");

        //Use INNER JOIN to fetch student name and book name using HQL from student who has book.
        String hqlQuery1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN Book07 b ON s.id=b.student.id";
        List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();

        for(Object[] obj : resultList2) {
            System.out.println(Arrays.toString(obj));
        }



        System.out.println("--------------------deleted rows------------------");

        //Delete record from book07 using SQL
        String sqlQuery2= "DELETE FROM tbl_book07";
        int numOfDeletedRecord = session.createSQLQuery(sqlQuery2).executeUpdate();
        System.out.println("numOfDeletedRecord : " + numOfDeletedRecord);



        //Delete record from students07 using SQL
        String sqlQuery3= "DELETE FROM tbl_student07";
        int numOfDeletedRecord1 = session.createSQLQuery(sqlQuery3).executeUpdate();
        System.out.println("numOfDeletedRecord1 : " + numOfDeletedRecord1);


        //DELETE records from Book07 using HQL
        String hqlQuery2= "DELETE FROM Book07";
        System.out.println("numOfDeletedRecord2 : " + session.createQuery(hqlQuery2).executeUpdate());



        //DELETE records from Student07 using HQL
        String hqlQuery3= "DELETE FROM Student07";
        System.out.println("numOfDeletedRecord3 : " + session.createQuery(hqlQuery3).executeUpdate());




        // delete student object with get method() id 1001
        //1st way Cascade
        Student07 std = session.get(Student07.class, 1001);
//        System.out.println(std.getBookList());
        session.delete(std);




        // delete book object with get method() id 1002
        //2nd way OrphanRemove
        Student07 std2 = session.get(Student07.class, 1002);
        std2.getBookList().set(0, null);        //index 0, make it null   (it remove the line which has null, with hlep of orphan removal)

       */

// write a HQL query which will  bring students whose book name has word "Arts";
        String hqlQuery5="SELECT s FROM Student07 s JOIN s.bookList b WHERE b.name LIKE 'Arts'";
        List<Student07> resultList =  session.createQuery(hqlQuery5, Student07.class).getResultList();
        for (Student07 std :resultList){
            System.out.println(std);
        }


// write a HQL query which will  bring students whose book name has word "Arts";
        String hqlQuery6="SELECT s FROM Student07 s JOIN s.bookList b WHERE b.name LIKE '%Arts%'";
        List<Student07>  resultList2 =  session.createQuery(hqlQuery6, Student07.class).getResultList();
        for (Student07 std :resultList2){
            System.out.println(std);
        }


        tx.commit();
        session.close();
        sessionFactory .close();


    }
}
