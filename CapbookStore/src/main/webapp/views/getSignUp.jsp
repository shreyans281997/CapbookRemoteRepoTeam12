<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<title>Registration</title>
<style>
.error {
	color: blue;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container">

		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">Sign Up</h4>

				<form action="showSignup" method="post">
					<div class="error">${errorMessage}</div>
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
						<input name="lastName" class="form-control"
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
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-question-circle" style="font-size:24px"></i>
							</span> </span>
						</div>

						<select class="form-control">
							<option selected="">Security Ques</option>
							<option value="schoolName">Your first School Name</option>
							<option value="petName">Your Pet Name</option>
							<option value="food">Your Favourite Food</option>
						</select>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-reply" style="font-size:24px"></i>
							</span>
						</div>
						<input name="answer" class="form-control" placeholder="Answer"
							type="text">
						<!-- form-group// -->
					</div>
					
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
		<div>
			<!--container end.//-->

			<i class="fa fa-window-restore "></i>
		</div>
		<br> <br>
	</article>

</body>
</html>