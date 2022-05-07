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
        	<input type="hidden" name="sortByFirstName" value="${param.sortByFirstName }">
        	<input type="hidden" name="sortByLastName" value="${param.sortByLastName }">
        	<input type="hidden" name="sortByEmail" value="${param.sortByEmail }">
            Search customer: <input type="text" name="name" value="${param.name }" />
            
            <input type="submit" value="Search" class="add-button" />
        </form:form>
	</div>
	
	<div id="container">
		<c:url var="firstNameSort" value="">
			<c:param name="name" value="${param.name }"/>
			<c:param name="sortByFirstName" value="${not param.sortByFirstName }"></c:param>
			<c:param name="sortByLastName" value="${param.sortByLastName }"></c:param>
			<c:param name="sortByEmail" value="${param.sortByEmail }"></c:param>
		</c:url>
		<c:url var="lastNameSort" value="">
			<c:param name="name" value="${param.name }"/>
			<c:param name="sortByFirstName" value="${param.sortByFirstName }"></c:param>
			<c:param name="sortByLastName" value="${not param.sortByLastName }"></c:param>
			<c:param name="sortByEmail" value="${param.sortByEmail }"></c:param>
		</c:url>
		<c:url var="emailSort" value="">
			<c:param name="name" value="${param.name }"/>
			<c:param name="sortByFirstName" value="${param.sortByFirstName }"></c:param>
			<c:param name="sortByLastName" value="${param.sortByLastName }"></c:param>
			<c:param name="sortByEmail" value="${not param.sortByEmail }"></c:param>
		</c:url>
		<c:if test="${customers.size() gt 0}">
			<table>
				<tr>
					<th><a href="${firstNameSort }">First Name</a></th>
					<th><a href="${lastNameSort }">Last Name</a></th>
					<th><a href="${emailSort }">Email</a></th>
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