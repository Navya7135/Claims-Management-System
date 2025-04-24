<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Claims Management System</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>

		<div class="navbar">
			<a class="active" href="/"><i class="fa fa-fw fa-home"></i>Claims Management System</a>
			 <a class="active" href="/logout"><i class="fa fa-fw fa-sign-out"></i> Logout</a> 
		</div>
		
		<div class="container">
			<br>
			<a href="memberHome" class="active previous">&laquo;Back</a>
			<br>
			<h1>Member Portal Service</h1>
			<hr>
			<h2>Submit Claim Here</h2>
			<br>
			<form action="submitClaim" method="POST" class="form-horizontal" enctype="multipart/form-data">
			<section>
	    	<select name="policyId" class="form-control">
	    	<option>Select Your Policy</option>
	        <c:forEach items="${list}" var="category">
	            <option value="${category.getPolicyId()}">${category.getPolicyId()}</option>
	        </c:forEach>
	    	</select>
	    	</section>
	    	<br>
			<input class="form-control" type="text" placeholder="Enter Hospital Id" name="hospitalId" /><br>
			<input class="form-control" type="text" placeholder="Enter Benefit" name="benefitsAvailed" /><br>
			<input class="form-control" type="text" placeholder="Enter total bill" name="totalBill"  required="required"/><br>
			<input class="form-control" type="text" placeholder="Enter your Claim Amount" name="totalClaimedAmt"  required="required"/><br>
			<label>Upload Bill: </label>
    		<input  type="file" name="image" accept="image/png, image/jpeg" required="required" />
     		<br>
     		<br>
			<input class="btn btn-primary" type="submit" value="Submit Claim" />

			</form>

			<hr>
		</div>
</body>
</html>