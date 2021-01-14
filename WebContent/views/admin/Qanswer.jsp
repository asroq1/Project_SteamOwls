<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

    <%
    MemberVo vo = (MemberVo) request.getAttribute("vo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의답변</title>
<script type="text/javascript">
	<%-- let content = '<%=vo.getContent()%>'; --%>
</script>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
</head>
<body>
문의답변화면
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
<nav role="navigation">
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
<a href="/admin/question/Qmanage">게시</a>
<form action="/admin/product/PaddProc" method="post" id="editorForm">
<div>
	<jsp:include page="/editor/editorSkinForModify.jsp" flush="false" />
</div>
</form>
</body>
</html>