<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css">
	
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div>
		<button type="button" onclick="window.location.href='new';return false;"
			class="add-button">Add Customer</button>
	</div>
	
	<div>
		<!--  add a search box -->
        <form:form action="" method="GET">
            Search customer: <input type="text" name="name" value="${param.name }" />
            
            <input type="submit" value="Search" class="add-button" />
        </form:form>
	</div>
	
	<div id="container">
		<c:if test="${customers.size() gt 0}">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers }">
					<tr>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<td><a href="edit?id=${customer.id}">Edit</a> | <a onclick="return confirm('Want to delete ${customer.firstName} ?')" href="delete?id=${customer.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${customers.size() eq 0}">
			<span>Customers not found.</span>
		</c:if>
	</div>
</body>
</html>