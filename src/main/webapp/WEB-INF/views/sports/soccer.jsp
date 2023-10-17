<%@page import="com.sold.spring.talks.util.PagingUtil"%>
<%@page import="com.sold.spring.talks.util.PagingData"%>
<%@page import="com.sold.spring.talks.util.PageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>축구 게시판</title>
<style>
body {
	display: flex;
	flex-direction: column;
	align-items: center;
	text-align: center;
}

.pagination {
	display: flex;
	justify-content: center;
	list-style: none;
	padding: 0;
}

.pagination li {
	margin: 0 5px;
}

.pagination a {
	text-decoration: none;
	padding: 5px 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	cursor: pointer;
}

.pagination a:hover {
	background-color: #0056b3;
}

.search-form {
	margin-bottom: 20px;
}

.search-form input[type="text"] {
	width: 200px;
	padding: 5px;
}

.search-form input[type="submit"] {
	padding: 5px 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	cursor: pointer;
}

.search-form input[type="submit"]:hover {
	background-color: #0056b3;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid #ccc;
}

th, td {
	padding: 10px;
	text-align: left;
}
</style>
</head>
<body>
	<h1>축구 게시판</h1>

	<!-- 글 목록 -->
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pagingData.boardDtoList}" var="boardDto">
				<tr>
					<td>${boardDto.posts_num}</td>
					<td><a href="/board/read/${boardDto.posts_num}">${boardDto.posts_title}</a></td>
					<td>${boardDto.posts_name}</td>
					<td><fmt:formatDate pattern="MM-dd hh:mm"
							value="${boardDto.posts_date}" /></td>
					<td>${boardDto.posts_hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 페이징 처리 -->
	<form>
		<ul class="pagination">
			<c:if test="${pagingData.pagingUtil.prevPage}">
				<li><c:choose>
						<c:when test="${empty pagingData.pageUtil.posts_minor_category}">
							<a
								href="?pageNum=${pagingData.pagingUtil.firstPage}${pagingData.pagingUtil.searchSet}">첫 페이지</a>
						</c:when>
						<c:otherwise>
							<a
								href="?pageNum=${pagingData.pagingUtil.firstPage}${pagingData.pagingUtil.searchSet}&minorCategory=${pagingData.pageUtil.posts_minor_category}">첫 페이지</a>
						</c:otherwise>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${empty pagingData.pageUtil.posts_minor_category}">
							<a
								href="?pageNum=${pagingData.pagingUtil.firstPage - 1}${pagingData.pagingUtil.searchSet}">이전</a>
						</c:when>
						<c:otherwise>
							<a
								href="?pageNum=${pagingData.pagingUtil.firstPage - 1}${pagingData.pagingUtil.searchSet}&minorCategory=${pagingData.pageUtil.posts_minor_category}">이전</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>

			<c:forEach begin="${pagingData.pagingUtil.firstPage}"
				end="${pagingData.pagingUtil.lastPage}" var="pageNumber">
				<c:choose>
					<c:when test="${pageNumber eq pagingData.pageUtil.pageNum}">
						<li class="active">${pageNumber}</li>
					</c:when>
					<c:otherwise>
						<li><c:choose>
								<c:when test="${empty pagingData.pageUtil.posts_minor_category}">
									<a
										href="?pageNum=${pageNumber}${pagingData.pagingUtil.searchSet}">${pageNumber}</a>
								</c:when>
								<c:otherwise>
									<a
										href="?pageNum=${pageNumber}${pagingData.pagingUtil.searchSet}&minorCategory=${pagingData.pageUtil.posts_minor_category}">${pageNumber}</a>
								</c:otherwise>
							</c:choose></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${pagingData.pagingUtil.nextPage}">
				<li><c:choose>
						<c:when test="${empty pagingData.pageUtil.posts_minor_category}">
							<a
								href="?pageNum=${pagingData.pagingUtil.lastPage + 1}${pagingData.pagingUtil.searchSet}">다음</a>
						</c:when>
						<c:otherwise>
							<a
								href="?pageNum=${pagingData.pagingUtil.lastPage + 1}${pagingData.pagingUtil.searchSet}&minorCategory=${pagingData.pageUtil.posts_minor_category}">다음</a>
						</c:otherwise>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${empty pagingData.pageUtil.posts_minor_category}">
							<a
								href="?pageNum=${pagingData.pagingUtil.lastPage}${pagingData.pagingUtil.searchSet}">마지막 페이지</a>
						</c:when>
						<c:otherwise>
							<a
								href="?pageNum=${pagingData.pagingUtil.lastPage}${pagingData.pagingUtil.searchSet}&minorCategory=${pagingData.pageUtil.posts_minor_category}">마지막 페이지</a>
						</c:otherwise>
					</c:choose></li>
			</c:if>
		</ul>
	</form>

	<!-- 검색 -->
	<form>
		<div>
			<select id="searchType" name="searchType">
				<option value="title"
					<c:if test="${pagingData.pageUtil.searchType eq 'title'}">selected</c:if>>제목</option>
				<option value="content"
					<c:if test="${pagingData.pageUtil.searchType eq 'content'}">selected</c:if>>내용</option>
				<option value="writer"
					<c:if test="${pagingData.pageUtil.searchType eq 'writer'}">selected</c:if>>작성자</option>
				<option value="title_content"
					<c:if test="${pagingData.pageUtil.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
			</select> 
			<input type="text" name="searchWord" value="${pagingData.pageUtil.searchWord}"> 
       		<c:if test="${not empty pagingData.pageUtil.posts_minor_category}">
            	<input type="hidden" name="minorCategory" value="${pagingData.pageUtil.posts_minor_category}">
        	</c:if>
			<input type="submit" value="검색">
		</div>
	</form>
</body>
</html>