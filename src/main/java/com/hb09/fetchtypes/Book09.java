package com.hb09.fetchtypes;

import javax.persistence.*;

@Entity
@Table(name = "t_book09")
public class Book09 {

    @Id
    private Long id;

    private String name;


    @ManyToOne   //book is many side, student is one side
    @JoinColumn(name = "stu_id")
    private Student09 student;          //Book is owner side, no need for list

    //getter and setter

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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", student=" + student +
                '}';
    }
}
