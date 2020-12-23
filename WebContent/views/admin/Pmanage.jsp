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
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
<link rel="stylesheet" href="/css/admin/productManage.css">
<!-- <script src="/js/admin/Pmamage.js" defer></script> -->
</head>

<body>
	<header>
		<div class="header__logo">
			<a href="/views/home/index.jsp"> <img src="/css/picture/owls.PNG"
				alt="로고사진">
			</a>
		</div>
		<div class="header__signForm">
			<a href="/admin/Alogout">로그아웃</a>
		</div>
	</header>
	<nav role="navigation">
		<ul id="main-menu">
			<li><a href="#">상품관리</a>
				<ul id="sub-menu">
					<li><a href="/admin/Padd" aria-label="subemnu">상품추가</a></li>
					<li><a href="/admin/Pdelete" aria-label="subemnu">상품삭제</a></li>
					<li><a href="/admin/Pmanage" aria-label="subemnu">상품관리</a></li>
				</ul></li>
			<li><a href="#">예약관리</a>
				<ul id="sub-menu">
					<li><a href="/admin/Bmanage.jsp" aria-label="subemnu">예약내역</a></li>
					<li><a href="/admin/" aria-label="subemnu">예약완료</a></li>
					<li><a href="/admin/" aria-label="subemnu">예약수정</a></li>
					<li><a href="/admin/" aria-label="subemnu">예약취소</a></li>
				</ul></li>
			<li><a href="#">매출관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/Smanage.jsp" aria-label="subemnu">매출내역</a></li>
				</ul></li>
			<li><a href="#">회원관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/" aria-label="subemnu">회원수정</a></li>
					<li><a href="/views/admin/" aria-label="subemnu">회원탈퇴</a></li>
					<li><a href="/views/admin/Mmanage.jsp" aria-label="subemnu">회원내역</a></li>
				</ul></li>
			<li><a href="#">문의관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/Qmanage.jsp" aria-label="subemnu">문의내역</a></li>
					<li><a href="/views/admin/Qanswer.jsp" aria-label="subemnu">답변하기</a></li>
				</ul></li>
		</ul>
	</nav>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<section>
		<h1>판매상품내역</h1>
		<div class="form__container">
			<form class="form__container" method="post" id="ckpoint">
				<div class="booking__Form">

					<div class="booking_img">
						<%-- <%-<%=list.get(i).getProduct_image()%>  --%>
					</div>
					<div class="title__top">
						<div class="booking__title">
							<h3>
								<%=list.get(i).getProduct_name()%>
							</h3>
						</div>
						<div class="booking_bottom">
							<div class="booking__intro">
								<p>
									<%=list.get(i).getProduct_detail()%>
								</p>
							</div>
							<div class="booking_info">
								<p>
									<%=list.get(i).getProduct_people()%>명
								</p>
								<p>
									₩<%=list.get(i).getProduct_price()%>
								</p>
							</div>
						</div>
					</div>

				</div>
				<div class="btn_container">
					<input class="confirm__add" type="submit" value="상품판매"
					formaction="/admin/PsellingButton?product_sq=<%=list.get(i).getProduct_sq()%>">
				<input class="confirm__delete" type="submit" value="판매정지"
					formaction="/admin/PstopButton?product_sq=<%=list.get(i).getProduct_sq()%>">
				</div>
			</form>
		</div>
		</div>
	</section>
	<%
		}
	%>
</body>

</html>