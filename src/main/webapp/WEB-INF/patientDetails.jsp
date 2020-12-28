
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
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
<form:form method="post" modelAttribute="patient" action="${pageContext.request.contextPath}/addPatient">
<table>
		<tr>
			<th colspan="2">Add Patient</th>
		</tr>
		<tr>
	<form:hidden path="id" />
          <td><form:label path="patientName">Patient Name:</form:label></td>
          <td><form:input path="patientName" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
			    <td><form:label path="emailid">Email id:</form:label></td>
          <td><form:input path="emailid" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
		<tr>
			    <td><form:label path="city">City:</form:label></td>
          <td><form:input path="city" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			    <td><form:label path="age">Age:</form:label></td>
          <td><form:input path="age" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			    <td><form:label path="gender">Gender:</form:label></td>
			    <td>
			    <form action="gender">
  				<select name="gender">
    			<option value="male">Male</option>
    			<option value="female">Female</option>
    			<option value="other">TransGender</option>
  				</select></form>
  				</td>	
  				
  				<tr>
			    <td><form:label path="mobileno">MobileNo:</form:label></td>
          <td><form:input path="mobileno" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>	    
     
     			<tr><td colspan="2"><input type="submit"
				class="blue-button" /></td></tr>
	</table> 
</form:form>
<h3>Patient List</h3>
<c:if test="${!empty listOfPatients}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Patient Name</th>
		<th width="120">Email id</th>
		<th width="120">City</th>
		<th width="120">Age</th>
		<th width="120">Gender</th>
		<th width="120">MobileNo</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfPatients}" var="patient">
		<tr>
			<td>${patient.id}</td>
			<td>${patient.patientName}</td>
			<td>${patient.emailid}</td>
			<td>${patient.city}</td>
			<td>${patient.age}</td>
			<td>${patient.gender}</td>
			<td>${patient.mobileno}</td>
			<td><a href="<c:url value='/updatePatient/${customer.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deletePatient/${customer.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
