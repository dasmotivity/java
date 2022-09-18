package com.springHibernate.dao;

import com.springHibernate.pojo.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
        HibernateTemplate template;
        public void setTemplate(HibernateTemplate template) {
            this.template = template;
        }

        public void saveStudent(Student e){
           Session s = template.getSessionFactory().openSession();
           Transaction t = s.beginTransaction();
           s.persist(e);
           t.commit();
           s.close();
        }
        public void updateStudent(Student e){
            template.update(e);
        }
        public void deleteStudent(Student e){
            Session s = template.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.delete(e);
            t.commit();
            s.close();
        }
        public Student getById(int id){
            Student e=(Student) template.get(Student.class,id);
            return e;
        }
        public List<Student> getStudents(){
            List<Student> list=new ArrayList<Student>();
            list=template.loadAll(Student.class);
            return list;
        }
}
