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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h1 class="text-primary">Your Expense</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col"><c:out value="${texpenses.id}"/></th>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Description</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td><a href="/expenses/${texpenses.id}"><c:out value="${texpenses.name}"/></a></td>
					<td><c:out value="${texpenses.seller}"/></td>
					<td><c:out value="${texpenses.price}"/></td>
					<td><c:out value="${texpenses.desc}"/></td>
				</tr>	
			</tbody>
		</table>
		<a href="/" class="btn btn-primary" role="button">Go Back</a>
	</div>
</body>
</html>
