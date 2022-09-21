package com.springHibernate.dao;

import com.springHibernate.pojo.Patient;
import com.springHibernate.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class PatientDAO {
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Autowired
    HibernateTemplate template;
    @Autowired
    SessionFactory sessionFactory;
    static boolean userExits;

    public void savePatient(Patient e) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(e);
        t.commit();
        s.close();
        System.out.println("saved in database");
    }
    public void updatePatient(Patient p){
        template.update(p);
    }

    public Patient checkUserLogin(Patient patient) {
    Session s = template.getSessionFactory().openSession();
//    Transaction t = s.beginTransaction();
    String s1 = "from Patient p where p.patient_id=?0 and p.password=?1";
    Query query = s.createQuery(s1,Patient.class);
    query.setParameter(0,patient.getPatient_id());
    query.setParameter(1,patient.getPassword());
    List<Patient> li = query.list();
    userExits=false;
    li.forEach(e->userExits=true);
    if(userExits){
        return (Patient) query.getSingleResult();
    }
    return null;
    }


}