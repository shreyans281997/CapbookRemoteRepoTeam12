<!DOCTYPE html>
<html lang="en">
<title>W3.CSS Template</title>
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
	bottom: 0;
	width: 100%;
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
					<li><a href="showBirthday"><span
							class="glyphicon glyphicon-user"></span> log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Overlay effect when opening the side navigation on small screens -->

	<!-- Page content -->
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="w3-main" style="margin-center: 320px;">
					<h5 class="w3-opacity">Subject: ${email.subject }</h5>
					<h4>
						<i class="fa fa-clock-o"></i>From ${email.fromAddress },
						${email.dateOfMail }
					</h4>
					<form action="replyEmail" method="post" id="commentform">
						<p align="right" right="100px">
							<button type="submit" class="btn btn-primary btn-md">
								reply <span class="glyphicon glyphicon-send"></span>
							</button>
						</p>
						<div class="form-group">
							<div class="col-sm-11">
								<input type="hidden" name="emailId"
									class="form-control select2-offscreen" id="to"
									value="${email.toAddress }" tabindex="-1">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-11">
								<input type="hidden" name="emailChatId"
									class="form-control select2-offscreen" id="emailChatId"
									value="${email.emailChatId }" tabindex="-1">
							</div>
						</div>
				</form>
				<form action="forwardEmail" method="post" id="commentform">
					<p align="right">
						<button type="submit" class="btn btn-primary btn-md">
							Forward<span class="glyphicon glyphicon-send"></span>
						</button>
					</p>
					<div class="form-group">
						<div class="col-sm-11">
							<input type="hidden" name="emailId"
								class="form-control select2-offscreen" id="to"
								value="${email.toAddress }" tabindex="-1">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-11">
							<input type="hidden" name="emailChatId"
								class="form-control select2-offscreen" id="emailChatId"
								value="${email.emailChatId }" tabindex="-1">
						</div>
					</div>
		</form>
			<hr>
			<h6>${email.messageBody }</h6>
            <p>
				Best Regards, <br>${user.firstName }</p>
		</div>
	</div>
	</div>

	<div class="col-sm-3"></div>

	<footer class="container-fluid text-center">
		<div class="a">
			<p>@CapgeminiApp2019</p>
		</div>
	</footer>

</body>
</html>