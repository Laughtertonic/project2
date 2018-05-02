<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="header.jsp" %>
 
 	<%
 	 response
 	 .setHeader("CaChe-Control", "no-store");
 	 response.setHeader("pragma", "no-cache");
 	 %>
 
	<%@ page import="java.util.Date" %>
	<c:set var="date" value="<%=new Date()%>"/>

<!-- <script src="../js/jquery-3.3.1.js"></script> -->
<script type="text/javascript">
$(document).ready(function() {
	$("#search2").on("click" ,  function(){
		$("#frm_search").submit();
	});
	
	
	// 게시글 등록 버튼 클릭시 이벤트 처리
	$("#yes2").on("click", function() {
		location.href = "boardinsertview.bizpoll";
	});
		$("#btn_submit2").on("click", function() {
		      
		      var dd =  "<%=session.getAttribute("loginUser")%>"
		      
		      
		      if(dd != "null"){
		         
		         $("#insert").submit();
		         
		         
		      }else {
		         alert("로그인 해주세요!!!!!!")
		         $("#id01").css("display", "block");
		         
		         } 
	
	});	
});
</script>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name ="viewport" content="width=device-width, initial-scale=1">
	<title>게시판</title>
	<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
	.table{
	margin: 50px auto 10px auto;
	width: 70%;
	}
	#btn_submit2{
	margin-left: 307.200px;
	
	}
	.board_pagination{
	text-align: center;
	}

	.pagination > .active > a {
		background-color: #B7F0B1;
		border-color: #B7F0B1;
	}
	
	.pagination > .active > a:hover {
		background-color: #A5DE9F;
		border-color: #A5DE9F;
	}
	#search1{
	text-align: center;
	
	}
	#search{
	padding:3px;
	}
	#search2{
	padding: 3px;
	margin: 5px 5px 5px 5px;
	}
	#search_resuly{
		margin-bottom: 10px;
		font-size:20px;
	}
	.search_span{
		color:#DDD;
		font-weight: bold;
	}
	.new_time{
		background-color: #FF8224;
		font-size: 10px;
		color: white;
		border-radius: 5px;
		padding: 1px 3px;
	}

</style>
</head>

<!-- Main Content  -->
<body>


<table class="table table-hover">
<thead>
<div>
		<span class="search_span">${searchKeyword}</span>로 검색한 결과는 총
		<span class="search_span">${searchCount}</span>건입니다.
		</div>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th style="width:40px">조회수</th>
</tr>
</thead>
<tbody>
		<c:forEach items="${boardlist}" var="bDto">
			<tr>
				<td>${bDto.bno}</td>
				<td><a href="boardbody.bizpoll?bno=${bDto.bno}">
				<!-- 답글 들여쓰기  -->
				<c:forEach var = "i" begin = "1" end = "${bDto.re_level}">
				&nbsp;&nbsp;
				</c:forEach>
				${bDto.title} </a></td>
			
			<c:if test="${bDto.replycnt ne 0}">
				[${bDto.replycnt}"]
			</c:if>
				
				
				<td>${bDto.writer}</td>
				<td class="text_center">
				
				
				<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="today2"/>
				<fmt:formatDate value="${bDto.regdate}" pattern="yyyy-MM-dd" var="regdate2"/>
				
				<c:choose>
					<c:when test="${today2 == regdate2}">
					<fmt:formatDate pattern="yyyy-MM-dd-HH:mm" value="${bDto.regdate}"/>
					</c:when>
					<c:otherwise>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${bDto.regdate}"/>
					</c:otherwise>
				</c:choose>
						<c:if test = "${bDto.filesize > 0}">
							<i class = "fa fa-floppy -0"></i>
						</c:if>
				</td>
			
				<td class="td_hit">${bDto.viewont}</td>
				<td class="td_vote">${bDto.sweet}</td>
			</tr>
		</c:forEach>
</tbody>
	</table>
	
	<!-- 	<div id="yes">
		<button id="yes2" class="w3-button w3-black">게시글 작성</button>
		</div> -->
		<form id="insert" name="insert" action="boardInsertView.bizpoll"  method="post">
              <input type="button" value="게시글 작성" class="w3-button w3-black" id="btn_submit2">
              <input type="hidden" value="${sessionScope.loginUser.mid }" name="hidden_id">
        </form>
		
	<div class="text-center">
						<ul class = "pagination">
							<c:if test="${pageMaker.prev}">
							<li>
								<a href="boardlist.bizpoll?page=${pageMaker.startPage - 1}">&laquo;</a>
							</li>
							</c:if>
							
							<!--c아웃은 버튼을 눌렀을때 호버 상태가 되어있게 해주는것  -->
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<li <c:out value="${pageMaker.criDto.page == idx? 'class=active':''}"/>>
									<a href="boardlist.bizpoll?page=${idx}">${idx}</a>
								</li>							
							</c:forEach>
							
							
							
							<c:if test="${pageMaker.next}">
							<li>
								<a href="boardlist.bizpoll?page=${pageMaker.endPage + 1}">&raquo;</a>
							</li>
							</c:if>
						</ul>
					
					
					
				</div>
				<div id ="search1">
				<form action="search.bizpoll" method="GET" name="frm_Search" id="frm_search">
				<select id="srm" name="srm">
		               	    <option value="1">전체</option>
		                	<option value="2">제목</option>
		                	<option value="3">내용</option>
		                	<option value="4">제목+내용</option>
		                	<option value="5">작성자</option>
		                </select>
				
				
				
				
				<input type="text"  name="search" placeholder="검색할 값을 입력하세요" id="search">
				<a href="#" id ="search2" class="w3-button w3-black">검색</a>
				</form>
				</div>
				<!-- <div class="box-footer">Footer</div> -->
	
<!-- 컨트롤러의 success를 처리하기 위한 스크립

밑에다가 쓴 이유가 있음 -->
<script type="text/javascript">
	var result="${msg}";
	
	if(result == "SUCCESS"){
		alert("처리가 완료 되었습니다.");
	} 
</script>
<%-- <%@ include file="../include/footer.jsp" %> --%>

<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.js"></script>
</body>