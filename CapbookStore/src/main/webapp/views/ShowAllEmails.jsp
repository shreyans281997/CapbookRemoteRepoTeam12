<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Email Inbox</title>
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
	position: absolute;
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
							<li><a href="showFriendList">Show Friends</a></li>
							<li><a href="getEditProfile">Edit Profile</a></li>
						</ul></li>
					<li class="active"><a href="getHomePage">Home</a></li>
					<li class="active"><a href="getUserProfile">Profile</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Messages</a>
						<ul class="dropdown-menu">
							<li><a href="getEmailPage">Compose</a></li>
							<li><a href="showAllEmail">Inbox</a></li>
							<li><a href="showAllSentEmail">Sent Mails</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right" role="search"
					action="showOtherUserProfile">
					<div class="form-group input-group">
						<input type="text" class="form-control" placeholder="Search.."
							name="emailId"> <span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="endSession"><span
							class="glyphicon glyphicon-user"></span> log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
  <h2><font color="#008CBA">Inbox</font></h2>
  <p>Check your mail. May be something Important is there.</p>
  <p><font color="red">${success}</font></p>
  <p><font color="red">${errorMessage}</font></p>
  <table class="table">
  <tr><td>
           <button type="button" color="#008CBA"><a href="delAllEmail" >
          <span class="glyphicon glyphicon-trash"></span> Delete All Mails 
        </a></button></td></tr>
        <tr>
    <c:forEach var="email" items="${requestScope.email}">
				<form action="showEmail" method="post" id="emails">
					<input type="hidden" name="emailChatId"
						value="${email.emailChatId}"> <input type="hidden"
						name="emailId" value="${email.toAddress}">
					
           <td> <button type="submit"><a href="#">
          <span class="glyphicon glyphicon-envelope"></span></a></button></td>
          	</form>
          	
          	<form action="delEmail" method="post" id="delEmail">
          	<input type="hidden" name="emailChatId"
						value="${email.emailChatId}"> <input type="hidden"
						name="emailId" value="${email.toAddress}">
          	<td> <button type="submit"><a href="#">
          <span class="glyphicon glyphicon-trash"></span></td></form>
						<td>
								ID-: ${email.emailChatId} From-:
										${email.fromAddress} Subject-:${email.subject } Date-:
										${email.dateOfMail }</td>
					</tr>
				</c:forEach>
               
  
  </table>
</div>
 <footer class="container-fluid text-center">
			<div class="a">
				<p>@CapgeminiApp2019</p>
			</div>
		</footer>
</body>
</html>