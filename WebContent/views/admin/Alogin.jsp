<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>관리자 페이지</title>
	<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/admin/Alogin.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>

<body>

	<header>
		<a href="/"> 
			<img src="/css/picture/owlsLogo.png" alt="로고사진">
		</a>
	</header>
	<section>
		<div class="login__form">
			<h1>관리자 페이지</h1>
			<form action="/admin/admin/AloginProc" method="POST" id="ckpoint">
				<div class="login__id">
					<input type="text" placeholder="아이디" id="id" name="id" maxlength="10">
					<p class="id__text"></p>
				</div>
				<div class="login__pwd">
					<input type="password" placeholder="비밀번호" id="pw" name="pw" maxlength="10">
					<p class="pw__text"></p>
				</div>
			</form>
			<div class=login__submit>
				<button onclick="validateCheck()">로그인</button>
			</div>
		</div>
	</section>
	<script defer="defer" src="/js/admin/Alogin.js" type="text/javascript"></script>
</body>

</html>