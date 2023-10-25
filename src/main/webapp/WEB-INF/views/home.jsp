<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<a href="http://localhost:8080/board/sports/soccer">축구</a>
	<br>
	<a href="http://localhost:8080/board/sports/soccer?minorCategory=epl">프리미어리그</a>
	<a href="http://localhost:8080/board/sports/soccer?minorCategory=laliga">라리가</a>
	<a href="http://localhost:8080/board/sports/soccer?minorCategory=bundesliga">분데스리가</a>
	<a href="http://localhost:8080/board/sports/soccer?minorCategory=seriea">세리에A</a>
	
	<a href="http://localhost:8080/member/signupForm">회원가입</a>
	<a href="http://localhost:8080/member/loginForm">로그인</a>
	
	

</body>
</html>
