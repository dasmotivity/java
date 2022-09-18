package com.springHibernate;

import com.springHibernate.dao.StudentDAO;
import com.springHibernate.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(name = "disp")
public class InsertTest {

    public  void insertData(String sid,String firstname, String lastname)   {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        StudentDAO dao=(StudentDAO)context.getBean("dao");
        Student e=new Student();
        e.setSid(Integer.parseInt(sid));
        e.setFirstname(firstname);
        e.setLastname(lastname);
        dao.saveStudent(e);
       // dao.deleteStudent(e);
    }
}