package com.hb14.entitylifecycle.somemethod;

import javax.persistence.*;

@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private Double salary;


    //some method
    @PrePersist
    public void OnPrePersist(){

        System.out.println("------------Before data object being persist---------------------");
    }


    @PostPersist
    public void OnPostPersist(){

        System.out.println("------------After data object being persist---------------------");
    }

    @PostLoad
    public void OnPostLoad(){

        System.out.println("------------After Loading data---------------------");
    }

    @PreRemove
    public void OnPreRemove(){

        System.out.println("------------Before data object being remove---------------------");
    }


    @PostRemove
    public void OnPostRemove(){

        System.out.println("------------After data object being remove---------------------");
    }

    //getter-setter

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    //toString()

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
