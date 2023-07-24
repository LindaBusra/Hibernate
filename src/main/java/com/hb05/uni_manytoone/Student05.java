package com.hb05.uni_manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

//why student includes manyToOne (university not)
//it is not easy to manage to store students data in university
//we store university information in student.

@Entity
@Table(name="t_student05")
public class Student05 {

    @Id
    private Long id;

    @Column(name = "std_name",length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="univ_id")
    private University university;

    private LocalDateTime registerDate;


    @PrePersist      //Run this method, the time you send this to the DB  (not the time you created it)
    public void prePersist(){
        registerDate = LocalDateTime.now();
    }


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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }


    //toString()

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university=" + university +
                ", registerDate=" + registerDate +
                '}';
    }
}
