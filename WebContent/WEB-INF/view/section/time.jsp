<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../include/header.jsp" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
	table{
		border-collapse: collapse;
		width:800px;
	}
	th, td{
		border:1px solid black;
	}
	th{
		width:200px;
	}
	h1{
		text-align: center;
	}
</style>

<section>

<h1>&#60;상영 시간표&#62;</h1>
	<table>
		<c:choose>
			<c:when test="${list.size()==0}">
				<tr>
					<th colspan="2">추가된 영화가 없습니다.</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="m" items="${list}">
					<tr>
						<th>${m.title}</th>
						<td>${m.time}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</section>

<%@include file="../include/footer.jsp" %>