package org.example.HW_lesson54.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column (name = "school_number")
    private int number;

    @OneToOne
    @Cascade (org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principal;

    public School() {
    }

    public School(int number) {
        this.number = number;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", number=" + number +
                ", principal=" + principal +
                '}';
    }
}