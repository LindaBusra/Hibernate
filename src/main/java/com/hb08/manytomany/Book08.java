package com.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "t_book08")
public class Book08 {


    @Id
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "bookList")   //if I don't write mappedBy, hibernate will create a column for line 23
    //and we specifies, this is child class of the others.
    private List<Student08> students= new ArrayList<>();


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

    public List<Student08> getStudents() {
        return students;
    }

    public void setStudents(List<Student08> students) {
        this.students = students;
    }


    //to String method


    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", students=" + students +
                '}';
    }
}
