<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h2>board/view ������</h2>
		<table border="1">
			<tr>
				<th>������</th>
				<td>${vo.title}</td>
			</tr>
			<tr>
				<th>�����</th>
				<td>${vo.wdate}</td>
			</tr>
			<tr>
				<th>��ȸ��</th>
				<td>${vo.hit}</td>
			</tr>
			<tr>
				<th>����</th>
				<td>${vo.content}</td>
			</tr>
		</table>

		<button onclick="location.href='modify.do?bidx=${vo.bidx}'">����</button>
		<button onclick="document.delfrm.submit()">����</button>
		<form name="delfrm" action="delete.do" method="POST">
		<input type="hidden" name="bidx" value="${vo.bidx}">
		<!-- ������ư Ŭ���� �ش� ������ ���� �� list �������� �����̷�Ʈ�ϼ���. -->
		<!-- onclick="document.���̸�.submit()" -->
	</form>
</body>
</html>