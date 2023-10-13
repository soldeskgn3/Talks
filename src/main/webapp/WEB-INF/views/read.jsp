<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/resources/js/comments.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>글 상세 페이지</h1>

	<table>
		<tr>
			<td>글 번호:</td>
			<td>${read.posts_num}</td>
		</tr>
		<tr>
			<td>제목:</td>
			<td>${read.posts_title}</td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td>${read.posts_name}</td>
		</tr>
		<tr>
			<td>작성날짜:</td>
			<td><fmt:formatDate pattern="MM-dd hh:mm"
					value="${read.posts_date}" /></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td>${read.posts_content}</td>
		</tr>
	</table>

	<h2>댓글 목록</h2>
	<div id="commentsList"></div>

	<h2>댓글 작성</h2>
	<form id="commentForm" action="addComment" method="post">
		<input type="text" id="writer" name="writer" placeholder="작성자" required> 
		<br>
		<textarea id="content" name="content" placeholder="댓글 내용" rows="4" cols="50" required></textarea>
		<br> 
		<input type="hidden" id="postId" name="postId" value="${read.posts_num}">
		<button type="button" id="commentButton">댓글 작성</button>
	</form>

</body>
</html>