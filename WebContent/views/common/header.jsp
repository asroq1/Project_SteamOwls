<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<script src="/js/common/c_header.js" type="text/javascript" defer></script>
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
	<a href="/">
			<img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<button class="toggle_btn">
				<i class="fas fa-bars"></i>
			</button>
			<ul class="toggle_bar">
				<li>
					<button class="bar_btn" onclick="location.href='/member/login'">로그인</button>
				</li>
				<li>
					<button class="bar_btn" onclick="location.href='/member/signup'">회원가입 </button>
				</li>
				<li>
					<button class="bar_btn" onclick="location.href='/admin'">관리자</button>
				</li>
			</ul>
		</ul>
</body>
</html>