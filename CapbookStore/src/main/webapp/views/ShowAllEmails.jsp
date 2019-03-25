<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
/* Set black background color, white text and some padding */
footer {
	position: bottom;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #555;
	color: white;
	padding: 10px;
	text-align: center;
}

div.a {
	font-size: 115%;
	color: white;
	align: right;
}

div.center {
	text-align: center;
	color: black;
}

div.successMsg {
	text-align: center;
	color: red;
}
</style>
<script>
    function processVehicles()
    {
        var vehicleTypes = document.getElementsByName("email");
        var form = document.getElementById("email");
        form.submit();
    }
</script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>


			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><span class="glyphicon">&#xe012;</span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">Show Friends</a></li>
							<li><a href="#">Edit Profile</a></li>
						</ul></li>
					<li><a href="#">Home</a></li>
					<li><a href="#">Messages</a></li>
					<li><a href="getEmailPage">E-Mail</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group input-group">
						<input type="text" class="form-control" placeholder="Search..">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							log out</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div>
		<table id="customers">
			<c:forEach var="email" items="${requestScope.email}">
				<form action="showEmail" method="post" id="emails">
					<input type="hidden" name="emailChatId"
						value="${email.emailChatId}"> <input type="hidden"
						name="emailId" value="${email.fromAddress}">
					<tr>
						<td><div class="radio">
								<label><input type="radio" name="email"><a
									href="${email.emailChatId}_${email.fromAddress}_${email.subject}_${email.dateOfMail}"
									onclick="document.getElementById('emails').submit()">ID-: ${email.emailChatId} From-:
										${email.fromAddress} Subject-:${email.subject } Date-:
										${email.dateOfMail }</a></label></td>
					</tr>
				</form>
				
			</c:forEach>
		</table>
	</div>
</body>
</html>