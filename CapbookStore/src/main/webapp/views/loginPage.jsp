<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
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
.flash-error {
    background-color: #ffdce0;
    color: #86181d;
}
.error {
	color: red;
	font-weight: bold;
}

.success {
	color: green;
	font-weight: bold;
}
/* Add a gray background color and some padding to the footer */
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
	font-size: 115%;
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
					<form name="myform" action="showLogin" method="post" >


						<article class="card-body mx-auto" style="max-width: 400px">

							<h4 class="card-title mt-3 text-center">Login</h4>
                            
                            <!-- <div class="flash-error"><span id="errorMsg"></span></div> -->

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
								<input name="password" class="form-control"
									placeholder="Password" type="password">
							</div>

							<!-- form-group// -->
							<div class="d-flex justify-content-center">
								<div class="form-group">

									<button type="submit" class="btn btn-primary btn-md">
										LogIn</button>
								</div>
							</div>
							<!-- form-group// -->
							<div class="d-flex justify-content-center">

								<a href="getForgotPassword">Forgot your password?</a>

							</div>

						</article>
					</form>
					<div class="error" align="center">${errorMessage}</div>
					<div class="success" align="center">${register}</div>
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
