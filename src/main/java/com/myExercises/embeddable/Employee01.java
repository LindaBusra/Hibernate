package com.myExercises.embeddable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="t_employee01")
public class Employee01 {


    @Id
    private int id;

    @Column(name="employee_name", length=50, unique=false, nullable = false)
    private String name;

    private String job;

    @Embedded
    private Address address;


    //constructor
    public Employee01(){

    }

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    //toString()

    @Override
    public String toString() {
        return "Employee01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", address=" + address +
                '}';
    }
}
