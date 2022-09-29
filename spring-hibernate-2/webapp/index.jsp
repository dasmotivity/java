<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: "Lato", sans-serif;
}

.sideba {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sideba a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sideba a:hover {
  color: #f1f1f1;
}

.sideba .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color: #111;
  color: white;
  padding: 10px 15px;
  border: none;
}

.openbtn:hover {
  background-color: #444;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
</style>
</head>
<body>

<div id="mySideba" class="sideba">
  <a  class="closebtn" onclick="closeNav()">x</a>
  <a href="patient_register_form">patient registration</a>
  <a href="doctor_register_form">doctor registration</a>
  <a href="doctor_login_form">patient login</a>
  <a href="patient_login_form">doctor login</a>
  <br>
  <br>
  <a href="#">about</a>
  <a href="#">privacy and security</a>
  <a href="#">tearms and conditions</a>

</div>

<div id="main">
  <button class="openbtn" onclick="openNav()">menu</button>
</div>

<script>
function openNav() {
  document.getElementById("mySideba").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySideba").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>

</body>
</html>
