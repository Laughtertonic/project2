<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   <!-- prefix는 표기법  -->
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 ID 중복체크</title>

<style type="text/css">

	body, div, ul{
		margin: 0;
		padding: 0px;
		font-size : 1em;
	}
	#popup{
		width : 200px;
		margin: 50px auto;
	}
	
</style>
<script type="text/javascript">
	function closeOK(){
		opener.document.frm_memeber.hidden.value="Y";
		opener.document.frm_memeber.reg_mb_password.focus();
		self.close();
	}
	function closeNG(){
		opener.document.frm_memeber.hidden.value="N";
		opener.document.frm_memeber.reg_mb_id.select();
		self.close();
	}

</script>
</head>
<body>
	<div id="popup">
		<c:choose>
			<c:when test="${flag=='0' }">
			이미 가입된 ID입니다.<br>
			다른 ID를 입력해 주세요. <br>
			<button onclick="closeNG()">확인</button>
			</c:when>
			
			<c:when test="${flag=='1' }">
			사용 가능한 ID입니다.<br>
			<button onclick="closeOK()">확인</button>
			</c:when>
		</c:choose>
	</div>
</body>
</html>