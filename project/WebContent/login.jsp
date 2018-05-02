<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/index.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">

 	#span_id{
 	
 		color: red;
 		display: none;
 	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$(".btn").on("click", function(){
				 
	     			var id2 =$(".loginid").val();
	     			var pw = $(".loginpw").val();

					if(id2 == ""){
						 $("#loginid").focus();
	                 	 $("#span_id").text("아이디를 입력해주세요").css("display", "block");
	                 	 return false;
	                 	
					}else if(pw == ""){
						 $("#loginid").focus();
	                 	 $("#span_id").text("비밀번호를 입력해주세요").css("display", "block");
	                 	 return false;
	                 	
					}else {
						
						$("#span_id").css("display", "none");
						
						$.ajax({
							url:"loginck.bizpoll",
							type: "POST",
							dataType :"json",
							data : "id2=" +id2 +"&"+ "pw=" +  pw,
							success : function(data){
								
								if(data.flag == 0 ){
									
									alert("로그인 실패");
									$("#loginid").select();
									$("#span_id").text(" 아이디 또는 패스워드가 틀렸습니다. ").css("display", "block");
									
								}else{
									
									alert("로그인성공");
									location.href = "index.bizpoll";
									//$("#frm_memeber").submit();
								} 
							},
							
							error : function(){
								alert("System Error!!!");
								
							}
						});
					}
			});
					
		
		
		$("#loginid").blur(function(){
         	var uid = $('#loginid');
         	var id = $.trim(uid.val());
 			if(id != ""){
 				$("#span_id").css("display", "none");
 			}
         });
		
		$("#loginpw").blur(function(){
         	var upw = $('#loginpw');
         	var pw = $.trim(upw.val());
 			if(pw != ""){
 				$("#span_id").css("display", "none");
 			}
 				
         });
		
	
	});
		

</script>


</head>
<body>

		
	<div id="kakao_content">
		
	<form name="frm_memeber" action="sessionLogin.bizpoll" id="frm_memeber" method="post" >
			
		<div id="login_content">
		
			<div id="login_area">
				<div id="subtitle">
				Login
					<!-- <img src="image/kakao_logo.png"> -->
				</div> 
				<div id="container">
					
						<input name="loginid" id ="loginid"  class="idpw loginid" type="text" >
						<input name="loginpw" id ="loginpw" class="idpw loginpw" type="password" >
					
					<a href="#" id ="btn_login" class="btn" >로그인</a>
					<span id="span_id">ID 또는 비밀번호가 틀렸습니다.</span>
					<div id="remember">
						<input type="checkbox" name="remeber" id="remeber2">
						<label for="remeber2">아이디 저장</label>
						<span></span>&nbsp
						<a href="#">비회원 주문</a>&nbsp
						<span></span>&nbsp
						<a href="#">배송조회</a>
					</div>
					
				</div>
				<div id="login_help">
					<a href="Constract.bizpoll">회원가입</a>
					<div class="right">
					 <a href="#">아이디 찾기</a>
					 <span class="right_bar"></span>
					 <a href="#">비밀번호 찾기</a>
					</div>
				</div>
			
			</div>
		</div>
				</form>
	</div>

</body>
</html>


<script type="text/javascript">
	window.onload = function(){
		var code = ${flag};
		if(code == 0){
			document.getElementById("span_id").style.display="block";
		}
	}
</script>


