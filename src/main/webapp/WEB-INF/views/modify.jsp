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

<form action="/board/modifyPost" method="post">
    <input type="hidden" name="posts_num" value="${read.posts_num}">
    <input type="text" name="posts_title" value="${read.posts_title}">
    <textarea name="posts_content">${read.posts_content}</textarea>
    <input type="hidden" name="mainCategory" value="${mainCategory}">
    <input type="hidden" name="subCategory" value="${subCategory}">
    <c:choose>
        <c:when test="${not empty param.minorCategory}">
            <input type="hidden" name="minorCategory" value="${param.minorCategory}">
        </c:when>
    </c:choose>
    <input type="submit" value="수정">
</form>

</body>
</html>