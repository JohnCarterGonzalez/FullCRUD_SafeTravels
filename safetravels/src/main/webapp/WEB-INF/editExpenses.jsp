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
<title>Edit an Expense</title>
</head>
<body>
	<div class="container">
	<h1 class="text-warning">Edit an Expense</h1>
		<form:form action="expenses/${texpense.id}" class="form" method="post" modelAttribute="texpenses">
		<input type="hidden" name="_method" value="put">
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
		  <button type="submit" class="btn btn-warning">Edit the Expense</button>
		</form:form>
	</div>
</body>
</html>
