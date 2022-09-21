package com.springHibernate.configuration;

import com.springHibernate.pojo.Appointment;
import com.springHibernate.pojo.Doctor;
import com.springHibernate.pojo.Patient;
import com.springHibernate.pojo.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    @Bean(name = "sf")
    public   static SessionFactory getSessionFactory(){

        if(sessionFactory==null){
            Configuration configuration = new Configuration();
            Properties settings=new Properties();
            settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/institution");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "root");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            settings.put(Environment.SHOW_SQL, "true");

            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            settings.put(Environment.HBM2DDL_AUTO, "update");
            settings.put(Environment.USE_SECOND_LEVEL_CACHE,"true");
            settings.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");

            configuration.setProperties(settings);

            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Patient.class);
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Appointment.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
