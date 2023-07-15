package com.hb07.bionetomany.bi_onetomany_NT;

import javax.persistence.*;

//this is many side

@Entity
@Table(name="tbl_book07")
public class Book07 {

    @Id
    private int id;

    private String name;



    @ManyToOne
    @JoinColumn(name = "std_id")        //we change foreign_key column name
    private Student07 student;


    //constructor

    public Book07() {
    }

    public Book07(int id, String name) {
        this.id = id;
        this.name = name;
    }

//getter- setter


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

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", student=" + student +
                '}';
    }
}
