<%@page import="com.Student.Service.student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.min.js"></script>
<script src="Components/student.js"></script>
<script src="Components/jquery.min.js"></script>
<link rel="stylesheet" href="assets">
<link rel="stylesheet" href="Views">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<style>
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 35%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
  
}
#customers {

  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 3px;
}
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: left;
  background-color:#0066ff;
  color: white;
}
div1 {
  width: 100px;
  height: 100px;
  background: red;
  position: relative;
  animation: mymove 5s infinite;
  animation-delay: 2s;
}

@keyframes mymove {
  from {left: 0px;}
  to {left: 200px;}
}
</style>
	
	
  <div class="column">
  <div class="col-lg-4ss">

		<form id="formStudent" name="formStudent" method="post" action="index.jsp">
		
			<h3>UPDATE STUDENT DETAILS</h3>
			<br>
			<label>Student Name</label>
			 <input id="StudentName" name="StudentName" type="text" placeholder="Enter Student Name" class="form-control form-control-sm"> 
			<br>
		
			<label>Gender</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <label for="male">Male</label>&nbsp;<input type="radio" id="male" name="Sex" value="Male">&nbsp;
			 <label for="female">Female</label>&nbsp;<input type="radio" id="female" name="Sex" value="Female" >
			<br>
			<br>
			<label>Age</label>
			 <input id="Age" name="Age" type="text" placeholder="Age" class="form-control form-control-sm"> 
			<br>
			<label>Address</label> 
			<input id="Address" name="Address" type="text" placeholder="Enter Address" class="form-control form-control-sm"> 
			<br>
			<label>Phone No</label>
			 <input id="PhoneNo" name="PhoneNo" type="text" placeholder="Enter Phone No" class="form-control form-control-sm">
			<br> 
			<label>BirthDate</label>
			 <input id="BirthDate" name="BirthDate" type="date" placeholder="Enter BirthDate" class="form-control form-control-sm"> 
			<br>
			<label>Email</label>
			 <input id="Email" name="Email" type="text" placeholder="Enter Email" class="form-control form-control-sm"> 
			<br>
			
			<br>
			<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
			
			 <input type="hidden" id="hidStudentIDSave" name="hidStudentIDSave" value="">
			
		</form>
		
		</div>
						<br>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br> <br>
		</div>
<div class="column">
		
		<div id="divStudentGrid">
<%
	student studentObj = new student();
	out.print(studentObj.readStudents());
%>
</div>
				
</div>

	</div>
	

</body>

</html>