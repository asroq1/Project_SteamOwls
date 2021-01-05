<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의관리</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
</head>
<body>
문의관리화면
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
회원 1의 문의글 <a href="/admin/question/Qanswer">답변</a>
</body>
</html>