package com.myExercises.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveEmployee01 {

    public static void main(String[] args) {


        //create employee object
        Employee01 employee1 = new Employee01();
        employee1.setName("Leonora");
        employee1.setId(1001);
        employee1.setJob("Teacher");

        Employee01 employee2 = new Employee01();
        employee2.setName("Ada");
        employee2.setId(1002);
        employee2.setJob("Doctor");

        Employee01 employee3 = new Employee01();
        employee3.setName("Nora");
        employee3.setId(1003);
        employee3.setJob("Artist");

        Employee01 employee4 = new Employee01();
        employee4.setName("Magdele");
        employee4.setId(1004);
        employee4.setJob("Student");


        //create address object
        Address address1= new Address();
        address1.setCity("Oslo");
        address1.setCountry("Norway");
        address1.setZipCode("5531");

        Address address2= new Address();
        address2.setCity("Haugesund");
        address2.setCountry("Norway");
        address2.setZipCode("4031");

        Address address3= new Address();
        address3.setCity("Bergen");
        address3.setCountry("Norway");
        address3.setZipCode("6600");

        Address address4= new Address();
        address4.setCity("Copenhagen");
        address4.setCountry("Denmark");
        address4.setZipCode("4000");

        employee1.setAddress(address1);
        employee2.setAddress(address2);
        employee3.setAddress(address3);
        employee4.setAddress(address4);


        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee01.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(employee1);
        session.saveOrUpdate(employee2);
        session.saveOrUpdate(employee3);
        session.saveOrUpdate(employee4);


        transaction.commit();       //without commit() data will not be sent to DB
        session.close();
        sessionFactory.close();
    }
}
