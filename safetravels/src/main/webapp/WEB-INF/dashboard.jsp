<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<div class="container">
	<div class="row">
	<h1 class="text-primary">Your Expenses</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col"><c:out value="${id}"/></th>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>	
			</thead>
			<tbody>
			<c:forEach var="x" items="${texpenses}">
				<tr>
					<td><a href="/expenses/${x.id}"><c:out value="${x.name}"/></a></td>
					<td><c:out value="${x.seller}"/></td>
					<td><c:out value="${x.price}"/></td>
					<td><a href="/expenses/edit<c:out value="${x.id}"/>">Edit</a>
					<form action="/expenses/${x.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" class="btn btn-danger" value="Delete">
					</form>
					</td>
				</tr>	
			</c:forEach>
			</tbody>
		</table>
	</div>	
	<div class="row">
	<h2 class="text-success">Add an Expense</h2>
		<form:form action="expenses/create" class="form" method="post" modelAttribute="tExpenses">
			<div class="mb-3">
			    <form:label class="form-label" path="name">Name of Expense: </form:label>
			    <form:errors path="name"/>
			    <form:input type="text" class="form-control" path="name"/>
		  </div>
		  <div class="mb-3">
			    <form:label class="form-label" path="seller">Name of Vendor: </form:label>
			    <form:errors path="seller"/>
			    <form:input type="text" class="form-control" path="seller"/>
		  </div>
		  <div class="mb-3">
		    <form:label class="form-label" path="price">Price: </form:label>
		    <form:errors path="price"/>
		    <form:input type="number" step="0.01" class="form-control" path="price"/>
		  </div>
		
		<div class="form-floating">
			  <form:textarea class="form-control" placeholder="Leave a comment here" style="height: 100px"></form:textarea>
			  <form:errors path="desc"/>
			  <form:label for="floatingTextarea2">Descriptions</form:label>
		</div>
		  <button type="submit" class="btn btn-success">Add an Expense</button>
		</form:form>
		</div>
	</div>
</body>
</html>
