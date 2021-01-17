<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.MypageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<MypageVo> list = (ArrayList<MypageVo>) request.getAttribute("list"); 
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
String pn = request.getParameter("pn");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		<td><a href="/mypage/RmyReviewDetail?review_sq=<%=list.get(i).getReview_sq()%>"><%=list.get(i).getReview_subject()%></a></td>
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
		<a href="/mypage/RmyReview?pn=<%=pagenation.getStartPageNumber() - 1%>">prev</a>
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
		<a href="/mypage/RmyReview?pn=<%=pagenation.getStartPageNumber() + 1%>">next</a>
		<%
		}
		%>
	</div>
</body>
</html>