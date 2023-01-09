<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 수정</h2>
	<form action="userModify.do" method="post">
	<input type="hidden" name="uidx" value="${vo.uidx}">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="${vo.id}"></td >
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${vo.name}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr" value="${vo.addr}"></td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td><input type="text" name="phone" value="${vo.phone}"></td>
			</tr>
		</table>
		<button>저장</button>
	</form>
</body>
</html>