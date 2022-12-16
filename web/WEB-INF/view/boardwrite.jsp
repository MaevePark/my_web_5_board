<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글쓰기</title>
<link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
</head>
<body>
<h1>게시글쓰기</h1>
<form action="<%=request.getContextPath()%>/board/write.do" method="post">
	제목:<input type="text" name="btitle">
	<br>
	내용:<input type="text" name="bcontent">
	<br>
	<button type="submit">글등록</button>
	<br><br>
	<button type="button" class="btn board">게시글목록</button>
	<script>
	$(".btn.board").on("click", BoardClickHandler);
	function BoardClickHandler(){
		console.log("BoardClickHandler");
		location.href = "<%=request.getContextPath()%>/board/list";
	}
	</script>
</form>
</body>
</html>