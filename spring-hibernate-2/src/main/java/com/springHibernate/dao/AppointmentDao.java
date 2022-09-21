package com.springHibernate.dao;

import com.springHibernate.pojo.Appointment;
import com.springHibernate.pojo.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
        @Autowired
        HibernateTemplate template;
    @Autowired
    SessionFactory sessionFactory;
    public void setTemplate(HibernateTemplate template) {
            this.template = template;
        }
    public void saveAppointment(Appointment e){

        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(e);
        t.commit();
        s.close();

    }

        public void deleteAppointment(Doctor e){
            Session s = template.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.delete(e);
            t.commit();
            s.close();
        }

        public Appointment getById(int id){
            Appointment e=(Appointment) template.get(Appointment.class,id);
            return e;
        }

        public List<Appointment> getAppointments(){
            List<Appointment> list=new ArrayList<Appointment>();
            list=template.loadAll(Appointment.class);
            return list;
        }


    public List<Appointment> getBySpeciality(String appointment) {
        Session s = template.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        String s1 = "from Appointment p where p.speciality=?0";
        Query query = s.createQuery(s1, Appointment.class);
        query.setParameter(0,appointment);

        List<Appointment> li = query.list();
        t.commit();
        s.close();
        return li;
    }
    public List<Appointment> getAppointsByPatientId(int appointment) {
        Session s = template.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        String s1 = "from Appointment p where p.pid=?0";
        Query query = s.createQuery(s1, Appointment.class);
        query.setParameter(0,appointment);

        List<Appointment> li = query.list();
        t.commit();
        s.close();
        return li;
    }

    public void updateAppointmentStatus(String status, int aid){

        Session s = template.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();


        Query query=s.createQuery("update Appointment set status=:status where aid=:aid");
        query.setParameter("status",status);
        query.setParameter("aid",aid);

        int i=query.executeUpdate();

        System.out.println(i);
        t.commit();
        s.close();
    }
}
