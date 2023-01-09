<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="edu.study.vo.OperVO"%>
<%
OperVO vo = (OperVO)request.getAttribute("list");
%>
<%
int result = (Integer)request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result.jsp</h2>
	연산의 결과는? <br>
	숫자1: ${vo.num1} <br>
	숫자2: ${vo.num2} <br>
	연산자: ${vo.oper} <br>
	결과: <%=result%>
</body>
</html>

<!-- 1. home.jsp에서 계산하러가기 링크 클릭 시 calculator.jsp 페이지 포워드 
2. calculator.jsp에서 계산하기 버튼 클릭 시 계산의 결과를 result.jsp에 출력하기.-->