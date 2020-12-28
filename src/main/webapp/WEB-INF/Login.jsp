<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>User Login Form</title>
</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
<form:form  modelAttribute="login" action="${pageContext.request.contextPath}/loginsuccess">
<table>
		<tr>
			<th colspan="2">Login User</th>
		</tr>
		<tr>
	
	<tr>
			    <td><form:label path="usertype">User Type:</form:label></td>
			    <td>
			    <form action="usertype">
  				<select name="usertype">
    			<option value="customer">Customer</option>
    			<option value="patient">Patient</option>
  				</select></form>
  				</td>	
  				
  				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" size="30" /></td>
				</tr>
		<tr>
					<td>Password</td>
					<td><input type="password" name="password" size="30" /></td>
				</tr>
				
     
     			<tr><td colspan="5"><input type="submit"
				class="blue-button" /></td></tr>
	</table> 
	</form:form>

<c:if test="${!empty listOfUsers}">
	<table class="tg">
	<tr>
		<th> Logged in Successfully </th>
	</tr>
	</table>
</c:if>
</body>
</html>