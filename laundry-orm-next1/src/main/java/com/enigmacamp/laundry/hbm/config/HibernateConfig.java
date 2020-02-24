package com.enigmacamp.laundry.hbm.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.enigmacamp.laundry.db.entities.Admin;
import com.enigmacamp.laundry.db.entities.Customers;
import com.enigmacamp.laundry.db.entities.LaundryItems;
import com.enigmacamp.laundry.db.entities.LaundryService;
import com.enigmacamp.laundry.db.entities.Transaksi;


public class HibernateConfig {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            
            configuration.configure();
            configuration.addAnnotatedClass(Admin.class);
            configuration.addAnnotatedClass(Customers.class);
            configuration.addAnnotatedClass(LaundryItems.class);
            configuration.addAnnotatedClass(LaundryService.class);
            configuration.addAnnotatedClass(Transaksi.class);
            
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            System.out.println("Session failed" + e);
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
