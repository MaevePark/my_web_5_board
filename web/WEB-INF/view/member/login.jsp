<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="<%=request.getContextPath() %>/login.do" method="post">
	<fieldset>
		<legend>로그인</legend>
		id: <input type="text" name="mid">
		<br>
		pwd: <input type="password" name="mpwd">
		<br>
		<button type="submit">로그인</button>
	</fieldset>
</form>
</body>
</html>