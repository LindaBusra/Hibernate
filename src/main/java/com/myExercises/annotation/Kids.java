package com.myExercises.annotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ourKids")
public class Kids {


    @Id
    private int id;

    private String name;

    private int age;


    public Kids(){

    }


    //getter-setter
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }


    //toString


    @Override
    public String toString() {
        return "Kids{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
