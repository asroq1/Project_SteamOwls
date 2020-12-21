<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>예약</title>
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
        <div class="booking__Form">
            <div class="booking_img">
                <%-- <%=vo.getProduct_image()%> --%>
            </div>
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
            <div class="booking__price">
                <p>
                    <%-- <%=vo.getProduct_price()%> --%>
                </p>
            </div>
        </div>
        <a href="/booking/payment">결제하기</a>
    </section>
</body>

</html>