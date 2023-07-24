package com.myExercises.uni_onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_job")
public class Job02 {        // this will be default "job"

    @Id
    private int id;

    private String name;

    @OneToOne       // in my Job Table new column be added with default name "employee_id"
    @JoinColumn(name="employee_id")
    private Employee02 employee;

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

    public Employee02 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee02 employee) {
        this.employee = employee;
    }


    //toString

    @Override
    public String toString() {
        return "DiaryForCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
