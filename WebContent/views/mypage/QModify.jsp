<%@page import="shop.steamowls.common.Parser"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo vo = (BoardVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의수정</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Qwriting.css">
<script src="/js/mypage/Qwriting.js"></script>
<script>
	var content = '<%=Parser.chgToHTML(vo.getBoard_content())%>
	';
</script>

</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
		<div class="question__container">
			<form action="/mypage/QModifyProc?board_sq=<%=vo.getBoard_sq()%>"
				method="post" id="editorForm">
				<div class="title">
					<label for="title">제목</label> <input type="text" id="title"
						name="board_subject" value="<%=vo.getBoard_subject()%>" />
				</div>
				<div>
					<jsp:include page="/editor/editorSkinForRegister.jsp" flush="false" />
				</div>
			</form>
			<button type="button" onclick="add()" class="addBtn">등록</button>
		</div>
	</section>

</body>
</html>