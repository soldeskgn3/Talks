<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board/create" method="post" >
    <input type="text" name="posts_title" placeholder="제목" required maxlength="40"><br>
    <textarea name="posts_content" placeholder="내용" required maxlength="300"></textarea><br>
    <input type="text" name="member_nickname" placeholder="작성자" required maxlength="30"><br>
    <input type="hidden" name="mainCategory" value="${mainCategory}">
    <input type="hidden" name="subCategory" value="${subCategory}">
    <c:choose>
        <c:when test="${not empty param.minorCategory}">
            <input type="hidden" name="minorCategory" value="${param.minorCategory}">
        </c:when>
    </c:choose>
    <input type="submit" value="글 작성">
</form>
</body>
</html>