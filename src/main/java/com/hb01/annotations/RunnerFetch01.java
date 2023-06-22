package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);        //which class we are going to use

        SessionFactory sessionFactory = con.buildSessionFactory();  //create session
        Session session = sessionFactory.openSession();     //create our room
        Transaction transaction = session.beginTransaction();

        /*
        In order to fetch data from DB, there are three ways:
        1-get();
        2-SQL query
        3-HQL Query

         */

        //with get()
//        Student01 student1 = session.get(Student01.class,1 )   ;      // data type, Primary Key value --> get(which class I get data,primary key value in my case )
//        Student01 student2 = session.get(Student01.class,2 )   ;
//        Student01 student3 = session.get(Student01.class,3 )   ;
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);



        //with SQL query
//        String  sqlQuery1 = "SELECT*FROM t_student01";
//        List<Object [] > resultList =  session.createSQLQuery(sqlQuery1).getResultList();   //Object [] because we have in array three objects like that {1,"Jack", 90}
//
//
//        for(Object[] stu :  resultList) {
//            System.out.println(Arrays.toString(stu));
//        }



        //with HQL Query
//        String hqlQuery1 = "FROM Student01";
//        List<Student01> students = session.createQuery(hqlQuery1, Student01.class).getResultList();
//
//        System.out.println(students);
//
//        for(Student01 stu :  students) {
////            System.out.println(stu);
//        }



        //TASKS-1   with SQL
        //Get the student with the name John, as a unique result

//        String sqlQuery2 = "SELECT*FROM t_student01 WHERE student_name='John'";
//        Object[] stu1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(stu1));


        //TASKS-2 with HQL
        //Get the student with the name John, as a unique result in HQL (with Aliases)
//        String hqlQuery2 = "FROM Student01 s WHERE s.name='John' ";
//        Student01 student2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(student2);



        //TASKS-3 with HQL
        //Get the name and id's of students whose ids are less than 3, in HQL, using aliases
        //if we get specific columns write SELECT ...   otherwise write just FROM...
//        String hqlQuery3 = "SELECT s.name, s.id FROM Student01 s WHERE s.id<3"; //in HQL just write  the names
//        List<Object []> stuList = session.createQuery(hqlQuery3).getResultList();
//
//        for(Object[] stu :  stuList) {
//            System.out.println(Arrays.toString(stu));
//        }



        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
