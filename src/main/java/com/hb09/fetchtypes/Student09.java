package com.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*

         1. if next side is Many then default type is Lazy.  Student is One, Book is Many side here.  Student is LAzy here
             OneToMany
             ManyToMany
         2. If next side is One then default is EAGER.
             ManyToOne
             OneToOne
      */

@Entity
@Table(name = "t_student09")
public class Student09 {

//Student is Lazy
    @Id
    private Long id;

    @Column(name = "stu_name",nullable = false)
    private String name;

    private int grade;


    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, fetch = FetchType.EAGER)   //i dont need create a column, so I write mappedBy
    private List<Book09> bookList = new ArrayList<>();
    //CascadeType.ALL includes all type, like PERSIST, REMOVE
    //fetch = FetchType.EAGER   -->by default it is LAzy



    //getter-setter
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }


    //toString

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
