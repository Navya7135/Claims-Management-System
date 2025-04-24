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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Claims Manage Management</title>
</head>
<body>

		<div class="navbar1">
		<a class="active" href="/login"><i class="fa fa-fw fa-sign-in"></i> Sign-In</a>
		<a class="active" href="/about"><i class="fa fa-fw fa-info"></i> About</a>
		</div>
		<div class="banner d-flex justify-content-center align-items-center">
		<div class="text-center">
			<h1>Claims Management System</h1>
			<p>Manage all your Claims and Settlements all in one Place.</p>
			<a href="memberHome" ><button class="btn bg-primary1 btn-lg text-white active" >Member Portal</button></a>
		</div>
	</div>

</body>
</html>
 




