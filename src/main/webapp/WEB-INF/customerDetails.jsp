
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
<form:form method="post" modelAttribute="customer" action="${pageContext.request.contextPath}/addCustomer">
<table>
		<tr>
			<th colspan="2">Add Customer</th>
		</tr>
		<tr>
	<form:hidden path="id" />
          <td><form:label path="customerName">Customer Name:</form:label></td>
          <td><form:input path="customerName" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
			    <td><form:label path="email">Email:</form:label></td>
          <td><form:input path="email" size="30" maxlength="30"></form:input></td>
		</tr>
		
		<tr>
			    <td><form:label path="country">Country:</form:label></td>
          <td><form:input path="country" size="30" maxlength="30"></form:input></td>
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
     
     			<tr><td colspan="2"><input type="submit"
				class="blue-button" /></td></tr>
	</table> 
</form:form>
<h3>Customer List</h3>
<c:if test="${!empty listOfCustomers}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Customer Name</th>
		<th width="120">Email</th>
		<th width="120">Country</th>
		<th width="120">Age</th>
		<th width="120">Gender</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfCustomers}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.customerName}</td>
			<td>${customer.email}</td>
			<td>${customer.country}</td>
			<td>${customer.age}</td>
			<td>${customer.gender}</td>
			<td><a href="<c:url value='/updateCustomer/${customer.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteCustomer/${customer.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
