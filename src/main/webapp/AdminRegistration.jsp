<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration Page</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">
function validate(){
	var fname=document.getElementById("firstName").value;
	var lname=document.getElementById("lastName").value;
	var dob=document.getElementById("dob").value;
	var gender=document.getElementById("gender").value;
	var phone=document.getElementById("contactNumber").value;
	var address=document.getElementById("address").value;
	var city=document.getElementById("city");
	var state=document.getElementById("state");
	var zipcode=document.getElementById("zipcode").value;
	var id=document.getElementById("adminId").value;
	var pwd=document.getElementById("password").value;
	var pattern=/[A-Za-z]{6,32}/;
	var pattern1=/^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
	var pattern2=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	if(fname==""){
		alert("Please update Mandatory fields");
		document.getElementById("firstName").style.borderColor="red";
		return false;
		}
	 if(lname==""){
		alert("Please update Mandatory fields");
		document.getElementById("lastName").style.borderColor="red";
		return false;
		}
	 if(dob==""){
		document.getElementById("Age").style.borderColor="red";
		alert("Please update Mandatory fields");
		return false;
		}
	 if(gender==""){
		alert("Please update Mandatory fields");
			document.getElementById("Gender").style.borderColor="red";
			return false;
			}
	 if(phone==""){
		alert("Please update Mandatory fields");
		document.getElementById("contactNumber").style.borderColor="red";
		return false;
		}	
	 if(address==""){
			alert("Please update Mandatory fields");
			document.getElementById("address").style.borderColor="red";
			return false;
			}			
	 if(city==""){
			alert("Please update Mandatory fields");
			document.getElementById("city").style.borderColor="red";
			
			return false;
			}
	 if(state==""){
			alert("Please update Mandatory fields");
			document.getElementById("state").style.borderColor="red";
			
			return false;
			}
	 if(zipcode==""){
			alert("Please update Mandatory fields");
			document.getElementById("zipcode").style.borderColor="red";
			return false;
			}	
		
	 if(id==""){
			alert("Please update Mandatory fields");
			document.getElementById("adminId").style.borderColor="red";
			
			return false;
			}
		
		
	 if(pwd==""){
		alert("Please update Mandatory fields");
		document.getElementById("password").style.borderColor="red";		
		return false;
		}
	  if(!pattern.test(id)){
		alert("Please update Mandatory fields");
		document.getElementById("adminId").style.borderColor="red";
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
<div class="header"/>
<h1>Chargeback Calculator</h1>
</div>
<h2>Admin Registration</h2>
<div class="formdata">
<form:form onsubmit="return validate()" action="adminreg" modelAttribute="admin" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<table>
<tr>
<td>FirstName:</td>
<td><form:input path="firstName" id="firstName" /></td>
</tr>
<tr>
<td>LastName:</td>
<td><form:input path="lastName" id="lastName" /></td>
</tr>
<tr>
<td>DoB:</td>
<td><form:input path="dob" id="dob"/></td>
</tr>
<tr>
<td>Gender:</td>
<td><form:radiobutton path="gender" value="female" id="gender" />Female
<form:radiobutton path="gender" value="male" id="gender" />Male
</td>
</tr>
<tr>
<td>Contact Number:</td>
<td><form:input path="contactNumber" id="contactNumber" />
</td>
</tr>
<tr>
<td>Address:</td>
<td><form:input path="address" id="address" />
</td>
</tr>
<tr>
<td>City:</td>
<td><form:input path="city" id="state" />
</td>
</tr>
<tr>
<td>State:</td>
<td><form:select path="state" id="state" class="select-box" >
  <option value="Telangana">Telangana</option>
  <option value="Andhra Pradesh">Andhra Pradesh</option>
  <option value="Tamilnadu">Tamilnadu</option>
  <option value="Goa">Goa</option>
  <option value="Kerala">Kerala</option>
  <option value="Delhi">Delhi</option>
  <option value="Uttar Pradesh">Uttar Pradesh</option>
  <option value="Maharastra">Maharastra</option>
</form:select></td>
</tr>
<tr>
<td>Zip Code:</td>
<td><form:input path="zipcode" id="zipcode" />
</td>
</tr>
<tr>
<td>UserId:</td>
<td><form:input path="adminId" id="adminId" /></td>
</tr>
<tr>
<td>Password</td>
<td><form:input path="password" id="password" type="password"/>
</tr>
</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>
</form:form>
Already having account?<a href="adminlogin">Login</a>
<br>
<br>
${message}
</body>
</div>
</html>