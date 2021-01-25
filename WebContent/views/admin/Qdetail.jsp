<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
BoardVo answerVo = (BoardVo) request.getAttribute("answerVo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의관리</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Qdetail.css">
</head>
<body>
<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
</header>
	<section>
		<div class="question__container">
			
		<div class="container__top">
			<div class="question__id">
				<h3>고객ID</h3>
				<div class="question__text">
					<%=boardVo.getMember_id()%>
				</div>
			</div>
			<div class="question__date">
				<h3>작성일</h3>
				<p class="question__text"><%=boardVo.getBoard_dttm()%></p>
			</div>
			
			<div class="question__title">
				<h3>제목</h3>
				<p class="question__text"><%=boardVo.getBoard_subject()%></p>
			</div>
		</div>
		
		<div class="container__bottom">
			<div class="question__content">
				<h3>문의사항</h3>
				<p class="question__text">
					<%=boardVo.getBoard_content()%>
				</p>
			</div>
			<div>
				<h3>답변</h3>
				<p><%=boardVo.getAnswer_content()%></p>
			</div>
		</div>

			<div class="btn__container">
				<a href="/admin/Qanswer?board_sq=<%=boardVo.getBoard_sq()%>">답변하기</a>		
				<a href="/admin/Qmanage">돌아가기</a>
			</div>
		</div>
	</section>
</body>
</html>