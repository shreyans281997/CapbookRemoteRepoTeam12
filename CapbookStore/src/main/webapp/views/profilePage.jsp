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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">


  <style>
   footer {
	position: bottom;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #555;
	color: black;
	padding: 10px;
	text-align: center;
}

div.a {
	font-size: 115%;
	color: white;
	align: right;
}
div.b {
	font-size: 15px;
	font-color: #2E86C1;
	align: center;
}
.round_img{
position: relative;
margin-left: auto;
  margin-right: auto;
  width: 150px;
  height: 150px;
  overflow: hidden;
  border-radius: 50%;
 
}
.round_img img {
  width: 100%;
  height: auto;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
#main h1 { background: #ccc;}
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
body
{
    font-family: 'Open Sans', sans-serif;
     background-color: #EBF5FB;
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
      	   <li><a href="#">Sent Mails</a></li>
      	   </ul></li>
           <li><a href="getHomePage">FriendList</a></li>
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



<div class="container"><br>
  
        <div style="background:#1B4F72   !important" class="jumbotron">
  <div class="container text-center">
    <div class="a"><h1>Capbook</h1>      
    <p>My Profile</p></div>

<div class="round_img">
    <img src="http://lorempixel.com/100/100/people/9/" alt="">
     </div>    
  </div>

</div>
</div> <!-- /container -->  

  
<div class="container-fluid bg-3 text-center">    
  
  <div class="row">
  <div class="col-sm-1"></div>
   
    <div class="col-sm-4"> 
      <div class="container text-center"> 
      <div class="row">
       <div class="col-sm-3">
    <h2><b>Username</b></h2>
    <div class="well">
        <div class="b">Bio</div>
        <div class="panel-body">
       
       </div>
       </div>     
      
       
       <div class="well">
        <div class="b">About</div>
        <div class="panel-body">
       
  <table id="t01">
  <tr>
    <td>City</td>
    <td>  </td>
  </tr>
  <tr>
    <td>State</td>
    <td>  </td>
  </tr>
  <tr>
    <td>Country</td>
    <td>  </td>
  </tr>
  <tr>
    <td>Zipcode</td>
    <td>  </td>
  </tr>
   <tr>
    <td>Date Of Birth</td>
    <td>  </td>
  </tr>
   <tr>
    <td>Business Profile</td>
    <td>  </td>
  </tr>
    <tr>
    <td>Work Place</td>
    <td>  </td>
  </tr>
  <tr>
    <td>Work Experience</td>
    <td>  </td>
  </tr>
   <tr>
    <td>Mobile No</td>
    <td>  </td>
  </tr> 
</table>

       </div>
       </div>     
       
       </div>
       </div>
    </div>
   </div>
<div class="col-sm-6"> 
<c:forEach var="posts"
				items="${posts}">
      <div class="row">
        <div class="col-sm-3">
          <div class="well">
           <p>${user.firstName} ${user.secondName }</p>
           <img src="${user.profilePic}" class="img-circle" height="55" width="55" alt="Avatar">
          </div>
        </div>
        <div class="col-sm-9">
          <div class="well">
          <table>
          <tr>
           <td> <p>${posts.postContent}</p></td>
            <tr>
             <td> 
             <form action="updateLikes" method="post">
             <input type="hidden" name="postId" value="${posts.postId }">
             <input type="hidden" name="likedBy" value="${user.emailId }">
              <button type="submit" class="btn btn-primary">
              <i class="glyphicon glyphicon-thumbs-up"></i> Like ${posts.totalLikeCount}
                </button></form> </td>
            <td>  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Comment
              <i class="glyphicon glyphicon-comment"></i></button>
              <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
           
           <div id="wrapper" align="left">

	<form id="paper" method="get" action="postComment">
        <input type="hidden" name="postId" value="${posts.postId }">
		<textarea placeholder="Enter something funny." id="text" name="comment" rows="1" cols="30" style="overflow: hidden; word-wrap: break-word; resize: none; height: 100px; "></textarea>  
		<input id="button" type="submit" value="comment">
		${comments } <!-- loop lgana hai -->
	</form>

</div>
           
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
              </td>
              </tr>
                </table>
                
          </div>
        </div>
      </div>
       </c:forEach>
</div>
</div>
<footer class="container-fluid text-center">
  <div class="a"><p>@CapgeminiApp2019</p></div>
</footer>

</body>
</html>
