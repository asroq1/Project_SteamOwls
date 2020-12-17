<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<a href="/views/home/index.jsp"> <img src="/css/picture/owls.PNG"
			alt="로고사진">
		</a>
	</header>
	<section>
		<div class="login__form">
			<h1>로그인</h1>
			<form action="/admin/AloginProc" method="POST" id="ckpoint"
				onsubmit="retrun validateCheck()">
				<div class="login__id">
					<input type="text" placeholder="아이디" id="id" name="id"
						maxlength="10">
					<p class="id__text"></p>
				</div>
				<div class="login__pwd">
					<input type="password" placeholder="비밀번호" id="pw" name="pw"
						maxlength="10">
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