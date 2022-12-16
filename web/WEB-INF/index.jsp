<%@page import="kh.s0.myboard.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 계층형 게시판 메인페이지</title>
<link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
</head>
<body>
<%
//스크립틀릿
MemberVo loginSsInfo = (MemberVo)request.getSession().getAttribute("loginSsInfo");
%>


<h1>메인페이지</h1>
<button class="btn board">게시판</button>

<%
if(loginSsInfo == null){
%>
	<button class="btn login">로그인</button>
<%
} else {
%>
	<button class="btn mypage"><%=loginSsInfo.getMname() %> 페이지</button>
	<button class="btn logout">로그아웃</button>
<%
}
%>

<img src="">


<script>
$(function(){
	$(".btn.board").on("click", BoardClickHandler);
	$(".btn.login").on("click", LoginClickHandler);
	$(".btn.mypage").on("click", MyPageClickHandler);
	$(".btn.logout").on("click", LogoutClickHandler);
});
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