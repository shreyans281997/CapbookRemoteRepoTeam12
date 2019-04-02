<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home Page</title>
<meta charset="utf-8">
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

	<div class="container text-center">
		<div class="row">
			<div class="col-sm-3 well">
				<div class="well">
					<p>
						<font color="#2E86C1">${user.firstName} ${user.secondName}</font>
					</p>
					<img src="${user.profilePic}" class="img-circle" height="65"
						width="65" alt="Avatar">
				</div>
				<div class="well">
					<p>
						<font color="#2E86C1">Bio</font>
					</p>
					<div class="panel-body">
						<p>${user.bio}</p>
					</div>
				</div>
				<div class="alert alert-success fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<p>
						<strong>Ey!</strong>
					</p>
					Some new friend requests have come up.
				</div>
				<p>
					<font color="black">Friend requests:</font>
				</p>
				<p>
					<a href="showFriendRequest"><font color="#008CBA">See, who want to connect to you.</font></a>
			    </p>
			</div>
			<div class="col-sm-7">

				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default text-left">
							<div class="panel-body">
								<form action="updatePost" method="post">
									<p>
									<p><font color="#008CBA">Hey,Write what ever is in your mind</font></p>
										<textarea class="form-control" name="postContent" rows="4"
											id="status"></textarea>
									</p>
									<p align="right">
										<button type="submit" class="btn btn-primary btn-sm">
											<i class="glyphicon glyphicon-send"></i> Post
										</button>

									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="posts" items="${posts}">
					<div class="row">
						<div class="col-sm-3">
							<div class="well">
								<p>${posts.user.firstName } ${posts.user.secondName }</p>
								<img src="${posts.user.profilePic}" class="img-circle" height="55"
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
										<form action="showPost" method="post">
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
				<div class="col-sm-2 well">
					<div class="thumbnail">
						<p>Upcoming Events:</p>
						<img src="paris.jpg" alt="Paris" width="400" height="300">
						<p>
							<strong>Wish your friends on their birthday.</strong>
						</p>
						<p><a href ="showBirthday"><font color="#008CBA">See, who has birthday today.</font></a></p>
					</div>
				</div>
			</div>
		</div>

		<footer class="container-fluid text-center">
			<div class="a">
				<p>@CapgeminiApp2019</p>
			</div>
		</footer>
		<script>
			$(document).on("click", ".open-homeEvents", function() {
				var eventId = $(this).data('id');
				$('#idHolder').html(eventId);
				document.getElementById('myField').value = eventId;

			});
		</script>
</body>
</html>