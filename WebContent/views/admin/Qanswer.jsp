<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%
	String board_sq = (String) request.getAttribute("board_sq");
    BoardVo vo = (BoardVo) request.getAttribute("vo");
    %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>문의답변</title>
	<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
</head>
<script type="text/javascript" defer>
	function editorForm() {
		$('#editorForm').submit();
	}
</script>

<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<form action="/admin/QanswerProc?board_sq=<%=board_sq%>" method="post" id="editorForm">
		<div>
			<input type="text" id="content" name="content">
		</div>
	</form>
	<button onclick="editorForm()">등록</button>
	<%-- <a href="/admin/QanswerProc?board_sq=<%=board_sq%>">게시</a>	 --%>
</body>

</html>