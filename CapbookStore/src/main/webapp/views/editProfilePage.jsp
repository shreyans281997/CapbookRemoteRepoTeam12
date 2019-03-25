<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
div.center{
text-align: center;
color: black;
}
div.successMsg{
text-align: center;
color: red;
}

  </style>
</head>
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
      	   <li><a href="#">Edit Profile</a></li>
      	   </ul></li>
        <li><a href="#">Home</a></li>
        <li><a href="showAllEmail">Messages</a></li>
		<li><a href="sendEmail">E-Mail</a></li>
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
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> log out</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="row">
  		<div class="center"><h3>User name</h3></div>
    </div>
    <div class="successMsg">${success}</div>
<div class="text-center">
        
      </div></hr><br>
<div class="container text-center">    
  <div class="row">
    <div class="col-sm-4">
    <form action="updatePic" enctype="multipart/form-data", method="post">
            <img src="${user.profilePic}" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6>Upload a different photo...</h6>
        <input type="file" name="file" class="text-center center-block file-upload">
        <input type="submit">
        </form>
     </hr><br>
     <form action="updateBio" method="post">
        <div class="panel panel-default">
            <div class="panel-heading">Bio <i class="fa fa-link fa-1x"></i></div>
           <input type="text" class="form-control" name="bio" id="bio" placeholder="Add Your Bio" title="enter your bio.">
            <button type="submit" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-edit"></span> Edit
        </button><br><br>
          </div>
   </div>
   </form>
      
    <div class="col-sm-8">
    <form action="updateAddress" method="post">
    <div class="panel panel-default  ">
    <div class="panel-heading"><h3>Address Information</h3><i class="fa fa-link fa-1x"></i></div>
          
            <div class="panel-body">
            
               <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="city"><h4>City</h4></label>
                              <input type="text" class="form-control" name="city" id="first_name" placeholder="city" title="enter your city.">
                              <label for="country"><h4>Country</h4></label>
                              <input type="text" class="form-control" name="country" id="country" placeholder="country" title="enter your country">
                         
                          
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="state"><h4>State</h4></label>
                              <input type="text" class="form-control" name="state" id="state" placeholder="state" title="enter your state.">
                              <label for="zipCode"><h4>Zipcode</h4></label>
                              <input type="text" class="form-control" name="zipCode" id="zipCode" placeholder="zipcode" title="enter your zipCode."><br>
                         
                      </div> 
                     
                      <button type="submit" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-edit"></span> Update Info
        </button><br>
                      </div></div></div></form></div>
                     
          <div class="panel panel-default"><form action="updatePassword" method="post">
          <div class="panel-heading"><h3>Change Password</h3><i class="fa fa-link fa-1x"></i></div>
            <div class="panel-body">
           
               <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="password"><h4>Current Password</h4></label>
                              <input type="text" class="form-control" name="oldPassword" id="password" placeholder="password" title="enter your current password.">
                          
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="newPassword"><h4>New Password</h4></label>
                              <input type="text" class="form-control" name="newPassword" id="newPassword" placeholder="new password" title="enter your new password."><br>
                         
                      </div> 
                      <button type="submit" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-edit"></span> Update Info
        </button><br>
                      </div></div></form>
            
           </div>
         </div>
          
          <div class="panel panel-default  "><form action="updateProfessionalInfo" method="post">
          <div class="panel-heading"><h3>Professional Information</h3><i class="fa fa-link fa-1x"></i></div>
            <div class="panel-body">
               <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="newPassword"><h4>Business Profile</h4></label>
                              <input type="text" class="form-control" name="businessProfile" id="businessProfile" placeholder="business Profile" title="enter your business profile.">
                          
                              <label for="password"><h4>Work Experience</h4></label>
                              <input type="text" class="form-control" name="workExperience" id="workExperience" placeholder="workExperience" title="enter your work experience.">
                         
                      </div> 
                      <div class="form-group">
                      <div class="col-xs-6">
                       <label for="password"><h4>Work Place</h4></label>
                              <input type="text" class="form-control" name="workPlace" id="workPlace" placeholder="workPlace" title="enter your work place.">
                              
                              <label for="password"><h4>Mobile Number</h4></label>
                              <input type="text" class="form-control" name="mobileNo" id="mobileNo" placeholder="mobileNo" title="enter your mobile number."><br>
                         </div>
                      
                      <button type="submit" class="btn btn-primary btn-sm">
          <span class="glyphicon glyphicon-edit"></span> Update Info
        </button><br>
                      </div></div></div></form></div>
</div>
</div>
</div>
<footer class="container-fluid text-center">
  <div class="a"><p>@CapgeminiApp2019</p></div>
</footer>

</body>
</html>