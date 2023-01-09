<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/jquery-3.6.1.min.js"></script>
<script>
	var checkIdFlag = false;
	var checkIdVal = ""; //공백 할당
	function checkId(){
		
		
		var idval = $("#id").val();
		
		if(idval == ""){
			alert("공백은 사용할 수 없습니다.");
			$("#id").focus();
		} else {
		
		$.ajax({
			url : "<%=request.getContextPath()%>/ajax/checkId.do",
			type: "post",
			data: "id="+idval,
			success:function(data){
				if(data == 1){
					alert("중복된 id입니다.");
					checkIdFlag = false;
					checkIdVal = "";
				}else{
					alert("사용할 수 있는 id입니다.");
					checkIdFlag = true;
					checkIdVal = idval;
				}
			}
		});
	}
}
	
	$(function(){
		$("form").submit(function(){
			
			if($("#id").val() == ""){
				alert("아이디를 입력하세요.");
				$("#id").focus();
				return false;
			}else if(!checkIdFlag){
				alert("아이디 중복확인을 하세요.");
				return false;
			}else if(($("#id").val()<"0"||$("#id").val()>"9")&&($("#id").val()<"A"||$("#id").val()>"Z")&&($("#id").val()<"a"||$("#id").val()>"z")){
				alert("한글 및 특수문자는 사용할 수 없습니다.");
				return false;
			}else if($("#name").val() == ""){
				alert("이름을 입력하세요.");
				$("#name").focus();
				return false; 
			}else if($("#password").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#password").focus();
				return false; 
			}else if($("#addr").val() == ""){
				alert("주소를 입력하세요.");
				$("#addr").focus();
				return false; 
			}else if($("#phone").val() == ""){
				alert("연락처를 입력하세요.");
				$("#phone").focus();
				return false; 
			}
			else{
				return true;
			}
		});
	})
	
	
	function blurId(obj){
		var val = obj.value;
		console.log(val);
		console.log(checkIdFlag);
		console.log(checkIdVal);
		
		if(checkIdFlag && val != checkIdVal){
			checkIdFlag = false;
		}
	}
</script>
</head>
<body>
	<h2>회원가입 페이지!</h2>
	<form action="join.do" method="post">
		아이디  : <input type="text" name="id" id="id" onblur="blurId(this)"> <button type="button" onclick="checkId()">중복체크</button>
		<br>
		이름 : <input type="text" name="name" id="name">
		<br>
		비밀번호 : <input type="password" name="password" id="password">
		<br>
		주소 : <input type="text" name="addr" id="addr">
		<br>
		연락처 : <input type="text" name="phone" id="phone">
		<br>
		<button>회원가입</button>
		
	</form>
</body>
</html>