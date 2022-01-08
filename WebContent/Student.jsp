<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
  width: 40%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
  
}
div1 {
  width: 100px;
  height: 100px;
  background: red;
  position: relative;
  animation: mymove 5s infinite;
  animation-delay: 2s;
}
div2 {
  width: 100px;
  height: 100px;
  background: red;
  transition-property: width, height;
  transition-duration: 1s;
}

div2:hover {
  width: 300px;
  height: 300px;
}
@keyframes mymove {
  from {left: 0px;}
  to {left: 200px;}
}
</style>
<a href="result.jsp"><button  class="btn btn-warning">View Student Details</button></a>
<br>
<br>

<div1>
<img src="ee.PNG" alt="Italian Trulli">

</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>