<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<title>Registration</title>
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
	padding: 15px;
	text-align: center;
}

.row.content {
	height: 100px
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #000000;
}

li {
	float: left;
}

li a:hover {
	background-color: #111;
}

div.a {
	font-size: 150%;
}

div.b {
	font-size: 300%;
	font-weight: bold;
	color: white;
}
</style>
</head>
<body>
	<ul>
		<li><div class="b">CapBook</div></li>

	</ul>
	<br>
	<br>
	<div class="container">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">Sign Up</h4>

				<form action="showSignup" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="firstName" class="form-control"
							placeholder="First name" type="text">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="secondName" class="form-control"
							placeholder="Last name" type="text">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span> </span>
						</div>

						<select class="form-control">
							<option selected="">Select Gender</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="other">Other</option>
						</select>


					</div>
					<!-- form-group// -->

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i
								class="fas fa-calendar-alt"></i>
							</span>
						</div>
						<input name="dateOfBirth" class="form-control" placeholder="Date"
							type="Date">
					</div>
					<!-- form-group// -->




					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="emailId" class="form-control" placeholder="Email Id"
							type="email">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-phone"></i>
							</span>
						</div>
						<input name="mobileNo" class="form-control"
							placeholder="Mobile Number" type="text">
					</div>
					<!-- form-group// -->

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="password" class="form-control"
							placeholder="Create password" type="password">
					</div>
					<!-- form-group// -->
					<!-- form-group// -->
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
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Create Account</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="getLogin">Log In</a>
					</p>
				</form>
			</article>
		</div>
	</div>
	<!-- card.// -->
	<article>
		<div class="error" align="center">
        ${errorMessage}
			
		</div>
		<br> <br>
	</article>
	<footer class="container-fluid text-center">
		<div class="a">
			<p>@CapgeminiApp2019</p>
		</div>
	</footer>

</body>
</html>
