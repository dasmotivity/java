package com.springHibernate.dao;

import com.springHibernate.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;


import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
       @Autowired
        HibernateTemplate template;
        public void setTemplate(HibernateTemplate template) {
            this.template = template;
        }
        public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    SessionFactory sessionFactory;

        public void saveStudent(Student e){

           Session s = sessionFactory.openSession();
           Transaction t = s.beginTransaction();
           s.persist(e);
           t.commit();
           s.close();

        }

        public void updateStudent(Student e){
            template.update(e);

        }

        public void deleteStudent(Student e){
            Session s = sessionFactory.openSession().getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.delete(e);
            t.commit();
            s.close();
        }

        public Student getById(int id){
            Student e=(Student) template.get(Student.class,id);
            return e;
        }
        public void saveStudentBySession(Student student){
            Session s = sessionFactory.openSession();
            Transaction t = s.beginTransaction();
            s.persist(student);

            t.commit();
            s.close();
        }
        public List<Student> getStudents(){
            List<Student> list=new ArrayList<Student>();
            list=template.loadAll(Student.class);

            return list;
        }


}
