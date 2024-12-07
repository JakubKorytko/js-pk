package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("shapeDAO")
public class ShapeDAO {

    private SessionFactory sessionFactory;

    public void setCustomSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ShapeDAO() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void saveShape(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            if (shape.color != null && shape.color.getId() == null) {
                session.persist(shape.color);
            }

            session.persist(shape);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Shape getShapeById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Shape.class, id);
        }
    }

    public List<Shape> getAllShapes() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Shape", Shape.class).list();
        }
    }

    public void updateShape(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            if (shape.color != null && shape.color.getId() == null) {
                session.persist(shape.color);
            }

            session.merge(shape);
            session.getTransaction().commit();
        }
    }

    public void deleteShape(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Shape shape = session.get(Shape.class, id);
            if (shape != null) {
                session.delete(shape);
            }

            session.getTransaction().commit();
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
