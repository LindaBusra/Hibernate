package com.myExercises.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_company")
public class Company {

    @Id
    private int id;

    private String name;

    private int year;


    @OneToOne(mappedBy = "company") // mappedBy attributes will not create any column in dairy class
    // instead it will use the column from dairy class which named as "company"
    private DiaryForCustomer diary;


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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public DiaryForCustomer getDiary() {
        return diary;
    }

    public void setDiary(DiaryForCustomer diary) {
        this.diary = diary;
    }

    //toString()


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
//                ", diary=" + diary +
                '}';
    }
}

//bir class cagrildiginda toString'teki diger class cagiriliyor. Diger class cagrildiginda aynı islem gerceklestigi icin StackOverflowError alabiliriz,
//o yuzden 69. satiri comment satirina aldim