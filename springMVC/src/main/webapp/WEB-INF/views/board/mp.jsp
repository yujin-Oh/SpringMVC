<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
</head>
<body>
	<h2>마이페이지</h2>
	<table border="1">
	<tr>
		<th>아이디</th>
		<td>${vo.id}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${vo.name}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${vo.addr}</td>
	</tr>
	<tr>
		<th>핸드폰</th>
		<td>${vo.phone}</td>
	</tr>
	</table>
	<button onclick="location.href='userModify.do?uidx=${vo.uidx}'">회원정보 수정</button>
</body>
</html>