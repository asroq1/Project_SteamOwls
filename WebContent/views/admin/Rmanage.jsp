<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.admin.review.vo.ReviewVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
	ArrayList<ReviewVo> list = (ArrayList<ReviewVo>) request.getAttribute("list");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
String pn = request.getParameter("pn");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의관리</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	
	<h1>리뷰 게시판</h1>
	<br>
	<div>
		<tr>
			<th>리뷰번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>

	</div>


	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getReview_sq()%></td>
		<td><a href="/admin/Rdetail?review_sq=<%=list.get(i).getReview_sq()%>"><%=list.get(i).getReview_subject()%></a></td>
		<td><%=list.get(i).getId()%></td>
		<td><%=list.get(i).getReview_dttm()%></td>
		<br>
	</tr>
	<%
	}
	%>
	
	<div>
		<%
		if (pagenation.getStartPageNumber() != 1) {
		%>
		<a href="/admin/Qmanage?pn=<%=pagenation.getStartPageNumber() - 1%>">prev</a>
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
		<a href="/admin/Qmanage?pn=<%=pagenation.getStartPageNumber() + 1%>">next</a>
		<%
		}
		%>
	</div>
</body>
</html>