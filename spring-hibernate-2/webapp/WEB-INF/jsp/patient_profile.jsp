<head>
    <center>
PATIENT HOME

<h4 align="center">
 <a href="patient_home">home</a>&nbsp;&nbsp;
 <a href="patient_profile">profile</a>&nbsp;&nbsp;
  <a href="patient_appointments">appointment</a>&nbsp;&nbsp;
 <a href="index.jsp">logout</a>&nbsp;&nbsp;
 </h4>
 </center>
 </head>
 <br><br><br><br>
 <table border="1" align="center">
 <%

 %>
  <tr><td>patient id</td><td>patient name</td><td>address</td><td>mobile number</td><td>description</td><td>status</td><td>action</td></tr>
  <tr><td>${session1.patient_id} </td><td>${session1.name}</td><td>${session1.address}</td><td>${session1.mobile_number}</td><td></td><td>${session1.status}</td><td><a href="patient_details_edit">edit</td>
  </tr>
 </table>