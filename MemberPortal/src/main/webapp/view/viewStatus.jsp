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
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="navbar">
			<a class="active" href="/"><i class="fa fa-fw fa-home"></i>Claims Management System</a>
			 <a class="active" href="/logout"><i class="fa fa-fw fa-sign-out"></i> Logout</a> 
		</div>
<form method="post">
	<div class="container">
		<br> 
		<a href="memberHome" class="previous">&laquo;Back</a>
		<br>
		<br>
		<h1>Member Portal Service</h1>
		<hr>
		<h2>Your Claim Status</h2>

		<table  class="table table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">Claim Id</th>
					<th scope="col">Claim Status</th>
					<th scope="col">Claim Desc</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="claimRes" items="${claim}">
						<tr>
						    <td>${claimRes.getClaimId() }</td>
							<td>${claimRes.getClaimStatus() }</td>
							<td>${claimRes.getClaimDesc() }</td>
						
						</tr>
			</c:forEach>
		
			</tbody>
		</table>
		<hr>

	</div>
</form>
</body>
</html>