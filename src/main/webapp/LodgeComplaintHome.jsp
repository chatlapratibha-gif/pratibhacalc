<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lodge Complaint</title>
<link rel="stylesheet" type="text/css" href="/style1.css">

<script type="text/javascript">
function validate(){
	var fname=document.getElementById("firstname").value;
	var lname=document.getElementById("lastname").value;
	var emailid=document.getElementById("emailid").value;
	var bankaccountnumber=document.getElementById("bankaccountnumber").value;
	var phone=document.getElementById("contactnumber").value;
	var branchname=document.getElementById("branchname").value;
	var customerid=document.getElementById("customerid");
	var chargebackamount=document.getElementById("chargebackamount");
	var date=document.getElementById("date").value;
     var re = /^([0-9]{11})|([0-9]{2}-[0-9]{3}-[0-9]{6})$/;
	var pattern=/[A-Za-z]{6,32}/;
	var pattern1=/^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
	var pattern2=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	if (re.test(txtNumber.value)==true)
		 {
        return 1;
    }
    else {
        alert("Invalid Account Number");
        document.getElementById("bankaccountnumber").style.borderColor="red";
        return 0;
    }
    if(fname==""){
		alert("Please update Mandatory fields");
		document.getElementById("firstname").style.borderColor="red";
		return false;
		}
	 if(lname==""){
		alert("Please update Mandatory fields");
		document.getElementById("lastname").style.borderColor="red";
		return false;
		}
	 
	 
	 if(phone==""){
		alert("Please update Mandatory fields");
		document.getElementById("contactnumber").style.borderColor="red";
		return false;
		}	
	 if(branchname==""){
			alert("Please update Mandatory fields");
			document.getElementById("branchname").style.borderColor="red";
			return false;
			}			
	 if(chargebackamount==""){
			alert("Please update Mandatory fields");
			document.getElementById("chargebackamount").style.borderColor="red";
			
			return false;
			}
	 
		
	 if(date==""){
			alert("Please update Mandatory fields");
			document.getElementById("date").style.borderColor="red";
			return false;
			}
		
		
	 if(pwd==""){
		alert("Please update Mandatory fields");
		document.getElementById("password").style.borderColor="red";		
		return false;
		}
	  if(!pattern.test(id)){
		alert("Please update Mandatory fields");
		document.getElementById("cusId").style.borderColor="red";
		return false;		
		}
	 if(!pattern1.test(phone)){
		alert("Please update Mandatory fields");
		document.getElementById("contactNumber").style.borderColor="red";
		return false;
		}
	 if(!pattern2.test(pwd)){
		alert("Please update Mandatory fields");
		document.getElementById("password").style.borderColor="red";
		return false;
		
		}		
	
}
</script>
</head>
<body>
<%
long customerid =(long)session.getAttribute("customerid");
%>

<h1>Lodge Complaint</h1>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="LodgeComplaint" method="post" modelAttribute="lc">
<table>
<tr>
<td>firstName:</td>
<td><form:input path="firstname" class="formcontrol" id="firstname"/></td>
</tr>
<tr>
<td>LastName:</td>
<td><form:input path="lastname" class="formcontrol" id="lastname"/></td>
</tr>
<tr>
<td>Contact Number</td>
<td><form:input path="contactnumber" class="formcontrol" id="contactnumber"/></td>
</tr>
<tr>
<td>EmailId</td>
<td><form:input path="emailid" class="formcontrol" id="emailid"/></td>
</tr>
<tr>
<td>Bank Account Number</td>
<td><form:input path="bankaccountnumber" class="formcontrol" id="bankaccountnumber"/></td>
</tr>
<tr>
<td>Bank Branch Name</td>
<td><form:input path="branchname" class="formcontrol" id="branchname"/></td>
</tr>
<tr>
<td>CustomerId</td>
<td><form:input path="customerid" class="formcontrol" value="${customerid}" id="customerid"/></td>

<tr>
<td>Charge Back Amount</td>
<td><form:input path="chargebackamount" class="formcontrol" id="chargebackamount"/></td>
</tr>
<tr>
<td>date</td>
<td><form:input path="date" class="formcontrol" id="date"/>
<input type=button value="Select Date" onclick="displayDatePicker('date', this);">
</td>
</tr>
<tr>
<td>Reason for Dispute</td>
<td><form:input path="reason" class="formcontrol" id="reason"/>
</td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/>
</form:form>
</div>
</div>
{message}
</body>
</html>