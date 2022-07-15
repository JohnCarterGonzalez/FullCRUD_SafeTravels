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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- for JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1>TEST</h1>
	
	<div class="container">
		<table class="table">
			<thead>
				<tr>
				  <th scope="col">Expenses</th>
				  <th scope="col">Vendor</th>
				  <th scope="col">Amount</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="x" items="${travel}">
				<tr>
				  <th scope="row"><a href="/travels/${x.id}"></a></th>
				  <td><c:out value="${x.name}"/></td>
				  <td><c:out value="${x.vendor}"/></td>
				  <td><c:out value="${x.amount}"/></td>
				  <td>
				  	<form action="/travels/${x.id}" method="post">
				  		<input type="hidden" name="method" value="delete">
					    <input type="submit" value="Delete" class="btn-danger">
				  	</form>
				  </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		
		<h2>Add an Expense:</h2>
		
		<form:form action="/travels" method="post" modelAttribute="travel">
		
			<div class="form-group">
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name" class="error"/>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="error"/>
				<form:input path="vendor" type="text" class="form-control"/>
			</div>

			<div class="form-group">
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="error"/>
				<form:input path="amount" type="number" step="0.01" class="form-control"/>
			</div>

			<div class="form-group">
				<form:label path="desc">Description:</form:label>
				<form:errors path="desc" class="error"/>
				<form:input path="desc" type="text" class="form-control"/>
			</div>
			
			<input type="submit" value="Add Travel" class="btn-primary"/>
		
		</form:form>
	</div>
	
</body>
</html>