<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%@page import="shop.steamowls.common.LoginManager"%>
<%
	ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("list");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>예약</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/productManage.css">
</head>

<body>
	<header>
		<div class="header__logo">
			<a href="/views/home/index.jsp"> <img src="/css/picture/owls.PNG"
				alt="로고사진">
			</a>
		</div>
		<%
			if (sq == null) {
		%>
		<div class="header__signForm">
			<a href="/member/login">로그인</a>
		</div>
		<%
			}
		%>
	</header>
	<%-- <%
		for (int i = 0; i < list.size(); i++) {
	%> --%>
	<section>
		<form action="/admin/bookProc" class="form__container" method="post"
			id="ckpoint">
			<div class="booking__Form">

				<div class="booking_img">
					<%-- <%-<%=list.get(i).getProduct_image()%>  --%>
				</div>
				<div class="title__top">
					<div class="booking__title">
						<h3>
							<%-- <%=list.get(i).getProduct_name()%> --%>
						</h3>
					</div>
					<div class="booking_bottom">
						<div class="booking__intro">
							<p>
								<%-- <%=list.get(i).getProduct_detail()%> --%>
							</p>
						</div>
						<div class="booking_info">
							<p>
								<%-- <%=list.get(i).getProduct_people()%>명 --%>
							</p>
							<p>
							<%-- 	₩<%=list.get(i).getProduct_price()%> --%>
							</p>
						</div>
					</div>
				</div>
		</form>
		<div class="booking__confirm">
			<button class="confirm__add" onclick="Pdelete()">예약하기</button>
		</div>
	</section>
	<%-- <%
		}
	%> --%>
</body>

</html>