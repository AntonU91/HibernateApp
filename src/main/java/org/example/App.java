package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /// по умолчанию обьект класса Configuration читает информацию о конфигурацие
        // с файла hibernate.properties который находиться в папке resources
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        // создаем SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // создаем сессию
        Session session = sessionFactory.getCurrentSession();
        // открываем транзакцию

        Person person;
        try {
            session.beginTransaction();

//            Person person1 =  new Person("Valik", 31);
//            Person person2 = new Person("Zahar", 29);
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//            session.save(person1);
//            session.save(person2);
//            Person person3 = session.get(Person.class, 3);
//           // person3.setName("Petr Uzhva");
//            session.delete(person3);
             person = new Person("Mr.Smith", 34);
            session.save(person);


            session.getTransaction().commit();
        } finally {
            // после коммита мы должны закрыть сессию и session factory
            session.close();
            sessionFactory.close();
        }
        System.out.println(person.getId());




    }
}
