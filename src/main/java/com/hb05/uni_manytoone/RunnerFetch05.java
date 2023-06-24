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



        //we are here



        //using get method fetch student and university Object
        Student05 student1 = session.get(Student05.class, 1001L);
        System.out.println(student1);

        System.out.println(student1.getUniversity());
        System.out.println(student1.getUniversity().getName());

        University university = session.get(University.class, 101L);
        System.out.println(university);


        //// fetch student whose university id is 101 using HQL
        System.out.println("fetch student whose university id is 101 using HQL");
        String hqlQuery = "FROM Student05 s WHERE s.university.id = 101L";
        List<Student05> resultList1 =  session.createQuery(hqlQuery,Student05.class).getResultList();
        resultList1.forEach(obj-> System.out.println(obj));


        //but it does not work
        List<Object[]> resultList2 =  session.createQuery(hqlQuery).getResultList();
        for(Object[] w: resultList2) {
            System.out.println(Arrays.toString(w));
        }

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sessionFactory.close();

    }
}
