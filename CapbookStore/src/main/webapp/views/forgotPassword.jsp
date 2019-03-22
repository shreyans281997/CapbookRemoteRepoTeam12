<!DOCTYPE html>
<html lang="en">
<head>
<title>Forgot Password</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->

<style>

/* Add a gray background color and some padding to the footer */
footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #555;
	color: white;
	padding: 15px;
	text-align: center;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

div.a {
	font-size: 130%;
	color: white;
	align: right;
}

div.b {
	font-size: 300%;
	font-weight: bold;
	color: black;
}

div.c {
	font-size: 200%;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #111;
}

.topnav a.active {
	background-color: #000704;
	color: white;
}

.topnav-right {
	float: right;
	color: grey;
}
}
</style>
</head>
<body>
	<div class="topnav">
		<a class="active" href="#">Home</a>
		<div class="topnav-right">
			<a href="getSignUp"><span class="glyphicon glyphicon-log-in"></span>SignUp</a>
		</div>
	</div>


	<div class="row">

		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-8 text-left">

					<div class="b">CapBook</div>

					<p>Capbook helps you to connect and share with people in your
						life.</p>


					<hr>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-8">
				<img class="img-networking"
					src="https://www.ricohidc.com/images/networking.png" alt=""
					style="width: 590px; height: 421px" align="left">
			</div>
			<div class="col-sm-4">
				<br> <br>

				<div class="card bg-light">
					<form action="showLogin" method="post">


						<article class="card-body mx-auto" style="max-width: 400px">

							<h4 class="card-title mt-3 text-center">Forgot Password</h4>

							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-envelope"></i>
									</span>
								</div>

								<input name="emailId" class="form-control"
									placeholder="Email Id" type="email">
							</div>
							<!-- form-group// -->


							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-key"></i>
									</span>
								</div>
								<input name="newPassword" class="form-control"
									placeholder="New Password" type="password">
							</div>
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-question-circle" style="font-size: 24px"></i>
									</span> </span>
								</div>

								<select name="securityQue" class="form-control">
									<option selected="">Security Ques</option>
									<option value="schoolName">Your first School Name</option>
									<option value="petName">Your Pet Name</option>
									<option value="food">Your Favourite Food</option>
								</select>
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-reply"
										style="font-size: 24px"></i>
									</span>
								</div>
								<input name="answer" class="form-control" placeholder="Answer"
									type="text">
								<!-- form-group// -->
							</div>

							<!-- form-group// -->
							<div class="d-flex justify-content-center">
								<div class="form-group">

									<button type="submit" class="btn btn-primary btn-md">
										Submit</button>
								</div>
							</div>
							<!-- form-group// -->

							<div class="d-flex justify-content-center">

								<a href="loginPage">LogIn now!</a>

							</div>

						</article>
					</form>
				</div>
			</div>
		</div>
	</div>


	<footer class="container-fluid text-center">
		<div class="a">
			<p>@CapgeminiApp2019</p>
		</div>

	</footer>

</body>
</html>
