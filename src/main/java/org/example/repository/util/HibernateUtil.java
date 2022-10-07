package org.example.repository.util;

import org.example.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    static {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Client.class);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
    }
    public static final SessionFactory SESSION_FACTORY;

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

    public static Session getSession(){
        if (SESSION_FACTORY == null){
            throw new RuntimeException("sessionFactory is null");
        }
        return SESSION_FACTORY.getCurrentSession();
    }

}
