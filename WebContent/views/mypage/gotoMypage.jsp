<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/gotoMypage.css">
</head>
<body>
	<header>
		  <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
        <div class="info-container1">
            <div class="info-box">
                <h1>예약내역</h1>
                <ul>
                    <li>
                        <a href="/mypage/Bhistory">예약내역</a>
                    </li>
                </ul>
            </div>
            <div class="info-box">
                 <h1>회원정보</h1>
                 <ul>
                    <li>
                        <a href="/mypage/McheckPw">회원정보수정</a>
                    </li>
                    <li>
                       <!--  <a href="/mypage/Mwithdraw">회원탈퇴</a> -->
                    </li>
                </ul>
            </div>
        </div>
        <div class="info-container2">
            <div class="info-box">
                <h1>문의내역</h1>
                <ul>
                    <li>
                        <a href="/mypage/question">문의내역</a>
                    </li>
                </ul>
           </div>           
           <div class="info-box box-blur">
            <h1>포인트</h1>
            <ul>
                <li>
                    <a href="#">포인트 조회</a>
                </li>
                <li>
                    <a href="#">충전하기</a>
                </li>
            </ul>
       </div>           
        </div>
    </section>
</body>
</html>