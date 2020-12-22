<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
ProductVo productVo = (ProductVo) request.getAttribute("productVo");
	LoginManager lm = LoginManager.getInstance();
	 String sq = lm.getMemberSq(session);
	 ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("list");
	/* ProductVo  productVo = (ProductVo) request.getAttribute("productVo"); */
%> 
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상품삭제</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
<link rel="stylesheet" href="/css/admin/productManage.css">
<script src="/js/admin/Pdelete.js" defer></script>
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
					<li><a href="/views/admin/Padd.jsp" aria-label="subemnu">상품추가</a></li>
					<li><a href="/views/admin/Pdelete.jsp" aria-label="subemnu">상품삭제</a></li>
					<li><a href="/views/admin/Pmanage.jsp" aria-label="subemnu">상품관리</a></li>
				</ul>
			</li>
			<li><a href="#">예약관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/Bmanage.jsp" aria-label="subemnu">예약내역</a></li>
					<li><a href="/views/admin/" aria-label="subemnu">예약완료</a></li>
					<li><a href="/views/admin/" aria-label="subemnu">예약수정</a></li>
					<li><a href="/views/admin/" aria-label="subemnu">예약취소</a></li>
				</ul>
			</li>
			<li><a href="#">매출관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/Smanage.jsp" aria-label="subemnu">매출내역</a></li>
				</ul>
			</li>
			<li><a href="#">회원관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/" aria-label="subemnu">회원수정</a></li>
					<li><a href="/views/admin/" aria-label="subemnu">회원탈퇴</a></li>
					<li><a href="/views/admin/Mmanage.jsp" aria-label="subemnu">회원내역</a></li>
				</ul>
			</li>
			<li><a href="#">문의관리</a>
				<ul id="sub-menu">
					<li><a href="/views/admin/Qmanage.jsp" aria-label="subemnu">문의내역</a></li>
					<li><a href="/views/admin/Qanswer.jsp" aria-label="subemnu">답변하기</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	<section>
		<h1>상품삭제</h1>
		<%
			for(int i = 0; i < list.size(); i++) {
		%>
		<form action="/admin/product/PdeleteProc" class="form__container" method="post" id="ckpoint">
			<div class="booking__Form">
				
				<div class="booking_img">
					<img src="/css/picture/owls.PNG" alt="">
					<%-- <%-<%=list.get(i).getProduct_image()%>  --%>
				</div>
				<div class="title__intro__container">
					<div class="booking__title">
						<h3>
							<%=list.get(i).getProduct_name()%> 
						</h3>
					</div>
					<div class="booking__intro">
						<p>
							<%=list.get(i).getProduct_detail()%>
						</p>
					</div>
				</div>
				<div class="booking__price">
					<p>
						<%=list.get(i).getProduct_price()%>
					</p>
				</div>
			</div>
		</form>
		<div class="booking__confirm">
			<button class="confirm__add" onclick="Pdelete()">
				상품삭제
			</button>
			<%
			}
			%>
		</div>
	</section>
</body>

</html>