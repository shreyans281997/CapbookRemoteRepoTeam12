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

<title>Log In Page</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container">

		<div class="card bg-light">
		<form action="showLogin" method="post">
			<article class="card-body mx-auto" style="max-width: 400px">
				<h4 class="card-title mt-3 text-center">Login</h4>

				

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
							<span class="input-group-text"> <i class="fa fa-key"></i>
							</span>
						</div>
						<input name="password" class="form-control" placeholder="Password" type="password">
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

	
	
	<div>
	${success }

	<i class="fa fa-window-restore "></i>
	
	</div>
	<br>
	<br>
	</article>
</body>
</html>