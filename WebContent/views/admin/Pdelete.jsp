<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
ProductVo productVo = (ProductVo) request.getAttribute("productVo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>

	<%
		if (list == null) {
	%>
	<h1>등록된 상품이 없습니다.</h1>
	<%
		} else {
	%>

	<section>
		<h1>상품삭제</h1>
		<form
			action="/admin/PdeleteProc?product_sq=<%=list.get(i).getProduct_sq()%>"
			class="form__container" method="post" id="ckpoint">
			<div class="booking__Form">

				<div class="booking_img">
					<%=list.get(i).getProduct_image()%>
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
		</form>
		<div class="booking__confirm">
			<button class="confirm__add" onclick="Pdelete()">상품삭제</button>
		</div>
	</section>
	<%
		}
	%>
	<%
		}
	%>
</body>

</html>