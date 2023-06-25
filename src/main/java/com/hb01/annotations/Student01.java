package com.hb01.annotations;

import javax.persistence.*;
import java.util.Arrays;

//Annotation are like interfaces  -->  public @interface Entity


@Entity                        //this class will be mapped to table. With Entity, we are creating a table in our database
@Table(name = "t_student01")   //to customize table name, we use it for rename table name
public class Student01 {       //default name of the table will be "Student01"

    @Id                        //The field under @Id will be Primary key. Necessary
    private int id;            //in pojo class access modifier of variables are private



    //@Column is optional
    @Column(name="student_name", length = 50, nullable = false, unique = false)
    private String name;            //by default variable name will be the column name
                                    //nullable = false --> I should write something



   //@Transient      //making it not appear on the DB, as a column, this field will not be added to the table
    //@id  if we want to make grade primary key, we have to write @id above it
    private int grade;

//    @Lob            //Holds big values, large data.  like images
//    private byte[] image;




    //Constructors

    public Student01(){

    }



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


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }




    //toString


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
