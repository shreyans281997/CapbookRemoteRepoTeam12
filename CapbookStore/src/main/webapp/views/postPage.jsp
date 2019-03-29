<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<p>${post.postContent}</p>
			</td>
		<tr>
			<td>
				<form action="updateLikes" method="post">
					<input type="hidden" name="postId" value="${post.postId }">
					<input type="hidden" name="likedBy" value="${user.emailId }">
					<button type="submit" class="btn btn-default">
						<i class="glyphicon glyphicon-thumbs-up"></i> Like
						${post.totalLikeCount}
					</button>
					<input type="submit" value="comment">
				</form>

			</td>
			<td>Share</td>
		</tr>
		<tr>
			<td>
				<form action="postComment" method="post">
					<input type="hidden" name="postId" value="${post.postId }">
					<input type="hidden" name="likedBy" value="${user.emailId }">
					<textarea rows="2" cols="50" name="comment">Write a comment......</textarea>
					<input type="submit">
				</form>
			</td>
		</tr>
	</table>
	<table> <c:forEach var="entry" items="${post.comments}"> <tr><td>${user.emailId } <td><c:out value="${entry.value.commentContent}"/> </td></tr> </c:forEach> </table> 

</body>
</html>