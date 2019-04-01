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
	position: bottom;
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
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="homePage" class="w3-bar-item w3-button w3-padding-large w3-theme-d4" title="Go to HomePage"><div class="b">CapBook</div></a>
 
 <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="My Account"><i class="fa fa-user"></i></button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="getEmailPage" class="w3-bar-item w3-button">Show Friends</a>
      <a href="getEditProfile" class="w3-bar-item w3-button">Edit Profile</a>
    </div>
  </div>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Messages"><i class="fa fa-envelope"></i></button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="getEmailPage" class="w3-bar-item w3-button">Compose</a>
      <a href="showAllEmail" class="w3-bar-item w3-button">Inbox</a>
      <a href="showAllSentEmail" class="w3-bar-item w3-button">Sent Mails</a>
    </div>
  </div>
    <form class="navbar-form navbar-right" role="search">
        <div class="form-group input-group">
          <input type="text" class="form-control" placeholder="Search..">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button">
              <span class="glyphicon glyphicon-search"></span>
            </button>
          </span>        
        </div>
        
        <div class="w3-bar-item w3-button w3-right w3-padding-small w3-theme-d1">
        &nbsp <a href="showBirthday">Log out </a>&nbsp
        </div>
      </form>
         
 </div>
</div>

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
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container">
          <img src="${user.profilePic }" style="width:100%" alt="Avatar">
           </div>
            <h2><font color="#008CBA">  ${user.firstName} ${user.secondName}</font></h2>
        <div class="w3-container">
          <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-grey"></i>BusinessProfile</p>
          <p><i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-grey"></i>State,Country</p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-grey"></i>EmailAddress</p>
          <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-grey"></i>MobileNo</p>
          <hr>

          <p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-black"></i>Bio</b></p>
          <p><font color="#008CBA">${user.bio }</font></p>
          <hr>
          <p class="w3-large w3-text-theme"><b><i class="fa fa-globe fa-fw w3-margin-right w3-text-black"></i>Basic Details</b></p>
         <p>Gender-<font color="#008CBA">${user.gender }</font></p>
         
          <p>City- <font color="#008CBA">${user.address.city}</font></p>
          
          <p>State-<font color="#008CBA">${user.address.state}</font></p>
          
          <p>Country-<font color="#008CBA">${user.address.country}</font></p>
          
           <p>Zip Code-<font color="#008CBA">${user.address.zipCode}</font></p>
            
             <p>Date Of Birth-<font color="#008CBA">${user.dateOfBirth}</font></p>
             
              <p>Mobile No-<font color="#008CBA">${user.mobileNo }</font></p>
          <hr>

          <p class="w3-large"><b><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-black"></i>Professional Info</b></p>
          <p>Business Profile-<font color="#008CBA">${user.businessProfile }</font></p>
          
          <p>Work Place-<font color="#008CBA">${user.workPlace }</font></p>
          
          <p>Work experience-<font color="#008CBA">${user.workExperience}</font></p>
         
        </div>
      </div><br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird">
    
      <div class="w3-container w3-card w3-white w3-margin-bottom">
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-paper-plane fa-fw w3-margin-right w3-xxlarge w3-text-grey"></i>My Posts</h2>
       <c:forEach var="posts" items="${user.posts}">
					<div class="row">
						<div class="col-sm-3">
							<div class="well">
								<p><font color="#008CBA"> ${user.firstName } ${user.secondName }</font></p>
								<img src="${user.profilePic}" class="img-circle" height="55"
									width="55" alt="Avatar">
							</div>
						</div>
						<div class="col-sm-9">
							<div class="well">
							<p align="right">${posts.timeOfPost }</p>
								<table>
										<tr>
										<td><p>${posts.postContent}</p></td>
										</tr>
										<tr><td></td></tr>
									<tr>
										<td>
											<form action="updateLikes" method="post">
												<input type="hidden" name="postId" value="${posts.postId }">
												<input type="hidden" name="likedBy" value="${user.emailId }">
												<button type="submit" class="btn btn-default">
													<i class="glyphicon glyphicon-thumbs-up"></i> Like
													${posts.totalLikeCount}
												</button>
											</form>
										</td>
										<td>
										<form action="showAllPost" method="post">
										<input type="hidden" name="postId" value="${posts.postId }">
											<button type="submit" class="open-homeEvents btn btn-default"
												data-id="${posts.postId }" data-toggle="modal"
												data-target="#myModal">
												
												Comment <i class="glyphicon glyphicon-comment"></i>
											</button> </form>
													
										</td>
									</tr>
								</table>

							</div>
						</div>
					</div>
				</c:forEach>
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