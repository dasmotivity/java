<head>
    <center>
PATIENT HOME

<h4 align="center">
 <a href="doctor_home">home</a>&nbsp;&nbsp;
 <a href="doctor_profile">profile</a>&nbsp;&nbsp;
  <a href="doctor_appointments">appointment</a>&nbsp;&nbsp;
 <a href="index">logout</a>&nbsp;&nbsp;
 </h4>
 </center>
 </head>
 <br><br><br><br>
 <table border="1" align="center">
  <tr><td>doctor id</td><td>doctor name</td><td>speciality</td><td>mail</td><td> action</td></tr>
  <tr><td>${session2.doctor_id} </td><td>${session2.doctorname}</td><td>${session2.speciality}</td><td>${session2.email}</td><td><a href="doctor_details_edit">edit</td>
  </tr>
 </table>