<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <center>
PATIENT APPOINTMENTS

<h4 align="center">
 <a href="patient_home">home</a>&nbsp;&nbsp;
 <a href="patient_profile">profile</a>&nbsp;&nbsp;
  <a href="patient_appointment.jsp">appointment</a>&nbsp;&nbsp;
 <a href="index.jsp">logout</a>&nbsp;&nbsp;
 </h4>
  </center>
  </head>
 <table border="1" align="center">
  <tr><td>appointment id</td><td>patient id</td><td>patient name</td><td>speciality</td><td>mobile number</td><td>status</td><td>action</td></tr>

 <c:forEach items="${appointmentsByPatientId}" var="abp">

             <tr>
                 <td>${abp.aid}</td>
                 <td>${abp.pid}</td>
                 <td>${abp.name}</td>
                 <td>${abp.speciality}</td>
                 <td>${abp.mobile}</td>
                 <td>${abp.status}</td>
             </tr>
         </c:forEach>


   </table>