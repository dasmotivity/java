<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head >
<meta charset="ISO-8859-1">
<h1 align="center" > WELCOME TO PATIENT HOME</h1>
<h4 align="center">
 <a href="patient_home">home</a>&nbsp;&nbsp;
  <a href="patient_profile">profile</a>&nbsp;&nbsp;
   <a href="patient_appointment">appointment</a>&nbsp;&nbsp;
  <a href="index.jsp">logout</a>&nbsp;&nbsp;
 
 <br><br><br><br>
  <form method="get" action="appointment_apply">
          
          <input type="text" placeholder="name"   name="name" /><br>
          <input type="text" placeholder="mobile" name="mobile" /><br>
          <input type="date" placeholder="select date" name="doa" /><br>
           <select name="speciality">
           	<option value="dentist">dentist</option>
           	<option value="general">general</option>
           	<option value="ortho">ortho</option>
           </select>
           <input type="submit"  value="Apply">
     </form>
</head>
<body>

</body>
</html>