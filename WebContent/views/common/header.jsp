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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
		<div class="desktop__header">
			<a href="/">
			<img src="/css/picture/owlsLogo.png" alt="로고사진">
		</a>
		<ul class="header__form">
			<li><a href="/member/login">로그인</a></li>
			<li><a href="/member/signup">회원가입</a></li>
			<li><a href="/admin">관리자</a></li>
		</ul>
		</div>
	
	 
	<div class="mobile__header">
		<a href="/">
			<img src="/css/picture/owlsLogo.png" alt="로고사진">
		</a>
			<span class="toggle_btn">
				<span class="line"></span>
				<span class="line"></span>
				<span class="line"></span>
			</span>
			<ul class="toggle_bar">
				<li><a href="/member/login">로그인</a></li>
				<li><a href="/member/signup">회원가입</a></li>
				<li><a href="/admin">관리자</a></li>
			</ul>
	</div>
</body>
</html>