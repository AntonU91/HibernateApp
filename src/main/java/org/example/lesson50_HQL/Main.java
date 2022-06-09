package org.example.lesson50_HQL;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /// по умолчанию обьект класса Configuration читает информацию о конфигурацие
        // с файла hibernate.properties который находиться в папке resources
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        // создаем SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // создаем сессию
        Session session = sessionFactory.getCurrentSession();
        // открываем транзакцию

        try {
            session.beginTransaction();

           List<Person> personList= session.createQuery("from Person where age<34").getResultList();
           personList.forEach(System.out::println);

            List<Person> personList2= session.createQuery("from Person where name like 'M%'").getResultList();
            personList2.forEach(System.out::println);

            /// обновляем информацию по фильтру с помощью запроса
            session.createQuery("update Person  set name='Test' where age>=34").executeUpdate();





            session.getTransaction().commit();
        } finally {
            // после коммита мы должны закрыть сессию и session factory
            session.close();
            sessionFactory.close();
        }
    }
}
