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
<li><a href="getCustDetails" class="a1">List of Customers</a></li>
<li><a href="#" class="a1">Help</a></li>
<li><a href="#" class="a1">ChargeBackdetails</a></li>
<li><a href="emplogout" class="a1">Logout</a></li>
</ul>
 <!-- ...................................... -->
<div align="right" style="margin-right: 130px;">
<form action="searchcustomers" method="post">
<table>
<tr>
<td>
<input type="search" name="searchbycustomerId" style="height: 30px;border-radius: 20px;">
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

<div>
<table border="2" bgcolor="blue">
<c:forEach items="${customerIds}" var="cid1">
<tr>
<td>${cid1}</td>
<td><a href="getChargeCustDetails?cust1=${cid1}">Get Customer Details</a></td>
</tr>
</c:forEach>
</table>
</div>
<table border="2" bgcolor="blue">
<tr><td>${customercharge.reason}</td>
<td>${customercharge.firstname}</td>
<td>${customercharge.lastname}</td>
<td>${customercharge.bankaccountnumber}</td>
<td>${customercharge.chargebackamount}</td></table>

<div>
<table border="2" bgcolor="blue">
<c:forEach items="${CustIDs}" var="cid">
<tr>
<td>${cid}</td>
<td><a href="getCustDetails?cust=${cid}">Get Customer Details</a></td>
</tr>
</c:forEach>
</table>
</div> 
<table border="2" bgcolor="blue">
<tr>
<td>${customer.firstName}</td>
<td>${customer.lastName}</td>
<td>${customer.dob}</td>
<c:forEach items="${customer.bankinfoo}" var="b"> 
<td>${b.bankacno}</td>
<td>${b.branchname}</td>
<td>${b.branchaddress}</td>
<td>${b.avlbal}</td>
</c:forEach>
<c:forEach items="${customer.transacList}" var="tlist"> 
<td>${tlist.id}</td>
<td>${tlist.amount}</td>
<td>${tlist.dateoftrans}</td></tr>
</c:forEach> 
</table>
<div align="center">
<table border="2" bgcolor="blue">
<tr>
<td>${searchCustomer.firstName}</td>
<td>${searchCustomer.lastName}</td>
<c:forEach items="${searchCustomer.bankinfoo}" var="b"> 
<td>${b.bankacno}</td>
<td>${b.branchname}</td>
<td>${b.branchaddress}</td>
<td>${b.avlbal}</td>
</c:forEach>
<c:forEach items="${searchCustomer.transacList}" var="tlist"> 
<td>${tlist.id}</td>
<td>${tlist.amount}</td>
<td>${tlist.dateoftrans}</td></tr>
</c:forEach> 
</tr>
</table>
</div>
<%-- <td>${customer.firstName}</td>
<td>${customer.firstName}</td>
<td>${customer.firstName}</td>
<td>${customer.firstName}</td>
<td>${customer.firstName}</td>
<td>${customer.firstName}</td>
<td>${customer.firstName}</td> --%>

<%-- <c:forEach items="${customer}" var="c">
<tr>
<td>${c.firstName }</td>
<td>${c.lastName }</td>
</tr>
</c:forEach> --%>
</body>
</html>
