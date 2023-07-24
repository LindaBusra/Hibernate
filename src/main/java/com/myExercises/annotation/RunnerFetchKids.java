package com.myExercises.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//this class is used to read data
public class RunnerFetchKids {


    public static void main(String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Kids.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



/*  Inorder to fetch data from DB, there are 3 ways
    1. get();
    2. SQL query
    3. HQL query                         */



    //1.st way: get()
//    Kids kid1 = session.get(Kids.class, 1);
//    System.out.println("kid1: " + kid1);
//
//    Kids kid2 = session.get(Kids.class, 2);
//    System.out.println("kid2: " + kid2);
//
//    Kids kid3 = session.get(Kids.class,3);
//    System.out.println("kid3: " + kid3);



    //2nd way: SQL query
//    String query = "SELECT * FROM ourKids";
//
//    List<Object[]> resultList = session.createSQLQuery(query).getResultList();
//
//    for(Object[] w : resultList) {
//        System.out.println(Arrays.toString(w));
//    }



    //3rd way: HQL query
//    String hqlQuery = "FROM Kids";      //write class name
//    List<Kids> resultList2 = session.createQuery(hqlQuery, Kids.class).getResultList();
//
//    for (Kids w : resultList2){
//        System.out.println(w);
//    }



    //if you want to fetch some unique data using sql
//    String sqlQuery = "SELECT * FROM ourKids WHERE name='Denis'";
//    Object[] kidDenis = (Object[]) session.createSQLQuery(sqlQuery).uniqueResult();
//    System.out.println(Arrays.toString(kidDenis));
//    System.out.println("The id of student: " + kidDenis[0] +", the name of student: " + kidDenis[2]+", the age of student: " + kidDenis[1]);


    //if you want to fetch some unique data using hql
        String hqlQuery1 = "FROM Kids k WHERE k.name='Emily'";
        Kids kidEmily= session.createQuery(hqlQuery1, Kids.class).uniqueResult();
        System.out.println(kidEmily);


    //if you want to fetch students name and ids whose id is less 1003 using hql
//        String hqlQuery2 = "SELECT k.name, k.id FROM Kids k WHERE k.id<3";
//        List<Object[]> resultList = session.createQuery(hqlQuery2).getResultList();
//        resultList.forEach(t-> System.out.println(Arrays.toString(t)));


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
