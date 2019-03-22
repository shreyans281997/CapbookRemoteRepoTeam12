<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="getSignUp"><span
							class="glyphicon glyphicon-log-in"></span> SignUp</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row">

		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-8 text-left">
					<h1>CapBook</h1>
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
					src="https://www.ricohidc.com/images/networking.png" alt="">
			</div>
			<div class="col-sm-4">
				<div class="well">
					<div class="card bg-light">
						<form action="showLogin" method="post">
							<article class="card-body mx-auto" style="max-width: 400px">
								<h4 class="card-title mt-3 text-center">Login</h4>



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

								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">
										LogIn</button>
								</div>
								<!-- form-group// -->
								<div class="d-flex justify-content-center">
									<a href="getChangePassword">Forgot your password?</a>
								</div>
							</article>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>@CapgeminiApp2019</p>

	</footer>

</body>
</html>
