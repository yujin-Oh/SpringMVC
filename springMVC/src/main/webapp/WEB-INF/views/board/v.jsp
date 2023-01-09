<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h2>board/view 페이지</h2>
		<table border="1">
			<tr>
				<th>글제목</th>
				<td>${vo.title}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${vo.wdate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.hit}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${vo.content}</td>
			</tr>
		</table>

		<button onclick="location.href='modify.do?bidx=${vo.bidx}'">수정</button>
		<button onclick="document.delfrm.submit()">삭제</button>
		<form name="delfrm" action="delete.do" method="POST">
		<input type="hidden" name="bidx" value="${vo.bidx}">
		<!-- 삭제버튼 클릭시 해당 데이터 삭제 후 list 페이지로 리다이렉트하세요. -->
		<!-- onclick="document.폼이름.submit()" -->
	</form>
</body>
</html>