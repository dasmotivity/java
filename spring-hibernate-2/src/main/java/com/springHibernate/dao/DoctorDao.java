package com.springHibernate.dao;

import com.springHibernate.pojo.Doctor;
import com.springHibernate.pojo.Patient;
import com.springHibernate.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
        @Autowired
        HibernateTemplate template;
    @Autowired
    SessionFactory sessionFactory;
    static boolean userExits;
    public void setTemplate(HibernateTemplate template) {
            this.template = template;
        }
    public void saveDoctor(Doctor e){

        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(e);
        t.commit();
        s.close();
        System.out.println("saved in database");

    }

        public void updateDoctor(Doctor e){
            template.update(e);

        }

        public void deleteDoctor(Doctor e){
            Session s = template.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.delete(e);
            t.commit();
            s.close();
        }

        public Doctor getById(int id){
            Doctor e=(Doctor) template.get(Doctor.class,id);
            return e;
        }

        public List<Doctor> getDoctors(){
            List<Doctor> list=new ArrayList<Doctor>();
            list=template.loadAll(Doctor.class);
            return list;
        }
    public  Doctor checkUserLogin(Doctor doctor) {
        Session s = template.getSessionFactory().openSession();
//    Transaction t = s.beginTransaction();
        String s1 = "from Doctor d where d.doctor_id=?0 and d.password=?1";
        Query query = s.createQuery(s1,Doctor.class);
        query.setParameter(0,doctor.getDoctor_id());
        query.setParameter(1,doctor.getPassword());
        List<Doctor> li = query.list();
        userExits=false;
        li.forEach(e->userExits=true);
        if(userExits){
            return (Doctor) query.getSingleResult();
        }
        return null;
    }

}
