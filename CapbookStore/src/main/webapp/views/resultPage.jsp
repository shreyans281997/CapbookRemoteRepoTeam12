<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<table>
<tr>
<td>
<a href="">${findUser.firstName} ${findUser.secondName } ${findUser.emailId}</a></td>
<td><form action="sendFriendRequest" method="post">
<input type="hidden" name="receiverEmailId" value="${findUser.emailId }">
<input type="submit" value="Send Request"></form>
</tr></table>
<div>
${success}
${errorMessage}
</div>
</body>
</html>