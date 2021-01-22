<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.admin.review.vo.ReviewVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ReviewVo> list = (ArrayList<ReviewVo>) request.getAttribute("list");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
String pn = request.getParameter("pn");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의관리</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
<link rel="stylesheet" href="/css/mypage/RmyReview.css">
</head>
<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<%-- 
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
	%> --%>
	
	<table>
	
	<tr class="category">
		<th class="category__no">리뷰번호</th>
		<th class="category__sub">제목</th>
		<th class="category__id">작성자</th>
		<th class="category__time">작성시간</th>
	</tr>




	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getReview_sq()%></td>
		<td><a
			href="/mypage/RmyReviewDetail?review_sq=<%=list.get(i).getReview_sq()%>"><%=list.get(i).getReview_subject()%></a></td>
		<td><%=list.get(i).getId()%></td>
		<td><%=list.get(i).getReview_dttm()%></td>
		
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
			href="/mypage/RmyReview?pn=<%=pagenation.getStartPageNumber() - 1%>">prev</a>
		<%
			}
		%>
		<%
			for (int i = pagenation.getStartPageNumber(); i <= pagenation.getEndPageNumber(); i++) {
			if (i != Integer.parseInt(pn)) {
		%>
		<a href="/mypage/RmyReview?pn=<%=i%>"><%=i%></a>
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
			href="/mypage/RmyReview?pn=<%=pagenation.getStartPageNumber() + 1%>">next</a>
		<%
			}
		%>
		</span>
</body>
</html>