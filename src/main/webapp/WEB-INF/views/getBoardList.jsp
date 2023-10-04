<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="board" items="${list}">
	<tr>
		<td>${board.posts_num }</td>
		<td>${board.posts_title }</td>
		<td>${board.posts_content }</td>
		<td>${board.posts_tag }</td>
		<td>
			<fmt:formatDate value="${board.posts_date }" pattern="yyyy-MM-dd hh:mm:ss"/>	
		</td>
		<td>${board.posts_hit }</td>
		<td>${board.posts_name }</td>
		<td>${board.posts_good }</td>

</c:forEach>

</body>
</html>