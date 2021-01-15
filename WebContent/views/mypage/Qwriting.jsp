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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의하기</title>
<script src="/js/mypage/Qwriting.js"></script>
</head>
<body>
	<section>
		<!-- 제목 , 내용 ,게시판 sq -->
				<!-- 여기 action에 경로 수정해주세요 -->
		<form action="/mypage/QWritingProc" method="post" id="editorForm">
			<label for="title">제목</label>
			<input type="text" id="title" name="board_subject" />
			<div>
				<jsp:include page="/editor/editorSkinForRegister.jsp" flush="false" />
			</div>
		</form>
		<button  type="button"  onclick="add()">등록</button>
	</section>

	<a href="/mypage/question">돌아가기</a>
</body>
</html>