package com.springHibernate;

import com.springHibernate.dao.StudentDAO;

import com.springHibernate.pojo.Student;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

public class BeanInitializationInJava {
    @Bean
    Properties getProperties(){
        Properties p = new Properties();
        p.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        p.put("hibernate.hbm2ddl.auto","update");
        p.put("hibernate.show_sql","true");

        return p;
    }
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean l=new LocalSessionFactoryBean();
        l.setDataSource(driverManagerDataSource());
        l.setAnnotatedClasses(Student.class);
        l.setHibernateProperties(getProperties());
        return  l;
    }
    @Bean
    public DriverManagerDataSource driverManagerDataSource(){
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setUrl("jdbc:mysql://localhost:3306/institution");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }
    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory s ){
        HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(s);
        return hibernateTransactionManager;
    }
    @Bean(name = "template")
    public HibernateTemplate getHibernateTemplate(SessionFactory s){
        HibernateTemplate template=new HibernateTemplate();
        template.setSessionFactory(s);
        System.out.println(s.getProperties());
        return template;
    }
    @Bean(name = "dao")
    public StudentDAO getStudentDao(){
        return new StudentDAO();
    }
    @Bean
    public InsertTest insertTest(){
        return new InsertTest();
    }
}
