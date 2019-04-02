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
<td><form action="sendFriendRequest" method="post" id="friendReq">
<input type="hidden" name="receiverEmailId" value="${findUser.emailId }">
<input type="submit"  value ="Send Request" id="submitButton"  disabled="disabled" />
</tr></table>
<div>
${success}
${errorMessage}
</div>
</body>
<script type="text/javascript">
    window.onload=function() {
      setTimeout(function() {
        document.getElementById('submitButton').disabled = false;
      }, 5000); 
    }
</script>
</html>