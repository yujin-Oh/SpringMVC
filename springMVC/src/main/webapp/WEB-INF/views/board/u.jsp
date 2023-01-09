<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="edu.study.vo.UserVO"%>
<%
	List<UserVO> list= (List<UserVO>) request.getAttribute("datalist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>유저 목록입니다~</h2>
	<table border="1">
		<c:forEach items="${datalist}" var="vo">
			<tr>
				<td>${vo.uidx}</td>
				<td><a href="mypage.do?uidx=${vo.uidx}">${vo.id}</a></td>
				<td>${vo.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>