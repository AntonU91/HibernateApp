package org.example.HW_lesson54;

import org.example.HW_lesson51.models.Director;
import org.example.HW_lesson51.models.Movie;
import org.example.HW_lesson54.models.Principal;
import org.example.HW_lesson54.models.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            //2.  C помощью Hibernate получите любого директора, а затем получите его
            //школу.
//            Principal principal = session.get(Principal.class, 4);
//           School school= principal.getSchool();
//
//            System.out.println(principal);
//            System.out.println(school);
            //
            //3. Получите любую школу, а затем получите ее директора.
//            School school = session.get(School.class, 3);
//            System.out.println(school.getPrincipal());
            //
            //4.Создайте нового директора и новую школу и свяжите эти сущности.
//            Principal principal = new Principal("Anton", 32);
//            School school = new School(202);
//            principal.setSchool(school);
//            school.setPrincipal(principal);
//            session.save(principal);
//
            //5. Смените директора у существующей школы.
//            School school = session.get(School.class, 7);
//            Principal principal = new Principal("Bogdan", 45);
//            school.setPrincipal(principal);
            //
            //6. Попробуйте добавить вторую школу для существующего директора и
            //изучите возникающую ошибку.
           // School school = new School(152);
            School school = session.get(School.class, 3);
            Principal principal = session.get(Principal.class, 1);
            principal.setSchool(school);
            school.setPrincipal(principal);
            session.save(school);


            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();

        }
    }
}
