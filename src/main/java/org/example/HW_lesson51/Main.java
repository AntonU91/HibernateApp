package org.example.HW_lesson51;

import org.example.HW_lesson51.models.Director;
import org.example.HW_lesson51.models.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            //1.С помощью Hibernate получите любого режиссера, а затем получите список
            //его фильмов
//
//            Director guyRitchie = session.get(Director.class, 3);
//            System.out.println(guyRitchie);
//            List<Movie> movieList = guyRitchie.getMovieList();
//
//            movieList.forEach(movie -> System.out.println(movie));
            ///
            /// 2. Получите любой фильм, а затем получите его режиссера.
//          Movie movie=  session.get(Movie.class, 10);
//            System.out.println(movie);
//            System.out.println(movie.getMovieDirector());
            //
            // 3. Добавьте еще один фильм для любого режиссера.
//            Movie movie = new Movie("The Gentlemen", 2019);
//            Director director = session.get(Director.class, 3);
//            movie.setMovieDirector(director);
//            director.addMovie(movie);
//            session.save(movie);
            //
            // 4. Создайте нового режиссера и новый фильм и свяжите эти сущности
//            Director director = new Director("George Lucas", 78);
//            Movie movie = new Movie("Star Wars Episode I: The Phantom Menace", 1991);
//            director.addMovie(movie);
//            movie.setMovieDirector(director);
//            session.save(director);
//            session.save(movie);
            //
            // 5. Смените режиссера у существующего фильма.
//            Movie movie = session.get(Movie.class, 13);
//            Director director =  session.get(Director.class, 6);
//            movie.setMovieDirector(director);
//            director.addMovie(movie);
            //
            // 6. Удалите фильм у любого режиссера.
            Director director = session.get(Director.class, 1);
            Movie movie = session.get(Movie.class, 1);
            director.deleteMovie(movie);
            session.delete(movie);
            // 7. Сделать комит проекта и отработать пример с каскадированием






            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
