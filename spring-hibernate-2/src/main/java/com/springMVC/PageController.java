package com.springMVC;

import com.springHibernate.BeanInitializationInJava;
import com.springHibernate.InsertTest;
import com.springHibernate.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController{
    @RequestMapping(value = "save")
    public ModelAndView saveData(HttpServletRequest request, HttpServletResponse response, Student student, Model model){
       String sid = request.getParameter("sid");
       String firstname = request.getParameter("firstname");
       String lastname = request.getParameter("lastname");
        ModelAndView mv = new ModelAndView();
        mv.addObject(student);
        System.out.println(student.getFirstname());
//        InsertTest.insertData(sid,firstname,lastname);
//          ApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
//          context.getBean(InsertTest.class).insertData(sid,firstname,lastname);

         mv.setViewName("disp");
         return mv;
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("student",student);
//        System.out.println(student.getFirstname());
//        mv.setViewName("display");
//        return mv;
    }

}
