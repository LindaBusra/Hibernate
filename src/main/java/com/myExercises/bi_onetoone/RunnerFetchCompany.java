package com.myExercises.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchCompany {

    public static void main(String[] args) {


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(DiaryForCustomer.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println(" get company and Dairy by Id using get() method ");

        Company company1 = session.get(Company.class, 1001);
        System.out.println(company1);
        System.out.println("\n");


        DiaryForCustomer diary1 = session.get(DiaryForCustomer.class, 101);
        System.out.println(diary1);


        System.out.println(" get dairy object over company ");
        System.out.println(company1.getDiary());

        System.out.println(" get company  object over dairy ");
        System.out.println(diary1.getCompany());

        System.out.println(" get company name, year, id  through dairy object ");
        System.out.println("company name: " + diary1.getCompany().getName());
        System.out.println("company year: " + diary1.getCompany().getYear());
        System.out.println("company id: " + diary1.getCompany().getId());


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
