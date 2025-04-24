<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Member Portal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.container{
	margin-top: 120px;
	max-width: 600px;
	height: 600px;
}
h1{
	color:white;
	text-shadow: 2px 2px 2px #CCCCCC;
}
</style>
</head>

 

<body class="bg1">
<div class="navbar1">
			<a class="active" href="/"><i class="fa fa-fw fa-home"></i>Claims Management System</a>
			 <a class="active" href="/logout"><i class="fa fa-fw fa-sign-out"></i> Logout</a> 
		</div>
		<center>
		<div class="container">
		<h1>Member Portal</h1><br>
    <div class=" btn-group-vertical  text-center">
        <a class="btn btn-primary" href="showClaimSubmit">Submit Claim</a><br>
        <a class="btn btn-primary" href="showStatusSubmit">View Claim Status</a><br>
        <a class="btn btn-primary" href="showViewBillPage">View Bills</a><br>
    </div>
    </div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
 




