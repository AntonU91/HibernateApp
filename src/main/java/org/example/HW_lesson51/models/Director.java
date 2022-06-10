package org.example.HW_lesson51.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Director() {
    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @OneToMany(mappedBy = "movieDirector", fetch = FetchType.LAZY) // todo came back after practice Lazy loading
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    // todo check correct work of method "addMovie"
    public void addMovie(Movie movie) {
        if (movieList == null) movieList = new ArrayList<>();
        movieList.add(movie);
        movie.setMovieDirector(this);
    }
    // todo check correct work of method "deleteMovie"
    public void deleteMovie(Movie movie) {
        movieList.remove(movie);
        movie.setMovieDirector(null);
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
