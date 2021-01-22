<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
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
<title>상세페이지</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Qdetail.css">
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>

	<%--   
    <h1>Article Detail</h1>
    <br>
    <h3>NO : <%=vo.getBoard_sq()%></h3>
    <h3>SUBJECT : <%=vo.getBoard_subject()%></h3>
    <h3>CONTENT : <%=vo.getBoard_content()%></h3>
    <h3>ID : <%=vo.getMember_id()%></h3>
    <h3>DATE : <%=vo.getBoard_dttm()%></h3>

    <%if(Integer.parseInt(sq) == vo.getMember_sq()){ %>
    <a href="/mypage/QModify?board_sq=<%=vo.getBoard_sq()%>">글수정</a>
    <a href="/mypage/QDelete?board_sq=<%=vo.getBoard_sq()%>">글삭제</a>
    <%} %>
    <a href="/mypage/question">문의목록으로</a>
    
     --%>
	<section>
		<div class="question__container">
			
		<div class="container__top">
			<div class="question__id">
				<h3>아이디</h3>
				<div class="question__text">

					<%=vo.getMember_id()%>
				</div>
			</div>
			<div class="question__date">
				<h3>작성일</h3>
				<p class="question__text"><%=vo.getBoard_dttm()%></p>
			</div>
			
			<div class="question__title">
				<h3>글제목</h3>
				<p class="question__text"><%=vo.getBoard_subject()%></p>
			</div>
		</div>
		
		<div class="container__bottom">
			<div class="question__content">
				<h3>글내용</h3>
				<p class="question__text">
					<%=vo.getBoard_content()%></p>
			</div>
		</div>

			<div class="btn__container">
				<%
					if (Integer.parseInt(sq) == vo.getMember_sq()) {
				%>
				<a href="/mypage/QModify?board_sq=<%=vo.getBoard_sq()%>">글수정</a> <a
					href="/mypage/QDelete?board_sq=<%=vo.getBoard_sq()%>">글삭제</a>
				<%
					}
				%>
				<a href="/mypage/question">문의목록으로</a>
			</div>
		</div>

	</section>

</body>

</html>