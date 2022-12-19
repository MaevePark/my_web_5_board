<%@page import="kh.s0.myboard.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="./view/error/alert.jsp" %> --%>
<%! int maxCnt = 5000; %>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 계층형 게시판 메인페이지</title>
<link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/footer.css" rel="stylesheet">
<script src="<%=ctxPath%>/js/jquery-3.6.1.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/view/boardwrite.jsp" %>


<%
//스크립틀릿
MemberVo loginSsInfo = (MemberVo)request.getSession().getAttribute("loginSsInfo");
%>


<h1>메인페이지</h1>
<button class="btn board">게시판</button>

<%
if(loginSsInfo == null){
%>
	<button class="btn login">그냥로그인</button>
	
	<div class="wrap_login">
	<%-- <form action="<%=request.getContextPath() %>/login.do" method="post"> --%>
	<form id="frm_login">
		<fieldset>
			<legend>로그인</legend>
			id: <input type="text" name="mid" id="mid">
			<br>
			pwd: <input type="password" name="mpwd" id="mpwd">
			<br>
			<input type="hidden" name="aaa" value="에이에이에이이지요">
			<button type="button" class="btn loginajax">ajax로그인</button>
		</fieldset>
	</form>
	<!-- </form> -->
	</div>
	<div class="wrap_logout" style="display:none;">
		<button class="btn mypage">페이지</button>
		<button class="btn logout">로그아웃</button>
	</div>
<%
} else {
%>
	<button class="btn mypage"><%=loginSsInfo.getMname() %> 페이지</button>
	<button class="btn logout">로그아웃</button>
<%
}
%>

<%@ include file="/WEB-INF/view/boardwrite.jsp" %>
<jsp:include page="/WEB-INF/view/boardwrite.jsp"></jsp:include>

<iframe width="560" height="315" src="https://www.youtube.com/embed/fN5mSW5RurU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<script>
$(function(){
	$(".btn.board").on("click", BoardClickHandler);
	$(".btn.login").on("click", LoginClickHandler);
	$(".btn.loginajax").on("click", LoginajaxClickHandler);
	$(".btn.mypage").on("click", MyPageClickHandler);
	$(".btn.logout").on("click", LogoutClickHandler);
});
function LoginajaxClickHandler(){
	console.log("LoginajaxClickHandler");
	
	var formQuery = $("#frm_login").serialize();
	console.log(formQuery);
	
	var deleteList = [];
	var order1 = {pno:21, amount:2};
	var order2 = {pno:31, amount:7};
	var order3 = {pno:35, amount:3};
	deleteList.push(order1);
	deleteList.push(order2);
	deleteList.push(order3);
	console.log(JSON.stringify(deleteList));
	
	$.ajax({
		url:"<%=ctxPath%>/login.lo",
		type:"post",
		contentType:"application/json",
		data: 
			// 방법 3 json 형태
			JSON.stringify(deleteList)
		
			// 방법 2
			//form 태그 내부의 name=value&n2=v2 형태의 query
			//$("#frm_login").serialize()
// 방법 1
// object 형식으로 query를 생성
//			{
//			mid2: $("#mid").val() ,
//			mpwd2: $("#mpwd").val() 
//			}
		,  // url로 전달할 데이터, object 
		
		dataType:"json",
		
		// success의 콜백함수의 매개변수로 들어오는 값은 url에서 전달해준 값이 들어있음. responsevalue
		success: function( data ){  
			console.log(data); 
			// ajax는 데이터 전달 전송 받는 것에 목적이 있어 session 의 변화를 인식하지 못함.
			//var sessionCheck = '<%=request.getSession().getAttribute("loginSsInfo")%>';
			//console.log(sessionCheck);
			// f5 누른것 처럼
			//location.reload();
			
			
			
		},   
		// error의 콜백함수의 매개변수로 들어오는 값은 url에서 전달 그리고 응답과정에서 발생하는 오류내용
		error:function( request, status, error ){
			console.log(request);
			console.log(status);
			console.log(error);
			alert("code:"+request.status+"\n"
					+"message"+request.responseText+"\n"
					+"error"+error);			
		}
	});
}

function BoardClickHandler(){
	console.log("BoardClickHandler");
	location.href = "<%=request.getContextPath()%>/board/list";
}
function LoginClickHandler(){
	console.log("LoginClickHandler");
	location.href = "<%=request.getContextPath()%>/login";
}
function MyPageClickHandler(){
	console.log("MyPageClickHandler");
	location.href = "<%=request.getContextPath()%>/mypage";
}
function LogoutClickHandler(){
	console.log("LogoutClickHandler");
	// jsp 스크립틀릿에서만 사용 가능한 코드로 이곳에서 사용 불가함 //session.invalidate();
	location.href = "<%=request.getContextPath()%>/logout";
}
</script>
</body>
</html>