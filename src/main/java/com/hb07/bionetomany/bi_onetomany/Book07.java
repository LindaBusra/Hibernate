package com.hb07.bionetomany.bi_onetomany;

import javax.persistence.*;

//this is many side

@Entity
@Table(name="t_book07")
public class Book07 {

    @Id //PK
    private Long id;        //Non-primitive return default value: null

    private String name;



    @ManyToOne
    @JoinColumn(name = "stu_id")        //we change foreign_key column name, default name was student_id
    private Student07 student;          //I use this in Book class, in mappedBy = "student",


    //constructor



    //getter- setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                ", student=" + student +
                '}';
    }
}

