<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>board/write 페이지</h2>
	<!-- http://localhost:8090/controller/board/write.do -->
	<!-- http://localhost:8090/controller/board/writeAction.do -->
	<form action="write.do" method="post">
		제목: <input type="text" name="title"><br>
		작성자: <input type="text" value="${login.id}" readonly><br>
		내용: <textarea name="content"></textarea><br>
		<button>저장</button> <!--form 안에 있는 button은 type이 무조건 submit-->
	</form>
</body>
</html>