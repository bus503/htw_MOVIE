<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="../include/header.jsp" %>
  <style>
fieldset {
	width: 500px;
	margin:110px auto;
}

label {
	width: 100px;
	float: left;
}

</style>

<section>
	<form action="add.do" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>영화 정보</legend>
			<p>
				<label>제목</label> <input type="text" name="title"
					placeholder="영화 이름">
			</p>
			<p>
				<label>상세 설명</label>
				<textarea rows="10" cols="50" name="detail" placeholder="영화 상세 이름"></textarea>
			</p>
			<p>
				<label>파일</label> <input type="file" name="file">
			</p>
			<p>
				<label>상영 시간</label> <input type="text" name="time" placeholder="경로">
			</p>
			<p>
				<input type="submit" value="전송">
			</p>
		</fieldset>
	</form>
</section>
  
  	<%@include file="../include/footer.jsp" %>