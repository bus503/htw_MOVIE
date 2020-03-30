<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../include/header.jsp" %>    

	<style>
		#con{
			width:600px;
			margin: 140px auto;
			pad
		}
		#detail img{
			float: left;
		}
		#detail img{
			 width: 250px;
  		 	 height: 340px;
  		 	 padding-right:20px;

		}
		#text .p1{
			font-size:13px;
			font-weight: bold;
		}
		#text .p2{
			font-size:15px;
		}
		
	</style>
	
	<section>
		<div id="con">
			<div id="detail">
			<input type="hidden" name="no" value="${movie.mNo }">
				<img src ="${pageContext.request.contextPath }/movie/${movie.file }">
			</div>
			<div id="text">
				<h3>
					${movie.title }
				</h3>
				<p class="p1">
						&#60;줄거리&#62;
				</p>
				<p class="p2">
					<${movie.detail }
				</p>
			</div>
		</div>
	</section>
<%@include file="../include/footer.jsp" %>