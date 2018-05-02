<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>    
<head>
<meta charset="UTF-8">
<title>동의 페이지</title>

<style type="text/css">
      body, h1 ,ul, p, h3{
            margin: 0;
            padding: 0;
      }
      body{
            background-color: #f5f6f7;
      }
      h1#naver_logo{
            font-size: 2em; /* 기본 폰트 글자 크기의 2배 */
      }
      div#header, div#container, div#footer{
            width: 786px;
            margin: 0 auto;
            box-sizing: border-box;
      }
      div#header{
            height: 169px;
            padding-top: 62px;
            position: relative;
      }
      div#container{
            position: relative;
      }
      div#footer{
            height: 81px;
            text-align: center;
            padding: 30px 0 15px 0;
      }
      .n_logo{
            display: block;
			width: 240px;
			height: 44px;
			/* background:url('image/farm/vegan2.png')0 -106px; */
			margin: 0 auto;
			box-sizing: border-box;
      }
      img{
      width: 250px;
      height: 100px;
      }
      div.lang{
            position: absolute;
            top : 14px;
            right: 0px;
      }
      .lang > select{
            background: url('image/sel_arr.gif') 100% 50% no-repeat;
            -webkit-appearance : none;
            width: 98px;
            height: 30px;
            background-color: white;
            
      }
      select#langselect{
            font-size: 12px;
            font-weight: 400;
            height: 30px;
            padding: 6px 8px 5px 7px;
            min-width: 98px;
            color: #333;
            border: 1px solid #ccc;
            
      }
      option{
            padding: 0px 2px 1px;
            display: block;
      }
      
      /* contaie */
      
      form#join_content{
            width: 460px!important;
            margin: 0 auto!important;
      }
      .terms{
            margin-bottom: 20px;
            background-color: white;
            border: 1px solid #dadada;
      }
      .terms_span > input {
            position: absolute;
            right: 1px;
            top : 50%;
            width: 22px;
            height: 22px;
            margin-top: -11px;
            visibility: hidden;
      }
      .terms_span{
            position: relative;
            display: block;
            height: 58px;
      }
      .terms_p{
            display: block;
            padding: 15px;
            margin: 0;
            position: relative;
      }
      .terms_span > label {
            background: url('image/check_off.gif') 100% 50% no-repeat;
            display: block;
            line-height: 20px;
            height: 58px;
            top: -1px;
            font-size: 14px;
            font-weight: 700;
      }
      .terms_span > input:checked + label{
            background-image: url('image/check_on.gif');
      }
      
      /* terms_li1 */
      #terms_ul{
            padding-bottom:7px;
            list-style: none;
      }
      #terms_ul_li1{
            border-top: 1px solid #f0f0f0;
      }
      ul#terms_ul > li{
            display: block;
            padding: 13px 15px 7px;
      }
      .ul_li_span{
            position: relative;
            display: block;
            height: 24px;
      }
      .label1{
            height: 24px;
            font-size: 14px;
            font-weight: 700;
            line-height: 24px;
            position: absolute;
            color: #333;
            top: 0;
            left: 0;
            width: 100%;
      }
      .span_only{
            color: #0d9900;
            font-size: 12px;
            font-weight: 400;
      }
      .terms_no{
            color : #8e8e8e;
      }
      .ul_li_span > input{
            visibility: hidden;
            position: absolute;
            right: 1px;
            width: 22px;
            height: 22px;
            margin-top: -11px;
            top: 50%;
      }
      .ul_li_span > label{
            background: url('image/check_off.gif') 100% 50% no-repeat;
            display: black;
      }
      .ul_li_span > input:checked + label{
            background-image: url('image/check_on.gif');
      }
      
      .terms_box{
            position: relative;
            box-sizing: border-box;
            height: 88px;
            margin-top: 11px;
            padding: 8px 10px;
            border: 1px solid #f0f0f0;
            background-color: #f7f7f7;
            overflow: auto;
      }
      .article{
            margin: 0px;
      }
      h3.article_title{
            font-size: 12px;
            font-weight: 700;
            line-height: 16px;
            color: #666;
      }
      .article > p {
            display: block;
            font-size: 12px;
            line-height: 16px;
            color: #666;
      }
      .span_select{
            color : #969696;
            font-size: 12px;
            font-weight: 400;
      }
      
      .btn_double_area{
            margin : 30px -5px 0px;
            overflow : hidden;
      }
      .btn_double_area > span{
            display: block;
            float: left;
            width: 50%;
      }
      .btn_type{
            width: auto;
            margin: 0px 5px;
            font-size: 20px;
            font-weight: 600;
            line-height: 61px;
            display: block;
            box-sizing: border-box;
            height: 61px;
            padding-top: 1px;
            text-align: center;
      }
      .btn_default{
            color: #333;
            border: 1px solid #e7e7e7;
            background-color: #fff;
      }
      
      .btn_agree{
            color : #fff;
            border: 1px solid white;
            background-color: black;
      }
      a{
            text-decoration: none;
            color: inherit;
      }
      .group_join{
            margin: 20px 0px 65px;
            text-align: center;
            color: #666;
            font-size: 12px;
      }
      .group_join > a{
            text-decoration: underline;
            color: #333;
      }
      /* DIV footer */
      #footer{
            position: relative;
            width: 786px;
            min-width: 460px;
            margin: 0 auto;
            clear: both;
            padding: 30px 0 15px 0;
            text-align: center;
            max-width: 786px;
      }
      #footer *{
            font-size: 11px;
            font-style: normal;
            line-height: normal;
            padding: 0;
            list-style: none;
            color: #333;
      }
      #footer ul{
            margin: 0 0 9px 0;
      }
      #footer a {
            text-decoration: none;
            color : #333;
      }
      #footer > ul > li{
            border-left: 1px solid #dadada;
            display: inline;
            padding: 0 5px 0 7px;
            font-size: 11px;
            position: relative;
            white-space: nowrap;
      }
      #footer ul li:first-child {
            border-left: 0;
      }
      #footer > ul > li > a:hover, #footer strong:hover{
            color :#438a01;
      }
      #footer a:hover{
            text-decoration: underline;
            color :#438a01;
      }
      strong{
            font-weight: bold;
      }
      #footer address{
            font :9px/14px Verdana;
      }
      #footer address em{
            font : 9px verdana;
            padding-left: 4px;
      
      }
      #footer address .logo2{
            top: 2px;
            margin-left: 1px;
            background: url('image/ci_naver.gif') 0 0 no-repeat;
            position: relative;
            display: inline-block;
            width: 63px;
            height: 11px;
            
      }
      .u_cra{
      font : 700 9px Vaerdana;
      color: #333;
      }
      .blind{
            position: absolute;
            top :0;
            left :0;
            visibility: hidden;
            overflow: hidden;
            width: 1px;
            height: 1px;
            
      }
      span.error {
            line-height: 16px;
            margin: -3px 15px 11px!important;
            font-size: 12px;
            display: block;
            margin: 5px 0 3px 0;
            color: red;
            }           
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

      $(document).ready(function(){
            
            $(".btn_agree").on("click", function(){ //동의 버튼을 클릭했을때 이벤트 발생
                  var a = $("#li1box").is("#li1box:checked"); // li1box가 체크 되면 true로 반환
                  var b = $("#li2box").is("#li2box:checked"); // li2box가 체크 되면 true로 반환
                  
                  if (a == false || b == false){
                        
                        $("#termsMsg").css("display","block"); // 둘중에 하나라도 false이면 display 를 block 시킨다.
                        
                        return false;
                  }else{
                	  
                	  $("#join_content").submit();
                	  
                  }
            });
            
            
            $("#cbox").on("click", function(){ // 클릭 이벤트 발생
                  
                  var ind = $("#cbox").is("#cbox:checked"); //체크 되어있으면 true, 해제되어있으면 flase 값을 반환 시켜준다.

                  if(ind==true){
                        $(".ckboxs").prop("checked",true); //.prop("checked",true) <- true는 체크를 해준다 false는 체크를 풀어준다.
                        
                  }else{
                        $(".ckboxs").prop("checked",false);
                  }
            });
            
            
            
            
            
            
                  /* $("#li1box").on("click", function(){ // 클릭 이벤트 발생
                  
                  var ind = $("#li1box").is("#li1box:checked"); //체크 되어있으면 true, 해제되어있으면 flase 값을 반환 시켜준다.
                  var ind2 = $("#li2box").is("#li2box:checked");
                  var ind3 = $("#li3box").is("#li3box:checked");
                  var ind4 = $("#li4box").is("#li4box:checked");

                  if(ind==false ){
                        $("#cbox").prop("checked",false); //.prop("checked",true) <- true는 체크를 해준다 false는 체크를 풀어준다.
                                                
                  }else if(ind2 == true && ind2 == true && ind3 == true && ind4 == true){
                        $("#cbox").prop("checked",true);
                        $("#li1box").prop("checked",true);
                        $("#li2box").prop("checked",true);
                        $("#li3box").prop("checked",true);
                        $("#li4box").prop("checked",true);
                        }
                  });
                  $("#li2box").on("click", function(){ // 클릭 이벤트 발생
                              
                        var ind = $("#li1box").is("#li1box:checked"); //체크 되어있으면 true, 해제되어있으면 flase 값을 반환 시켜준다.
                        var ind2 = $("#li2box").is("#li2box:checked");
                        var ind3 = $("#li3box").is("#li3box:checked");
                        var ind4 = $("#li4box").is("#li4box:checked");

                        if(ind2==false ){
                              $("#cbox").prop("checked",false); //.prop("checked",true) <- true는 체크를 해준다 false는 체크를 풀어준다.
                              
                        }else if(ind == true && ind2 == true && ind3 == true && ind4 == true){
                              $("#cbox").prop("checked",true);
                              $("#li1box").prop("checked",true);
                              $("#li2box").prop("checked",true);
                              $("#li3box").prop("checked",true);
                              $("#li4box").prop("checked",true);
                              }
                        });
                        $("#li3box").on("click", function(){ // 클릭 이벤트 발생
                              
                              var ind = $("#li1box").is("#li1box:checked"); //체크 되어있으면 true, 해제되어있으면 flase 값을 반환 시켜준다.
                              var ind2 = $("#li2box").is("#li2box:checked");
                              var ind3 = $("#li3box").is("#li3box:checked");
                              var ind4 = $("#li4box").is("#li4box:checked");

                              if(ind3==false ){
                                    $("#cbox").prop("checked",false); //.prop("checked",true) <- true는 체크를 해준다 false는 체크를 풀어준다.
                                                            
                              }else if(ind == true && ind2 == true && ind3 == true && ind4 == true){
                                    $("#cbox").prop("checked",true);
                                    $("#li1box").prop("checked",true);
                                    $("#li2box").prop("checked",true);
                                    $("#li3box").prop("checked",true);
                                    $("#li4box").prop("checked",true);
                                    }
                              });
                        $("#li4box").on("click", function(){ // 클릭 이벤트 발생
                              
                              var ind = $("#li1box").is("#li1box:checked"); //체크 되어있으면 true, 해제되어있으면 flase 값을 반환 시켜준다.
                              var ind2 = $("#li2box").is("#li2box:checked");
                              var ind3 = $("#li3box").is("#li3box:checked");
                              var ind4 = $("#li4box").is("#li4box:checked");
                              

                              if(ind4==false ){
                                    $("#cbox").prop("checked",false); //.prop("checked",true) <- true는 체크를 해준다 false는 체크를 풀어준다.
                                                            
                              }else if(ind == true && ind2 == true && ind3 == true && ind4 == true){
                                    $("#cbox").prop("checked",true);
                                    $("#li1box").prop("checked",true);
                                    $("#li2box").prop("checked",true);
                                    $("#li3box").prop("checked",true);
                                    $("#li4box").prop("checked",true);
                                    }
                              }); */
                              
                              
                              
                              $(".ckboxs").on("click", function(){
                                    
                                    var chLeng = $(".ckboxs:checkbox:checked").length; // 체크 되는대로 갯수로 반환 시켜준다. 4개 체크 되면 4로 표현
                                    
                                    
                                    
                                    if(chLeng == 4){
                                          $("#cbox").prop("checked",true);
                                    }else{
                                          $("#cbox").prop("checked",false);
                                    }
                              });
                  });
</script>
</head>
<body>
<div id="header">
      <h1 id="naver_logo"><a href="#" class="n_logo"><img src="image/music.png"></a></h1>
      <div class="lang">
            <select id="langselect">
                  <option>한국어</option>
                  <option>English</option>
                  <option>中文(简体)</option>
                  <option>中文(台灣)</option>
            </select>
      </div>
</div>
      <div id="container">
            <form id="join_content" action="member.bizpoll" method="get">
                  <div class="terms">
                        <p class="terms_p">
                              <span class="terms_span">
                                    <input type="checkbox" id="cbox">
                                    <label for="cbox">
                                    이용약관, 개인정보 수집 및 이용,<br>
                                    위치 정보 이용약관(선택), 프로모션 안내<br>
                                    메일 수인(선택)에 모두 동의합니다.
                                    </label>
                              </span>
                        </p>
                        <ul id="terms_ul">
                              <li id="terms_ul_li1">
                                    <span class="ul_li_span">
                                          <input type="checkbox" id="li1box" class="ckboxs">
                                          <label for="li1box" class ="label1">
                                          홈페이지 이용약관 동의<span class="span_only">(필수)</span>
                                          </label>
                                    </span>
                                    <div class="terms_box">
                                          <div class="article">
                                                <h3 class="article_title">제 1 조 (목적)</h3>
                                                <p>제 1 조 (목적) 이 약관은 홈페이지 주식회사 ("회사" 또는 "홈페이지")가 제공하는 홈페이지 <br>
                                                   및 홈페이지 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, <br>
                                                    의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.<br></p>
                                                
                                                <h3 class="article_title">제 2조 (정의)</h3>
                                                <p>이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>
                                                   ①"서비스"라 함은 구현되는 단말기(PC, TV, 휴대형단말기 등의 각종 유<br>
                                                   무선 장치를 포함)와 상관없이 "회원"이 이용할 수 있는 네이<br>
                                                   버 및 네이버 관련 제반 서비스를 의미합니다.</p>
                                          </div>
                                    </div>
                              </li>
                              <li id="terms_ul_li2">
                                    <span class="ul_li_span">
                                          <input type="checkbox" id="li2box" class="ckboxs">
                                          <label for="li2box" class ="label1">
                                          개인정보 수집 및 이용에 대한 안내<span class="span_only">(필수)</span>
                                          </label>
                                    </span>
                                    <div class="terms_box">
                                          <div class="article">
                                                <p>정보통신망법 규정에 따라 네이버에 회원가입 신청하시는 분께 수집하는<br>
                                                 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이<br>
                                                 용기간을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.<br></p>
                                                
                                                <h3 class="article_title">1. 수집하는 개인정보</h3>
                                                <p>
                                                이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 네<br>
                                                이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘<br>
                                                린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위<br>
                                                해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의<br>
                                                 개인정보를 수집합니다.</p>
                                          </div>
                                    </div>
                              </li>
                              <li id="terms_ul_li3">
                                    <span class="ul_li_span">
                                          <input type="checkbox" id="li3box" class="ckboxs">
                                          <label for="li3box" class ="label1">
                                          위치정보 이용약관 동의<span class="span_only terms_no">(선택)</span>
                                          </label>
                                    </span>
                                    <div class="terms_box">
                                          <div class="article">
                                                <p>위치정보 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을<br>
                                                 포함하는 네이버 위치기반 서비스를 이용할 수 있습니다.</p>
                                                
                                                <h3 class="article_title">제 1 조 (목적)</h3>
                                                <p>이 약관은 네이버 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는<br>
                                                 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의 권리, 의<br>
                                                 무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.<br></p>
                                                
                                                 <h3 class="article_title">제 2 조 (약관 외 준칙)</h3>
                                                <p>이 약관에 명시되지 않은 사항은 위치정보의 보호 및 이용 등에 관한 법<br>
                                                률, 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 전기통신기본법,<br>
                                                 전기통신사업법 등 관계법령과 회사의 이용약관 및 개인정보처리방침,<br>
                                                 회사가 별도로 정한 지침 등에 의합니다.</p>
                                                
                                          </div>
                                    </div>
                              </li>
                              <li id="terms_ul_li4">
                              <span class="ul_li_span">
                                          <input type="checkbox" id="li4box" class="ckboxs">
                                          <label for="li4box" class ="label1">
                                          이벤트 등 프로모션 알림 메일 수신<span class="span_only terms_no">(선택)</span>
                                          </label>
                                    </span>
                              </li>
                        </ul>
                        <span id="termsMsg" class="error" style="display:none">홈페이지 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.</span>
                  </div>
                  <div class="btn_double_area">
                        <span><a href="index.bizpoll" class="btn_type btn_default">비동의</a></span>
                        <span><a href="#" class="btn_type btn_agree">동의</a></span>
                  </div>
            </form>
            <div class="group_join">
                  회사, 동아리 등 단체에서 사용할 ID가 필요하세요? <a href="#">단체 회원 가입</a>
            </div>
      </div>
      <div id="footer">
            <ul>
                  <li>
                        <a href="#">이용약관</a>
                  </li>
                  <li>
                        <strong>
                              <a href="#">개인정보처리방침</a>
                        </strong>
                  </li>
                  <li>
                        <a href="#">책임의 한계와 법적고지</a>
                  </li>
                  <li>
                        <a href="#">회원정보 고객센터</a>
                  </li>
            </ul>
            <address>
                  <em>
                        <a href="#" target="_blank" class="logo2">
                              <span class="blind">lyrics</span>
                        </a>
                  </em>
                  <em class="copy">Copyright</em>
                  <em class="u_cri">@</em>
                  <a href="#" target="_blank" class="u_cra">lyrics Corp.</a>
                  <span class="all_r">All Rights Reserved.</span>
            </address>
      </div>

</body>
</html>