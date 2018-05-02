<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
    
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
font-family: "Lato", sans-serif;
min-width : 1080px; /*min-width를 주면 화면이 깨지지 않는다.  */
}
.mySlides {display: none}
#search{float: right;}
#signup{float: right;}
#login{float : right;}


/* 로그인 모달창 CSS */
	
		a:link, a:visited{
		text-decoration: none;
		color: inherit;
	}
	#wrap{
		margin : 50px auto 0;
		border: 3px solid gray;
		width: 464px;
		height: 567px;
	}
	#kakao_header{
		height: 39px;
		padding-top: 16px;
		border-top: 4px solid #77aaad;
		border-bottom: 1px solid #d4d4d4;
		overflow: hidden;
	}
	#kakao_header a > span{
		font-family: 'KoPub Batang', serif;
		font-size: 30px;		
	}
	h1 {
		float: left;
		margin-left: 25px;
	}
	#kakao_logo{
		float: left;
		height : 22px;
		margin-top: 2px;
		font-size: 18px;
		font-weight: normal;
		line-height: 20px;
	}
	#kakao_logo > img {
		height: 20px;
		float: left;
		margin-right: 10px;
	}
	/* #kakao_logo span{
		
	}  */
	#kakao_help{
		float: right;
		margin-top: 2px;
		margin-right: 11px;
	}
	.list_help{
		float: left;
	}
	.list_help > li {
		float: left;
		margin-right: 14px;
	}
	.list_help > li > a{
		color: #777;
		letter-spacing: -1px; /* 자간 글자 간격 */
		font-size: 13px;
	}
	.list_help > li > a:hover{
		text-decoration: underline;
	}
	/*  */
	#kakao_content{
		margin: 10px auto;
		height: 600px;
		text-align: center;
	}
	#login_content {
		width: 270px;
		height: 394px;
		border: 1px solid #ddd;
		text-align: left;
		display: inline-block;
		position: relative;
		top: 100px;
	}
	#login_area{
		width: 270px;
		height: 372px;
		position: relative;
	}
	#subtitle{
		position: relative;
		height: 55px;
		margin: 22px auto 12px 0px;
		font-size: 40px;
		font-weight: bold;
		font-family: 'Nanum Pen Script', serif;	
		color: #252c41;
		text-align: center;	
	}
	#subtitle > img {
		width: 60px;
		height: 18px;
	}
	.idpw{
		color : #333;
		letter-spacing: -1px;
		background-color: white;
		width: 240px;
		height: 22px;
		border: 1px solid #e5e5e5;
		border-radius: 5px;
		font-weight: normal;
		font-size: 13px;
		line-height: 22px;
		padding: 8px 12px;
		margin-bottom: 15px;
		outline: none; /* input을 클릭하면 파란색 테두리가 사라진다.  */
		margin-left: 2px;
		
	}
	#login_form{
		position: relative;
		padding: 10px;
	}
	#login_form > img{
		display: inline-block;
		width: 24px;
		height: 24px;
		position: absolute;
		top : 8px;
		right: 8px;
	}
	#remember{
		margin: -1px 0 16px;
		padding-top: 20px;
	}
	#remember > input {
		 color: #333;
		 margin: 3px 3px 3px 4px;
		 vertical-align: middle;
	}
	#remember > label {
		font-size: 13px;
		letter-spacing: -1px;
	}
	#remember > a{
		font-size: 13px;
		letter-spacing: -1px;
		color: #777!important;
	}
	#remember > span{
		display: inline-block;
		width: 1px;
		height: 11px;
		background-color: #ccc;
		margin: 4px 1px 0 3px;
		
	}
	#btn_login{
		display: inline-block;
		background-color: #252c41;
		border: 1px solid #252c41;
		width : 268px;
		padding-top: 5px;
		line-height: 38px;
		text-align: center;
		border-radius: 5px;
		font-family: 'KoPub Batang', serif;
		font-size: 30px;
		font-weight: bold;
		color: white;
		
		}
	#login_help{
		width: 270px;
		position: absolute;
		padding-top: 10px;
		bottom: 20px;
		font-size: 12px;
		letter-spacing: -1px;
		border-top: 1px solid #cfcfcf;
	}
	#login_help a{
		letter-spacing: -1px;
		color:#333;
	}
	#login_help a:hover{
		text-decoration: underline;
	}
	.right{
		display: inline-block;
		position: absolute;
		right: 0;
	}
	.right > a{
		color: #777!important; /* !important는 최고 권한으로 사용해준다. */
	}
	.right_bar{
		display: inline-block;
		width: 1px;
		height: 11px;
		background-color: #ccc;
		margin: 4px 1px 0 3px;
	}
	#kakao_footer{
		padding: 19px 30px 22px;
		border-top: 1px solid #d4d4d4;
		font-size: 12px;
		text-align: center;
		letter-spacing: -1px;
	}
	#kakao_footer .link_info{
		display: inline-block;
		line-height: 22px;
		color: #898989;
	}
	#kakao_footer .link_info:hover{
		text-decoration: underline;
	}
	
	#footer_link .txt_bar{
		display: inline-block;
		width: 1px;
		height: 8px;
		margin: 4px 1px 0 3px;
		font-size: 11px;
		background-color: #ccc;
	}
	.util_cont{
		position: relative;
		display: inline-block;
		font-size: 12px;
		text-align: center;
		letter-spacing: -1px;
	}
	.btn_info{
		display: inline-block;
		padding: 0;
		margin-top: -2px;
		font-size: 12px;
		line-height: 22px;
		color: #898989;
		vertical-align: top;
		border: 0 none;
		background-color: transparent;
		cursor: pointer;
	}
	#btn_semo{
		display: inline-block;
		font-size: 1px;
		position: absolute;
		top : 0px;
		right: -10px;
	}
	#footer_info{
		margin-top: 5px;
	}
	.txt_copyright{
		font-size: 12px;
		color: #919191;
	}
	.link_kakao:hover{
		text-decoration: underline;
	}
	#span_id{
		display: none;
		color: red;
	}
</style>


<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$(".btn").on("click", function(){
				 
	     			var id2 =$("#loginid").val();
	     			var pw = $("#loginpw").val();
						
					if(id2 == ""){
						 $("#loginid").focus();
	                 	 $("#span_id").text("아이디를 입력해주세요").css("display", "block");
	                 	 return false;
	                 	
					}else if(pw == ""){
						 $("#loginpw").focus();
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
									location.reload();
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
		
	
	$(".logout").on("click", function(){
		
		$.ajax({
			url:"logout.bizpoll",
			type: "POST",
			dataType :"JSON",
			success : function(data){				
				if(data.flag == "0" ){
					
					alert("로그아웃 실패");
					
				}else{
					
					alert("로그아웃 성공");
					//location.href = "index.bizpoll";
					//$("#frm_memeber").submit();
					location.reload();
				} 
			},
			
			error : function(){
				alert("System Error!!!");
				
				}
			});
		});
	});

</script>


<body>

<!-- header -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">홈페이지</a>
    <a href="https://www.billboard.com/charts/hot-100" target="_blank" class="w3-bar-item w3-button w3-padding-large w3-hide-small">빌보드차트</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">1:1대화</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">자유게시판</a>
     <c:choose> 
	                        <c:when test="${empty sessionScope.loginUser}">
	                        		<a href="constract.bizpoll" id="signup" class="w3-bar-item w3-button w3-padding-large w3-hide-small">회원가입</a>
   									<a href="#" id="login" class="w3-bar-item w3-button w3-padding-large w3-hide-small"  onclick="document.getElementById('id01').style.display='block'" style="cursor : pointer">로그인</a>  
	                        </c:when>
		                    <c:otherwise>
		                    	<li>${sessionScope.loginUser.mname }(${sessionScope.loginUser.mid })</li>
		                    	<li><a href="#" class="logout">로그아웃</a></li>
		                    	<li><a href="passwordcheck.bizpoll" id="personal">내 정보</a></li>
		                    </c:otherwise>
                        </c:choose>
                         <div class="w3-dropdown-hover w3-hide-small">
    </div>
    <a href="#"  id="search" class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i class="fa fa-search"></i></a>
	
  </div>
</div>

<div class="w3-container">
                 <!--  <li><a href="login.bizpoll"> 로그인 class="w3-button w3-black" -->

		<!-- <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black">Open Modal</button> -->

			<div id="id01" class="w3-modal">
 				<div class="w3-modal-content">
  					<div class="w3-container">
     					<span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
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
     				
     				</div>
 				</div>
			</div>
	</div>


 <!-- Automatic Slideshow Images -->
  <div class="mySlides w3-display-container w3-center">
    <img src="image/1.jpg" style="width:100%">
    <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h3>DJ SNAKE</h3>
      <p><b>추천곡 : turn down for what! , middle</b></p>   
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="image/2.png" style="width:100%">
    <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h3>dimitri vegas & like mike</h3>
      <p><b>추천곡 : complicated</b></p>    
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="image/3.jpg" style="width:100%">
    <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h3>imagin dragons</h3>
      <p><b>추천곡 : warriors , Turnder.</b></p>    
    </div>
  </div>


<script>
// Automatic Slideshow - change image every 4 seconds
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000);    
}
</script>


</body>
</html>
