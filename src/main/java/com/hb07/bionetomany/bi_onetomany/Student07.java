package com.hb07.bionetomany.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student07")
public class Student07 {

    @Id
    private Long id;

    @Column(name = "stu_name", nullable = false)        //for SQL, we use this one
    private String name;            //for HQL, we use this one. In HQL I use object name and class name itself

    private int grade;


    @OneToMany (mappedBy = "student", orphanRemoval = true, cascade = CascadeType.REMOVE) //mappedBy is for not created a column which names is student_id
    private List<Book07> bookList = new ArrayList<>();
    //mappedBy = "student"-->this comes from Student class line 20
    //I have to make cascade for be able to clean Student. otherwise it requires to clean the child first
    //with CascadeType.REMOVE when I try to delete parent, it deletes child automatically


/*
        CascadeType.REMOVE: If the parent gets removed, children tables will get removed with it too.

        Cascade.PERSIST:    If a Student is saved, you don't need to save the books separately. (Only when you already set the books for the Student)
 */



    //constructor
    public Student07() {
    }

    public Student07(Long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;

    }


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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }


    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", bookList=" + bookList +            //I have to comment one of them, then or Book class line 59
                '}';
    }
}
