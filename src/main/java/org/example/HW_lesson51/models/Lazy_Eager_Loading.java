package org.example.HW_lesson51.models;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Lazy_Eager_Loading {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
//            Пример Eager Loading
            Movie movie = session.get(Movie.class, 3);
            System.out.println("Мы получили фильм");
            System.out.println(movie.getMovieDirector());
            //// Пример того что если у нас Eager Loading
            // то можно будет получить связанные сущности даже вне Persistence context
            Director director = session.get(Director.class, 1);


            session.getTransaction().commit();
            session.close();


          //  director.getMovieList().forEach(System.out::println); // если у нас EagerLoading то мы получили список фильмов
            // даже после закрытия persistence context так как он был подгружен здесь ->   Director director = session.get(Director.class, 1);
            //////////////////////////////////////////////////

            // Включаем опять LazyLoaading
            // создаем вторую сессию
            Session session1 = sessionFactory.getCurrentSession();
            session1.beginTransaction();
           director=(Director) session1.merge(director); // так как мы вышли из сессии то что б проводить
            // манипуляции с обьектом после после создания второй сессии, необходимо это  обьект замержить в новую сессию
          Hibernate.initialize(director.getMovieList());// подгружаем ленивые сущности
            session1.getTransaction().commit();

            System.out.println(director.getMovieList());


        }

//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.getTransaction().begin();
//
//
//
//
//
//            session.getTransaction().commit();
//        }





    }
}
