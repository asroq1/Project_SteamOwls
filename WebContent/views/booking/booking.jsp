<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%@page import="shop.steamowls.common.LoginManager"%>
<%
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
            <a href="/views/home/index.jsp">
              <img src="/css/picture/owls.PNG"alt="로고사진">
            </a>
        </div>
		<div class="header__signForm">
            <a href="/member/login">로그인</a>
        </div>
	</header>
    <section>
		<h1>판매상품내역</h1>
		<div class="form__container">
			<form action="/admin/product." class="booking__Form">
				<div class="booking_img">
					<img src="/css/picture/owls.PNG" alt="">
					<%-- <%=vo.getProduct_image()%> --%>
				</div>
				<div class="title__intro__container">
					<div class="booking__title">
						<h3>
							<%-- <%=vo.getProduct_name()%> --%>
						</h3>
					</div>
					<div class="booking__intro">
						<p>
							
							<%-- <%=vo.getProduct_detail()%> --%>
						</p>
					</div>
				</div>
				<div class="booking__price">
					<p>
						<%-- <%=vo.getProduct_price()%> --%>
					</p>
				</div>
			</div>
		</div>
			<button class="confirm__delete" onclick="location.href='/admin/booking/payment'">에약하기</button>
		</div>
	</section>
</body>

</html>