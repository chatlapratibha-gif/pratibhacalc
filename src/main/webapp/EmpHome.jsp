<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee home</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
<!-- <link rel="stylesheet" type="text/css" href="/empstyle.css"> -->
</head>
<body>
<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/emp");
}
%>

<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="Transactions" class="a1">List of Customers</a></li>
<li><a href="#" class="a1">Help</a></li>
<li><a href="emplogout" class="a1">Logout</a></li>
</ul>
 <!-- ...................................... -->
<div align="right" style="margin-right: 130px;">
<form action="searchcustomers" method="post">
<table>
<tr>
<td>
<input type="search" name="searchbycustomer" style="height: 30px;border-radius: 20px;">
</td>
<td>
<button type="submit" style="border-radius: 20px;"><img src="search.jpg" style="height:30px; width: 40px;border-radius: 30px;"></button>
</td>
</tr>
</table>
</form>
</div> 
</div>
<hr>
<div align="center">
<%-- ${message} --%>
<table border="2">

<!--  JSTL Core Tag -->
<c:forEach items="${customerList}" var="customer">

    <tr>
      <td>${customer.firstName}</td>
<%--        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
         <td>${user.email}</td>
          <td>${user.mobile}</td>
           <td>${user.dob}</td>
           <td> <a href="addrequest?fname=${user.username}">Send Friend Request</a> </td>
 --%>    </tr>

</c:forEach>

</table>



<!-- <a href="userhome">Home</a> -->
<!-- ...................................... -->
</div>

<div align="center">

<table border="2" style="background-color:#7B3F00">

<tr>
<th>customerid </th>
<th>FirstName </th>
<th> transacId </th>
<th> Amount </th>
<th>Dateoftrans</th>
<th> BankAcNo </th>
<th> BranchName </th>
<th> Address </th>
<th> AvlBal </th>
</tr>
<%-- <c:forEach items="${cusList}" var="cust">
<tr>
<td>${cust.cusId}</td> --%>
 <%-- <td><a href="EmpHome?id=${cus.cusId}"><button>viewcustomerdetails</button></a></td>
</c:forEach> --%>
 <c:forEach items="${cusList}" var="cust"> 
 <tr>
<td>${cust.cusId}</td>
<td>${cust.firstName}
<%-- <td>${cust.lastName}
<td>${cust.dob}</td>
<td>${cust.gender}</td>
<td>${cust.contactNumber}</td>
<td>${cust.address}</td>
<td>${cust.city}</td>
<td>${cust.state}</td>
<td>${cust.zipcode}</td>
<td> --%>
<c:forEach items="${cust.transacList}" var="tlist"> 
<td>${tlist.id}</td>
<td>${tlist.amount}</td>
<td>${tlist.dateoftrans}</td>
</c:forEach> 
</td>
<c:forEach items="${cust.bankinfoo}" var="b"> 
<td>${b.bankacno}</td>
<td>${b.branchname}</td>
<td>${b.branchaddress}</td>
<td>${b.avlbal}</td>
</c:forEach>
</tr></c:forEach> 
 

</table></div>



</body>
</html>
<%-- //////////////////////////////////////////////////////////////////
<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=fullname.toUpperCase() %></span></h1> 

<ul>

<li ><a href="#">View Profile</a></li>

 <li ><a href="friendrequest">Friend Request</a></li>
<li ><a href="mymessages">Messages</a></li>
<li ><a href="myfriends">MyFriends</a></li>
<li><a href="report">Report</a></li>
<li ><a href="logout">LogOut</a></li>
</ul>
<div align="right" style="margin-right: 130px;">
<form action="searchusers" method="post">
<table>
<tr>
<td>
<input type="search" name="searchbyname" style="height: 30px;border-radius: 20px;">
</td>
<td>
<button type="submit" style="border-radius: 20px;"><img src="search.jpg" style="height:30px; width: 40px;border-radius: 30px;"></button>
</td>
</tr>
</table>
</form>
</div>
</div>
<hr>
<div align="center">
${message}
<table border="2">
<!--  JSTL Core Tag -->
<c:forEach items="${usersList}" var="user">

    <tr>
      <td>${user.username}</td>
       <td>${user.firstname}</td>
        <td>${user.lastname}</td>
         <td>${user.email}</td>
          <td>${user.mobile}</td>
           <td>${user.dob}</td>
           <td> <a href="addrequest?fname=${user.username}">Send Friend Request</a> </td>
    </tr>

</c:forEach>

</table>



<a href="userhome">Home</a>
 --%>