package com.springHibernate;

import com.springHibernate.dao.AppointmentDao;
import com.springHibernate.dao.DoctorDao;
import com.springHibernate.dao.PatientDAO;
import com.springHibernate.dao.StudentDAO;

import com.springHibernate.pojo.Appointment;
import com.springHibernate.pojo.Doctor;
import com.springHibernate.pojo.Patient;
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
        p.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        p.put("hibernate.hbm2ddl.auto","update");
        p.put("hibernate.show_sql","true");

        return p;
    }
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean l=new LocalSessionFactoryBean();
        l.setDataSource(driverManagerDataSource());
//        l.setAnnotatedClasses(Student.class);
        l.setAnnotatedClasses(Patient.class,Doctor.class,Student.class, Appointment.class);
//        l.setAnnotatedClasses(Doctor.class);
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
        return template;
    }
    @Bean(name = "student_dao")
    public StudentDAO getStudentDao(){
        return new StudentDAO();
    }

    @Bean(name = "patient_dao")
    public PatientDAO getPatientDao(){
        return new PatientDAO();
    }

    @Bean(name = "doctor_dao")
    public DoctorDao getDoctorDAO(){
        return new DoctorDao();
    }
    @Bean(name = "appointment_Dao")
    public AppointmentDao getAppointDao(){
        return new AppointmentDao();
    }
}
