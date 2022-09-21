<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <center>
DOCTOR HOME

<h4 align="center">
  <a href="doctor_home">home</a>&nbsp;&nbsp;
  <a href="doctor_profile">profile</a>&nbsp;&nbsp;
   <a href="doctor_appointments">appointments</a>&nbsp;&nbsp;
  <a href="index.jsp">logout</a>&nbsp;&nbsp;
 </h4>
  </center>
<table border="1" align="center">
 <tr><td>appointment id</td><td>patient id</td><td>patient name</td><td>speciality</td><td>mobile number</td><td>status</td><td>action</td></tr>
<% HttpSession hs = request.getSession();

 %>
<c:forEach items="${appointmentsBySpeciality}" var="abs">
            <tr>
                <td>${abs.aid}</td>
                <td>${abs.pid}</td>
                <td>${abs.name}</td>
                <td>${abs.speciality}</td>
                <td>${abs.mobile}</td>
                <td>${abs.status}</td>
                <td><a href="accept_appointment?aid=${abs.aid}">accept</a></td>
                 <td><a href="reject_appointment?aid=${abs.aid}">reject</a></td>
            </tr>
        </c:forEach>


  </table>