<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.MypageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MypageVo> list = (ArrayList<MypageVo>) request.getAttribute("list");
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
String pn = request.getParameter("pn");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>나의 리뷰</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/RmyReview.css">
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<h1 id="page__intro">리뷰 게시판</h1>
	<table>

	
	<tr class="category">
		<th class="category__no">No</th>
		<th class="category__sub">제목</th>
		<th class="category__id">작성자</th>
		<th class="category__time">날짜</th>
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