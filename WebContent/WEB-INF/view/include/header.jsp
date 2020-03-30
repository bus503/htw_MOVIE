<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container {
	width: 1000px;
	margin: 0 auto;
}

#container header {
	background-color: #fef8dc;
	text-align: center;
	padding: 10px;
	width: 980px;
	height: 130px;
}

#container h1 {
	padding-bottom: 10px;
}

#container header a {
	text-decoration: none;
	color: black;
	padding: 15px;
}

#container nav {
	float: left;
    padding: 40px 15px 40px 17px;
    width: 10%;
    text-align: center;
    display: inline-block;
    background-color: #fef8dc;
   
}

#container nav a {
	color: black;
	text-decoration: none;
	padding-right: 10px;
}

#container section {
	width: 82%;
	float: right;
	padding: 20px 10px;
	color: black;
	position: relative;
}

img {
	width: 815px;
	height: 630px;
}

#container footer {
	clear: both;
	background-color: #fef8dc;
	text-align: center;
	height: 85px;
	line-height: 80px;
}
span{
	color:#CC723D;
}
</style>
</head>
<body>
	<div id="container">

		<header>
			<h1>대구 CGV</h1>
			
<%-- 	<%
		String auth = (String)session.getAttribute("Auth");
		if(auth != null){
			out.println("<a href='cgvLogout_0214.jsp'>로그아웃</a><span>["+auth+"]님 반갑습니다.</span>");
			
		}else{
			out.println("<a href='cgvLoginForm_0214.jsp'>Login</a>");
		}
	%> --%>
		</header>
		<nav>
			<a href="${pageContext.request.contextPath }/section/home.do">HOME</a><br>
			<br>
			<br>
			<br> <a href="${pageContext.request.contextPath }/section/list.do">상영영화</a><br>
			<br>
			<br>
			<br> <a href="${pageContext.request.contextPath }/section/time.do">상영시간표</a><br>
			<br>
			<br>
			<br> <a href="cgvBoardList_0212.jsp">게시판</a>
		</nav>