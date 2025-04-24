<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Claims Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
		<div class="navbar">
			<a class="active" href="/"><i class="fa fa-fw fa-home"></i>Claims Management System</a>
			 <a class="active" href="/logout"><i class="fa fa-fw fa-sign-out"></i> Logout</a>
		</div>
	</nav>
	<div class="container">
		<br> 
		<a href="memberHome" class="previous">&laquo;Back</a>
		<br>
		
		<h1>Member Portal Service</h1>
		<hr>
		<h5 class="text-danger">${message }</h5><br>
		<h2>Enter Details</h2>

		<form action="/viewStatusResult" method="post">
    		<section>
	    	<select name="policyId" class="form-control">
	    	<option>Select Your Policy</option>
	        <c:forEach items="${list}" var="category">
	            <option value="${category.getPolicyId()}">${category.getPolicyId()}</option>
	        </c:forEach>
	    	</select>
	    	</section>
	    	<br/><br/>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>

		<hr>
	</div>
</body>
</html>