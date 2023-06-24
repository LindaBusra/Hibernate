package com.hb05.uni_manytoone;

import com.hb04.bi_onetoone.Diary;
import com.hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {


        //create University objects
        Student05 student1 = new Student05();
        student1.setId(1001L);
        student1.setName("Jace");

        Student05 student2 = new Student05();
        student2.setId(1002L);
        student2.setName("John");

        Student05 student3 = new Student05();
        student3.setId(1003L);
        student3.setName("Mark");



        //create University objects
        University university = new University();
        university.setId(101L);
        university.setName("XYZ University");


        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University.class)
                .addAnnotatedClass(Student05.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();



        session.saveOrUpdate(student1);
        session.saveOrUpdate(student2);
        session.saveOrUpdate(student3);
        session.saveOrUpdate(university);



        tx.commit();
        session.close();
        sessionFactory .close();



    }
}
