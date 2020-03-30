<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@include file="../include/header.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<style>	
		.item {
		    float: left;
		    width: 160px;
		    height: 235px;
		    text-align: center;
		    font-weight: bold;
		    padding: 14px;
		    border: 1px solid black;
		    margin:0 15px 15px 0;
		}
		.item img {
			width: 165px;
			height: 200px;
		}
		.item a{
			text-decoration: none;
			color: black;
		}
		button{
			margin-top:20px;
			position: absolute;
			left:340px;
			bottom:-10px;
		}
	</style>
	<section>
		<c:choose>
			<c:when test="${list.size()==0 }">
				<h2>상영 영화를 추가해 주세요</h2>
				
			</c:when>
			<c:otherwise>
				<c:forEach var="movie" items="${list }">
					<div class="item">
					<a href="${pageContext.request.contextPath }/section/detail.do?no=${movie.mNo}">
							<img src = "${pageContext.request.contextPath }/movie/${movie.file }">
							<p>${movie.title}</p>
						</a>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	<a href="${pageContext.request.contextPath }/section/add.do"><button>상영 영화 추가하기</button></a>
</section>


<%@include file="../include/footer.jsp" %>