
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.error {
	color: red;
	font-weight: bold;
}

footer {
	position: fixed;
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
div.b {
	font-size: 140%;
	color: black;
	text-align: center;
    font-weight: bold;
}

#respond {
	margin-top: 40px;
}

#respond input[type='text'], #respond input[type='email'], #respond textarea
	{
	margin-bottom: 10px;
	display: block;
	width: 100%;
	border: 1px solid rgba(0, 0, 0, 0.1);
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-o-border-radius: 5px;
	-ms-border-radius: 5px;
	-khtml-border-radius: 5px;
	border-radius: 5px;
	line-height: 1.4em;
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
	<div id="respond">

		<div class="b">Forward <span class="glyphicon glyphicon-pencil"></span></div>

		<form action="sendEmail" method="post" id="commentform">
                  <div class="form-group">
				    	<label for="to" class="col-sm-1 control-label" class="required">To:</label>
				    	<div class="col-sm-11">
                              <input type="email" name="toAddress" class="form-control select2-offscreen" id="to" placeholder="Type email address" tabindex="-1">
				    	</div>
				  	</div>
					<div class="form-group">
				    	<label for="subject" class="col-sm-1 control-label">Subject:</label>
				    	<div class="col-sm-11">
                              <input type="text" name="subject" value="${email.subject}" class="form-control select2-offscreen" id="subject" placeholder="Enter subject" tabindex="-1" readonly>
				    	</div>
				  	</div>

			<div class="form-group">
           <label for="messageBody" class="col-sm-1 control-label" class="required">Your message:</label>
            <div class="col-sm-11">
						<input type="text" class="form-control" name="messageBody" value="${email.messageBody}" id="messageBody" rows="12" readonly></textarea>
					</div>
            </div>
            
             <p align="center">
             <button type="submit" class="btn btn-primary btn-md">
				Send <span class="glyphicon glyphicon-send"></span></button>
              </p>
		</form>

	</div>
	<article>
		<div class="error" align="center">${errorMessage}
		           ${success }</div>
		   
		<br> <br>
	</article>
	<footer class="container-fluid text-center">
  <div class="a"><p>@CapgeminiApp2019</p></div>
</footer>

</body>
</html>