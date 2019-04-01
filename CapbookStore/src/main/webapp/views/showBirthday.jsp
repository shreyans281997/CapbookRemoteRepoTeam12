<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<title>Birthdays</title>
<meta charset="UTF-8">
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

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
footer {
	position: absolute;
	left: 0;
	width: 100%;
	margin-top:100px;
	background-color: #555;
	color: white;
	padding: 10px;
	text-align: center;
}

html, body, h1, h2, h3, h4, h5 {
	font-family: "RobotoDraft", "Roboto", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 16px
}
</style>

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
							<li><a href="getEditProfile">Edit Profile</a></li>
						</ul></li>
					<li class="active"><a href="#">Home</a></li>
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
					action="searchUser">
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
					<li><a href="showBirthday"><span
							class="glyphicon glyphicon-user"></span> log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
<div class="container">
 <h2><font color="#008CBA">Your Friends have birthday today</font></h2>
  <p>Wish them and make their day special</p>
  <c:forEach var="users" items="${users}">
  <div class="row">
    <div class="col-md-6 col-xl-4">                       
      <div class="card">
        <div class="card-body">
          <div class="media align-items-center"><span style="background-image: url(http://bootdey.com/img/Content/avatar/avatar6.png)" class="avatar avatar-xl mr-3"></span>
            <div class="media-body overflow-hidden">
              <h5 class="card-text mb-0">${users.firstName} ${users.secondName}</h5>
              <p class="card-text text-uppercase text-muted">${users.dateOfBirth}</p>
              <p class="card-text">
                 ${users.emailId}<br><abbr title="Phone">PH:  </abbr>${users.mobileNo}
                 
              </p>
              <p>
              <a href="getEmailPage">
          <span class="glyphicon glyphicon-gift" color="#008CBA"></span><font color="#008CBA">Send Greetings</font>
        </a>
             </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
    </c:forEach>
    </div>
    
<footer class="container-fluid text-center">
			<div class="a">
				<p>@CapgeminiApp2019</p>
			</div>
		</footer>

</body>
</html>
          
						