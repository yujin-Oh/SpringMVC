<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="<%=request.getContextPath()%>/test.do">TEST ��� �̵�!</a>
	<!-- �� ��ũ�� Ŭ�������� views ������ �ִ� sample.jsp�� ������ �ǵ��� �����ϼ���. -->
	<a href="<%=request.getContextPath()%>/board/list.do">board/list.do</a>
	<a href="<%=request.getContextPath()%>/board/view.do">board/view.do</a>
	<a href="<%=request.getContextPath()%>/board/write.do">board/write.do</a>
	<a href="<%=request.getContextPath()%>/board/user.do">board/user.do</a>

	<hr>
	<a href="<%=request.getContextPath()%>/oper/calc.do">���� �ٷΰ���</a>
	<hr>
	<c:if test="${login == null}">
		<a href="<%=request.getContextPath()%>/user/login.do">�α��� �Ϸ�����</a>
	</c:if>
	<c:if test="${login != null}">
		<a href="<%=request.getContextPath()%>/user/logout.do">�α׾ƿ� �Ϸ�����</a>
	</c:if>
	<a href="<%=request.getContextPath()%>/user/join.do">ȸ������ �Ϸ�����</a>
	<hr>
	${login.id} ��, ȯ���մϴ�!
	<hr>
	<a href="<%=request.getContextPath()%>/ajax/main.do">ajax ����Ϸ�
		����!!</a>
	<hr>
	<a href="<%=request.getContextPath()%>/fileupload.do">����
		���ε��Ϸ�����!!</a>
</body>
</html>
