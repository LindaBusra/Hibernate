package com.myExercises.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_diaryForCustomer")
public class DiaryForCustomer {

    @Id
    private int id;

    private String name;


    @OneToOne   //company_id
    @JoinColumn(name="company_id", unique = true)
    private Company company;


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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    //toString()


    @Override
    public String toString() {
        return "DiaryForCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
