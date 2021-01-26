<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
String pn = request.getParameter("pn");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>문의게시판</title>
	<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/css/mypage/RmyReview.css">
</head>

<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>

	<table>
	
	<tr class="category">
		<th class="category__no">문의번호</th>
		<th class="category__sub">문의제목</th>
		<th class="category__id">문의자</th>
		<th class="category__time">문의날짜</th>
		<th>문의답변여부</th>
	</tr>

	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getBoard_sq()%></td>
		<td><a href="/admin/Qdetail?board_sq=<%=list.get(i).getBoard_sq()%>"><%=list.get(i).getBoard_subject()%></a></td>
		<td><%=list.get(i).getMember_id()%></td>
		<td><%=list.get(i).getBoard_dttm()%></td>
		<td><%=list.get(i).isAnswer_fl()%></td>
		
	</tr>
	<%
		}
	%>
	</table>
	
		<span class="pagination__container">
			<%
			if (pagenation.getStartPageNumber() != 1) {
		%>
		<a
			href="/admin/Qmanage?pn=<%=pagenation.getStartPageNumber() - 1%>">prev</a>
		<%
			}
		%>
		<%
			for (int i = pagenation.getStartPageNumber(); i <= pagenation.getEndPageNumber(); i++) {
			if (i != Integer.parseInt(pn)) {
		%>
		<a href="/admin/Qmanage?pn=<%=i%>"><%=i%></a>
		<%
			} else {
		%>
		<%=i%>
		<%
			}
		}
		%>
		<%
			if (pagenation.getEndPageNumber() != pagenation.getTotalPageCount()) {
		%>
		<a
			href="/admin/Qmanage?pn=<%=pagenation.getStartPageNumber() + 1%>">next</a>
		<%
			}
		%>
		</span>
</body>

</html>