package com.springMVC;

import com.springHibernate.BeanInitializationInJava;
import com.springHibernate.dao.AppointmentDao;
import com.springHibernate.dao.DoctorDao;
import com.springHibernate.dao.PatientDAO;
import com.springHibernate.pojo.Appointment;
import com.springHibernate.pojo.Doctor;
import com.springHibernate.pojo.Patient;
import com.springHibernate.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController{
    @Autowired
    HttpSession session;

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

         mv.setViewName("display");
         return mv;
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("student",student);
//        System.out.println(student.getFirstname());
//        mv.setViewName("display");
//        return mv;
    }
    @RequestMapping( "doctor_register")
    public ModelAndView doctorRegister(@ModelAttribute("doctor") Doctor doctor){
        ModelAndView mv = new ModelAndView();
        System.out.println(doctor.getDoctor_id());
        Doctor d = new Doctor();
//        d.setDoctor_id(Integer.parseInt(request.getParameter("doctor_id")));
//        d.setPassword(request.getParameter("password"));
//        d.setSpeciality(request.getParameter("speciality"));
//        d.setDoctorname(request.getParameter("doctorname"));
//        d.setEmail(request.getParameter("email"));
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        context.getBean(DoctorDao.class).saveDoctor(doctor);
        mv.setViewName("/index");
        return mv;
    }
    @RequestMapping( "patient_register")
    public ModelAndView doctorRegister(@ModelAttribute("patient") Patient patient){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        ModelAndView mv = new ModelAndView();
        Patient patient1 = new Patient();
//        patient1.setPatient_id(Integer.parseInt(request.getParameter("patient_id")));
//        patient1.setName(request.getParameter("name"));
//        patient1.setMobile_number(Integer.parseInt(request.getParameter("mobile_number")));
//        patient1.setAddress(request.getParameter("address"));
//        patient1.setBlood_group(request.getParameter("blood_group"));
//        patient1.setPassword(request.getParameter("password"));
        context.getBean(PatientDAO.class).savePatient(patient);
        mv.setViewName("/index");
        return mv;
    }
    @RequestMapping( "doctor_register_form")
    public String doctorRegisterForm(){
        return "doctor_register_form";
    }
    @RequestMapping( "patient_register_form")
    public String studentRegisterForm(){
        return "patient_register_form";
    }

    @RequestMapping("patient_login_form")
    public String patientLoginForm(){

        return "patient_login_form";
    }
    @RequestMapping("doctor_login_form")
    public String doctorLoginForm(){

        return "doctor_login_form";
    }
    @RequestMapping(value = "patient_login_validation",method = RequestMethod.POST)
    public ModelAndView patientLoginValidation(Patient patient){
        ModelAndView mv = new ModelAndView();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        PatientDAO patientDAO =context.getBean(PatientDAO.class);
        Patient p =patientDAO.checkUserLogin(patient);
        if(!(p == null)){
            session.setAttribute("session1",p);
            mv.addObject("patient",p);
            System.out.println(p.getAddress());
            AppointmentDao appointmentDao = context.getBean(AppointmentDao.class);
            List<Appointment> li = appointmentDao.getAppointsByPatientId(patient.getPatient_id());
            session.setAttribute("appointmentsByPatientId",li);
            mv.setViewName("patient_profile");
            return mv;
        }else {
            mv.setViewName("login_failed");
            System.out.println("login failed");
            return mv;
        }

    }

    @RequestMapping(value = "doctor_login_validation",method = RequestMethod.POST)
    public ModelAndView doctorLoginValidation(Doctor doctor){
        ModelAndView mv = new ModelAndView();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        DoctorDao doctorDao =context.getBean(DoctorDao.class);
        Doctor d =doctorDao.checkUserLogin(doctor);
        if(!(d ==null)){
            session.setAttribute("session2",d);
            mv.addObject("doctor",d);
            AppointmentDao appointmentDao = context.getBean(AppointmentDao.class);
            List<Appointment> li = appointmentDao.getBySpeciality(d.getSpeciality());
            session.setAttribute("appointmentsBySpeciality",li);
            mv.setViewName("doctor_profile");
            return mv;
        }else {
            mv.setViewName("login_failed");
            System.out.println("login failed");
            return mv;
        }
    }
    @RequestMapping("appointment_apply")
    public ModelAndView saveAppointment(Appointment appointment){
        ModelAndView mv = new ModelAndView();
        Patient patient = (Patient) session.getAttribute("session1");
        appointment.setPid(patient.getPatient_id());
        appointment.setStatus("pending");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        AppointmentDao appointmentDao =context.getBean(AppointmentDao.class);
        appointmentDao.saveAppointment(appointment);
        mv.setViewName("patient_appointment");
        return mv;
    }

    @RequestMapping("doctor_appointments")
    public ModelAndView doctorAppointments(){
        ModelAndView mv = new ModelAndView();
        Doctor doctor = (Doctor) session.getAttribute("session2");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        AppointmentDao appointmentDao = context.getBean(AppointmentDao.class);
        List<Appointment> li = appointmentDao.getBySpeciality(doctor.getSpeciality());
        session.setAttribute("appointmentsBySpeciality",li);

        mv.setViewName("doctor_appointments");
        return mv;
    }
    @RequestMapping("patient_appointments")
    public ModelAndView patientAppointments(){
        ModelAndView mv = new ModelAndView();
        Patient patient = (Patient) session.getAttribute("session1");

        mv.setViewName("patient_appointment");
        return mv;
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("patient_home")
    public String patientHome(){
        return "patient_home";
    }
    @RequestMapping("doctor_home")
    public String doctorHome(){
        return "doctor_home";
    }
    @RequestMapping("doctor_profile")
    public String doctorProfile(){
        return "doctor_profile";
    }
    @RequestMapping("patient_profile")
    public String patientProfile(){
        return "patient_profile";
    }
    @RequestMapping("apply_appointment")
    public String applyAppointment(){
        return "apply_appointment";
    }


    @RequestMapping("accept_appointment")
    public ModelAndView acceptAppointment(HttpServletRequest request){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        AppointmentDao appointmentDao = context.getBean(AppointmentDao.class);
        System.out.println(request.getParameter("aid"));
        appointmentDao.updateAppointmentStatus("accepted", Integer.parseInt(request.getParameter("aid")));
        return doctorAppointments();
    }
    @RequestMapping("reject_appointment")
    public ModelAndView rejectAppointment(HttpServletRequest request){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializationInJava.class);
        AppointmentDao appointmentDao = context.getBean(AppointmentDao.class);
        System.out.println(request.getParameter("aid"));
        appointmentDao.updateAppointmentStatus("rejected", Integer.parseInt(request.getParameter("aid")));
        return doctorAppointments();
    }
}
