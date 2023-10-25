<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/member/signup" method="post" onsubmit="successMessage()">
		<input type="text" name="member_id" placeholder="아이디" required><br>
		<input type="password" name="member_pw" placeholder="비밀번호" required><br>
		<input type="text" name="member_nickname" placeholder="닉네임" required><br>
		<input type="text" name="member_name" placeholder="실명" required><br>
		<input type="submit" value="가입하기">
	</form>

	<script>
		function successMessage() {
			alert("가입이 성공적으로 완료되었습니다!");
		}
	</script>
</body>
</html>