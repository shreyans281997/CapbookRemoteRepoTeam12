
<!DOCTYPE html>
<html lang="en">
<title>Your E-mail</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
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
html,body,h1,h2,h3,h4,h5 {font-family: "RobotoDraft", "Roboto", sans-serif}
.w3-bar-block .w3-bar-item {padding: 16px}
</style>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
        <span class="icon-bar"></span>
      </button>
      
    
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <li class="dropdown">
           <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon">&#xe012;</span>
           </a>
           <ul class="dropdown-menu">
     	   <li><a href="#">Show Friends</a></li>
      	   <li><a href="getEditProfile">Edit Profile</a></li>
      	   </ul></li>
        <li><a href="getHomePage">Home</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Messages</a>
        <ul class="dropdown-menu">
     	   <li><a href="getEmailPage">Compose</a></li>
      	   <li><a href="showAllEmail">Inbox</a></li>
      	   <li><a href="showAllSentEmail">Sent Mails</a></li>
      	   </ul></li>
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
        <li><a href="endSession"><span class="glyphicon glyphicon-user"></span> log out</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Overlay effect when opening the side navigation on small screens -->

<!-- Page content -->
 <div class="row">
 <div class="col-sm-3"></div>
 <div class="col-sm-6">
<div class="w3-main" style="margin-center:320px;">
<div id="Borge" class="w3-container person">
  <br>
  <img class="w3-round  w3-animate-top" src="" style="width:20%;">
  <h5 class="w3-opacity">Subject: ${email.subject}</h5>
  <h4><i class="fa fa-clock-o"></i>${email.toAddress}, ${email.dateOfMail}</h4>
  <hr>
  <p>${email.messageBody}</p>
  
  <p>Best Regards, <br>${user.firstName}</p>
  
</div>
</div>
</div>
 <div class="col-sm-3"></div>
 </div>
<footer class="container-fluid text-center">
  <div class="a"><p>@CapgeminiApp2019</p></div>
</footer>

</body>
</html>