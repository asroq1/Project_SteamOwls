<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.common.Pagenation"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
Pagenation pagenation = (Pagenation) request.getAttribute("pagenation");
String pn = request.getParameter("pn");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의게시판</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon"
	type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/css/mypage/Question.css">
</head>

<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>

	<h1>문의 게시판</h1>
	<div id="boxalign">
		<h3>
			아울스 서비스에 대해 <br> 궁금한 점이 있으신 경우 문의해주세요.
		</h3>
		<table>

			<tr class="category">
				<th class="category__no">문의번호</th>
				<th class="category__sub">제목</th>
				<th class="category__id">작성자</th>
				<th class="category__time">날짜</th>
			</tr>
			<%
	for (int i = 0; i < list.size(); i++) {
	%>
				<tr class="category__data">
					<td><%=list.get(i).getBoard_sq()%></td>
					<td><a
							href="/mypage/QDetail?board_sq=<%=list.get(i).getBoard_sq()%>"><%=list.get(i).getBoard_subject()%></a>
					</td>
					<td><%=list.get(i).getMember_id()%></td>
					<td><%=list.get(i).getBoard_dttm()%></td>
				</tr>
			<%
				}
			%>
		</table>
		<span class="pagination__container">
		 <%
 			if (pagenation.getStartPageNumber() != 1) {
		 %> 
		 <a	href="/mypage/question?pn=<%=pagenation.getStartPageNumber() - 1%>"></a>
			<%
			}
			%>
		
		 <%
 	for (int i = pagenation.getStartPageNumber(); i <= pagenation.getEndPageNumber() - 1; i++) {
 	if (i != Integer.parseInt(pn)) {
		 %>
		  
 <a href="/mypage/question?pn=<%=i%>"><%=i%></a> 
 	<%
 		} else {
 	%> 	<%=i%> <%
 	}
 }
 %> <%
 	if (pagenation.getEndPageNumber() != pagenation.getTotalPageCount()) {
 %> <a href="/mypage/question?pn=<%=pagenation.getStartPageNumber()%>">next</a>

			<%
				}
			%>
		</span> 
		<span class="btn__container"> <a href="/mypage/QWriting">글쓰기</a>
			<a href="/mypage/gotoMypage">마이페이지</a>
		</span>
	</div>
</body>

</html>