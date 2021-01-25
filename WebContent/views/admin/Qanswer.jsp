<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%
	String board_sq = (String) request.getAttribute("board_sq");
    BoardVo vo = (BoardVo) request.getAttribute("vo");
    %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>문의답변</title>
	<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
	<link rel="stylesheet" href="/css/admin/Qanswer.css">
	<script src="/js/admin/Qanswer.js" defer></script>
</head>

<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<form action="/admin/QanswerProc?board_sq=<%=board_sq%>" method="post" id="checkPoint">
		<div>
			 <textarea id="detail__form" name="answer_content" rows="5" placeholder="자세한 리뷰는 고객의 예약에 많은 도움이 됩니다." maxlength="200"></textarea>
		</div>
	</form>
	<div class="review__btn">
		<button type="submit" id="submit__btn">등록</button>
	</div>
</body>

</html>