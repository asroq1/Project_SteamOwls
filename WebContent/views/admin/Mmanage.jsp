<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.admin.member.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	ArrayList<MemberVo> list = (ArrayList<MemberVo>) request.getAttribute("list");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원관리</title>
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/admin/gotoAdmin.css">
</head>

<body>
    <header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
    <nav role="navigation">
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
	
	<h1>회원목록</h1>
	<br>
	<div>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>성별</th>
		</tr>

	</div>


	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getSq()%></td>
		<td><a href="/admin/Mdetail?review_sq=<%=list.get(i).getSq()%>"><%=list.get(i).getId()%></a></td>
		<td><%=list.get(i).getName()%></td>
		<td><%=list.get(i).getTel()%></td>
		<td><%=list.get(i).getGender()%></td>
		<br>
	</tr>
	<%
	}
	%>
</body>

</html>