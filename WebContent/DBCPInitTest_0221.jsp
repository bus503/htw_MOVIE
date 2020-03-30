<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
	
		try{String jdbcDriver = "jdbc:apache:commons:dbcp:htw_MOVIE";
		conn = DriverManager.getConnection(jdbcDriver);
		if(conn !=null){
			out.print("커넥션 풀 연결성공");
		}else{
			out.print("커넥션 풀 연결실패");
		}
		}finally{
			if(conn !=null){
				conn.close();
			}			
		}
	%>
</body>
</html>