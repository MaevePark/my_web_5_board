<%@page import="common.jdbc.JdbcTemplate"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 a 파일</title>
</head>
<body>
임시 a 파일
<%
	//생성
	// 기존코드 
	//String sqlInsert = "insert into dept values(seq_test1.nextval, 'abcd', 'seoul')";
	String sqlInsert = "insert into dept values(seq_test1.nextval, ?, ?)";
	//String sql = "select * from dept where dname like '%E%' ";
	String sql = "select * from dept where dname like ?";
	
	Connection conn = JdbcTemplate.getconnection();
	
	//실행
	PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
	//pstmt 생성하고 sql문 등록된 이후
	//여기에
	//? 부분에 값을 넣어줘야 함
	pstmt.setInt(1, 32);
	pstmt.setString(1, "a");
	//pstmt 에 등록된 sql문을 실행하기 전
	int result = pstmt.executeUpdate();
	
	//pstmt.close();
	JdbcTemplate.close(pstmt);
%>
	<br> insert 결과는 <%=result %> <br>
<%	

	//새로생성
	pstmt = conn.prepareStatement(sql);
	//pstmt 생성하고 sql문 등록된 이후
	pstmt.setString(1,"&O%");
	//pstmt에 등록된 sql문을 실행하기 전
	ResultSet rest = pstmt.executeQuery();
	while(rest.next()){
%>
	html코드영역<br>
	<%= rest.getInt(1) %> | <%= rest.getString(2) %> | <%= rest.getString(3) %>
	<br>
<%	
	} //while 
	JdbcTemplate.close(rest);
	JdbcTemplate.close(pstmt);
	JdbcTemplate.close(conn);
	
	
%>

</body>
</html>