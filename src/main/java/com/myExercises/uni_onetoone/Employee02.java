package com.myExercises.uni_onetoone;

import com.myExercises.embeddable.Address;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="t_employee02")
public class Employee02 {


    @Id
    private int id;

    @Column(name="employee_name", length=50, unique=false, nullable = false)
    private String name;

    private String job;


    //constructor
    public Employee02(){

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




    //toString()

    @Override
    public String toString() {
        return "Employee03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
