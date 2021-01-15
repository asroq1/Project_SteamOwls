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
<script src="/js/mypage/Qwriting.js"></script>
<script>
	var content = '<%=Parser.chgToHTML(vo.getBoard_content())%>';
</script>

</head>
<body>
	<section>
		<!-- 제목 , 내용 ,게시판 sq -->
				<!-- 여기 action에 경로 수정해주세요 -->
		<form action="/mypage/QModifyProc?board_sq=<%=vo.getBoard_sq() %>" method="post" id="editorForm">
			<label for="title">제목</label>
			<input type="text" id="title" name="board_subject" value="<%=vo.getBoard_subject()%>"/>
			<div>
				<jsp:include page="/editor/editorSkinForModify.jsp" flush="false" />
			</div>
		</form>
		<button  type="button" onclick="add()">등록</button>
	</section>

	<a href="/mypage/question">돌아가기</a>
</body>
</html>