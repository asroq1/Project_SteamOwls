<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>예약관리</title>
    <link rel="stylesheet" href="/css/base.css">
</head>

<body>
    예약관리화면
    <header>
        <div class="header__logo">
            <a href="/views/home/index.jsp">
                <img src="/css/picture/owls.PNG" alt="로고사진">
            </a>
        </div>
        <div class="header__signForm">
            <a href="/admin/Alogout">로그아웃</a>
        </div>
    </header>
    <nav role="navigation">
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
    list1 <a href="/admin/booking/Bcancel">예약취소</a>
    <br>
    list2
</body>

</html>