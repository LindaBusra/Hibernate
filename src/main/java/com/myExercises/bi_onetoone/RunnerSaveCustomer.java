package com.myExercises.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveCustomer {

    public static void main(String[] args) {

        //create some objects
        Company company1 = new Company();
        company1.setId(1001);
        company1.setName("AteaA");
        company1.setYear(1990);

        Company company2 = new Company();
        company2.setId(1002);
        company2.setName("CapgeminiA");
        company2.setYear(1890);


        Company company3 = new Company();
        company3.setId(1003);
        company3.setName("SogetiA");
        company3.setYear(2000);


        //create DiaryForCustomer object
        DiaryForCustomer diary1 = new DiaryForCustomer();
        diary1.setId(101);
        diary1.setName("AteaA's diary");


        DiaryForCustomer diary2 = new DiaryForCustomer();
        diary2.setId(102);
        diary2.setName("CapgeminiA's diary");


        DiaryForCustomer diary3 = new DiaryForCustomer();
        diary3.setId(103);
        diary3.setName("SogetiA's diary");

        // Assigning companies to Diaries
        diary1.setCompany(company1);
        diary2.setCompany(company2);
        diary3.setCompany(company3);


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(DiaryForCustomer.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        session.saveOrUpdate(company1);
        session.saveOrUpdate(company2);
        session.saveOrUpdate(company3);

        session.saveOrUpdate(diary1);
        session.saveOrUpdate(diary2);
        session.saveOrUpdate(diary3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
