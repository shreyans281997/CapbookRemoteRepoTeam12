<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Profile</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/commentbox.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
div.b {
	font-size: 120%;
	font-weight: bold;
	color: white;
}
body
{
    font-family: 'Open Sans', sans-serif;
     background-color: #EBF5FB;
}
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
.round {
    width: 100%;
    border-radius: 15px;
    border: 1px #000 solid;
    padding: 5px 5px 5px 25px;
    position: absolute;
    top: 0;
    left: 0;
    z-index: 5;
}

.corner {
    position: absolute;
    top: 3px;
    left: 5px;
    height: 20px;
    width: 20px;
    z-index: 10;
    border-radius: 10px;
    border: none;
    background: #000; /* Set the bg image here. with "no-repeat" */
}

.search {
    position: relative;
    width: 190px;
    height: 30px;
}

</style>
<body>

<!-- Navbar -->
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
					<li><a href="getHomePage">Home</a></li>
					<li ><a href="getUserProfile">Profile</a></li>
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

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">My Profile</a>
</div>


<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    

    <!-- Right Column -->
    <div class="w3-center">
    
      <div class="w3-container w3-card w3-white w3-margin-bottom">
        <h2 class="w3-text-grey w3-padding-16"><font color="#008CBA"><i class="fa fa-paper-plane fa-fw w3-margin-right w3-xxlarge"></i>Post</font></h2>

								<<table>
		<tr>
			<td>
				<p>${post.postContent}</p>
			</td>
		<tr>
			<td>
				<form action="updateLikes" method="post">
					<input type="hidden" name="postId" value="${post.postId }">
					<input type="hidden" name="likedBy" value="${user.emailId }">
					<button type="submit" class="btn btn-default">
						<i class="glyphicon glyphicon-thumbs-up"></i> Like
						${post.totalLikeCount}
					</button>
				</form>
			</td>
			<td>Share</td>
		</tr>
		

	</table>
	<table>
             <div class="w3">
            <div class="w3-container w3-card w3-white w3-round w3-margin"><br>
				<form action="postComment" method="post">
                
					<input type="hidden" name="postId" value="${post.postId }">
					<input type="hidden" name="likedBy" value="${user.emailId }">
					<textarea rows="3" cols="100" name="comment">Write a comment......</textarea><br>
                    <button type="submit" class="btn btn-primary" style="float:right">Post Comment</button>
                    <br>
				</form>
                 <c:forEach var="entry" items="${post.comments}"> <table><tr><td>${user.emailId }&nbsp;:- <td><c:out value="${entry.value.commentContent}"/> </td></tr></table><hr> </c:forEach> 
                
                 </div>
			
							</div>
						</div>
					</div>
				
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
  <!-- End Page Container -->
</div>
<br>
<footer class="container-fluid text-center">
			<div class="a">
				<p>@CapgeminiApp2019</p>
			</div>
		</footer>

</body>
</html>