<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
				<!-- 여기 action에 경로 수정해주세요 -->
		<form action="/board/addBoardProc" method="post" id="editorForm">
			<label for="title">제목</label>
			 	<!-- 데이터 이름은 name 수정하면 가능 -->
			<input type="text" id="title" name="title" />
			<div>
				<jsp:include page="/editor/editorSkinForRegister.jsp" flush="false" />
			</div>

		</form>
		<button onclick="join()">등록</button>
		<button onclick="cancle()">취소</button>
	</section>

	<a href="/mypage/question">문의로 돌아가기2</a>
</body>
</html>