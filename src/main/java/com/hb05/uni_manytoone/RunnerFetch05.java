package com.hb05.uni_manytoone;

import com.hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University.class)
                .addAnnotatedClass(Student05.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //----------------------------------------------------------------------------

        //by using get method fetch Student object
        Student05 student1= session.get(Student05.class, 1001L);
        System.out.println(student1);


        //by using get method fetch University Object
        University university = session.get(University.class, 101L);
        System.out.println(university);


        //to access to the student's university
        System.out.println(student1.getUniversity());


        //Fetch the students whose university id is 101
        System.out.println("----students whose university id is 101----------");
        String hqlQuery = "FROM Student05 s WHERE s.university.id=101L";
        List<Student05> list =  session.createQuery(hqlQuery,Student05.class).getResultList();
        for(Student05 student: list) {
            System.out.println(student);
        }

        //or
        list.forEach(obj-> System.out.println(obj));




        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sessionFactory.close();

    }
}
