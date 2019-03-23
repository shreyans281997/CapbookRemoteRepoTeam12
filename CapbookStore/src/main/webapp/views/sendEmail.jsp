<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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

#respond {
	margin-top: 40px;
}

#respond input[type='text'], #respond input[type='email'], #respond textarea
	{
	margin-bottom: 10px;
	display: block;
	width: 100%;
	border: 1px solid rgba(0, 0, 0, 0.1);
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-o-border-radius: 5px;
	-ms-border-radius: 5px;
	-khtml-border-radius: 5px;
	border-radius: 5px;
	line-height: 1.4em;
}
</style>

</head>
<body>
	<div id="respond">

		<h3>Send Important E-mail</h3>

		<form action="sendEmail" method="post" id="commentform">


			<label for="email" class="required">Send To email;</label> <input
				type="email" name="toAddress" id="email" value="" tabindex="2"
				required="required"> <label for="subject" class="required">Enter
				Subject</label>
			<textarea name="subject" id="subject" rows="2" tabindex="4"
				required="required"></textarea>

			<label for="messageBody" class="required">Your message</label>
			<textarea name="messageBody" id="messageBody" rows="10" tabindex="4"
				required="required"></textarea>

			<input type="hidden" name="comment_post_ID" value="1"
				id="comment_post_ID" /> <input name="submit" type="submit"
				value="Send" color="blue" />

		</form>

	</div>
	<article>
		<div class="error" align="center">${errorMessage}</div>
		<br> <br>
	</article>
	<footer class="container-fluid text-center">
		<div class="a">
			<p>@CapgeminiApp2019</p>
		</div>
	</footer>
</body>
</html>