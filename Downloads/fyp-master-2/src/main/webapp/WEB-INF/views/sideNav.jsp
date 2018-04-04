<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
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

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="<c:url value='/list' />">Home</a>
  <sec:authorize access="hasRole('ADMIN') or hasRole('TEACHER')">
  <a href="<c:url value='/newuser' />">Add New User</a>
  <a href="<c:url value='/newClassGroup' />">Add New Class Group</a>
  <a href="<c:url value='/classList' />">View Class List</a>
  <a href="<c:url value='/moduleList' />">View Module List</a>
  <a href="<c:url value='/newModule' />">Add New Module</a>
  <a href="<c:url value='/newSubject' />">Add New Subject</a>
  <a href="<c:url value='/studentList' />">View All Students</a>
  <a href="<c:url value='/teacherList' />">View All Teachers</a>
  <a href="<c:url value='/subjectList' />">View All Subjects</a>
  </sec:authorize>
 
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
     
</body>
</html> 
