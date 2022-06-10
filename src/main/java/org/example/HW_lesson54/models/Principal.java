package org.example.HW_lesson54.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "principal")
public class Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToOne (mappedBy = "principal")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private School school;

    public Principal() {
    }

    public Principal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
