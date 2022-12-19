<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%-- <%@ page isErrorPage="true" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alert</title>
<link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
</head>
<body>

<script>
	// 오류발생의 원인이 되므로 반드시 "" 따옴표로 묶어서 값을 저장함. //var msg2 = <%=request.getAttribute("msg")%>;
	// var msg2 = ;  // 
	var msg = "<%=request.getAttribute("msg")%>";
	//var msg = "<%-- <%= exception.getClass().getName() %> --%>";
	alert(msg);
	//location.replace = "<%=request.getContextPath()%>/board/write";
	history.back();
</script>
</body>
</html>