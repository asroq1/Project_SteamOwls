<%@page import="java.text.DecimalFormat"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%
	ProductVo productVo = (ProductVo) request.getAttribute("productVo");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("list");
DecimalFormat won = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품관리</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
<link rel="stylesheet" href="/css/admin/productManage.css">
<script src="/js/admin/Pmamage.js" defer></script>
</head>

<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<article>
		<div class="booking_container">
			<div class="form_img">
				<%=list.get(i). getProduct_imagePath()%>
			</div>
			<div class="form_top">
				<h3><%=list.get(i).getProduct_name()%></h3>
				<p class="form_intro">
					<%=list.get(i).getProduct_detail()%>
				</p>
			</div>
			<div class="form_bottom">
				<div class="bottom_text">
					<span class="form_price">
					<p><%= won.format(list.get(i).getProduct_price())%>원</p>
					</span>
				</div>
					<button class="confirm__add" type="button"  onclick="selling(<%=list.get(i).getProduct_sq()%>)">상품판매</button>
				<button class="confirm__delete" type="button" onclick="stopSelling(<%=list.get(i).getProduct_sq()%>)">판매중지</button>
			</div>
		</div>
	</article>
	<%
		}
	%>
</body>

</html>