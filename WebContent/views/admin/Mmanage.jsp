<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.admin.member.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberVo MemberVo = (MemberVo) request.getAttribute("bookingVo");
ArrayList<MemberVo> list = (ArrayList<MemberVo>) request.getAttribute("list");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
String pn = request.getParameter("pn");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원관리</title>
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/admin/gotoAdmin.css">
    <link rel="stylesheet" href="/css/admin/Bmanage.css">
    <link rel="stylesheet" href="/css/mypage/RmyReview.css">
</head>

<body>
    <header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
    <nav role="navigation">
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
<%-- 	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getSq()%></td>
		<td><%=list.get(i).getId() %></td>
		<td><%=list.get(i).getName()%></td>
		<td><%=list.get(i).getTel()%></td>
		<td><%=list.get(i).getGender()%></td>
	</tr>
	<%
	}
	%> --%>
	
		 <table>
			<tr class="category">
				<th class="category__no">회원번호</th>
				<th class="category__sub">아이디</th>
				<th class="category__id">이름</th>
				<th class="category__time">전화번호</th>
				<th class="category__gender">성별</th>
			</tr>
			<%
	for (int i = 0; i < list.size(); i++) {
	%>
				<tr class="category__data">
					<td><%=list.get(i).getSq()%></td>
					<td><a href="/admin/Mdetail?review_sq=<%=list.get(i).getSq()%>"><%=list.get(i).getId()%></a></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getTel()%></td>
					<td><%=list.get(i).getGender()%></td>
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
			href="/admin/Mmanage?pn=<%=pagenation.getStartPageNumber() - 1%>">prev</a>
		<%
			}
		%>
		<%
			for (int i = pagenation.getStartPageNumber(); i <= pagenation.getEndPageNumber(); i++) {
			if (i != Integer.parseInt(pn)) {
		%>
		<a href="/admin/Mmanage?pn=<%=i%>"><%=i%></a>
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
			href="/admin/Mmanage?pn=<%=pagenation.getStartPageNumber() + 1%>">next</a>
		<%
			}
		%>
		</span>
</body>
</html>