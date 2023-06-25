package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        // Create the Students
        Student03 student1 = new Student03();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student03 student2 = new Student03();
        student2.setId(1002L);
        student2.setName("John");
        student2.setGrade(90);

        Student03 student3 = new Student03();
        student3.setId(1003L);
        student3.setName("Mark");
        student3.setGrade(90);


        // Create the Diaries
        Diary diary1 = new Diary();
        diary1.setId(101L);
        diary1.setName("Jace's DiaryForCustomer");

        Diary diary2 = new Diary();
        diary2.setId(102L);
        diary2.setName("John's DiaryForCustomer");

        Diary diary3 = new Diary();
        diary3.setId(103L);
        diary3.setName("Mark's DiaryForCustomer");


        // Set the Students
        diary1.setStudent(student1);
        diary2.setStudent(student2);
        diary3.setStudent(student3);


        // Hibernate
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Diary.class)
                .addAnnotatedClass(Student03.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.saveOrUpdate(student1);
        session.saveOrUpdate(student2);
        session.saveOrUpdate(student3);

        session.saveOrUpdate(diary1);
        session.saveOrUpdate(diary2);
        session.saveOrUpdate(diary3);

        tx.commit();
        session.close();
        sf.close();


    }
}