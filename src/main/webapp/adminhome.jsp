<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin home</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
</head>
<body>
<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="#" class="a1">New Employees</a></li>
<li><a href="#" class="a1">Feedback Questionaire</a></li>
<li><a href="acceptuserregisteration" class="a1">Help</a></li>
<li><a href="adminlogout" class="a1">Logout</a></li>
</ul>
</div>

<div align="center">

<table border="1">
<tr>
<th>CusID</th>
<th>First name</th>
<th>Last name</th>
<th> dob</th>
<th> gender</th>
 <td>city</td>
<th> status</th>
</tr>
<c:forEach items="${cusList}" var="cus">
   <tr>
   <td>${cus.cusId}</td>
   <td>${cus.firstName}</td>
   <td>${cus.lastName}</td>
   <td>${cus.dob}</td>
   <td>${cus.gender}</td>
   <td>${cus.city}</td>
    <td>${cus.status}</td>
   
   <td><a href="activate?id=${cus.cusId}"><button>Activate</button></a></td>
   <td><a href="deactivate?id=${cus.cusId}"><button>Deactivate</button></a></td>
   <td><a href="givebankdetails?id=${cus.cusId}"><button>GiveBankDetails</button></a></td>
  <%--  <td><a href="delete?id=${user.username}"><button>Delete</button></a></td> --%>
   
   
   </tr>
</c:forEach>

</body>
</html>