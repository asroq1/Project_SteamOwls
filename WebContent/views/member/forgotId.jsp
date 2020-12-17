<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 찾기</title>
<link rel="stylesheet" href="/css/base.css" type="text/css"></link>
<link rel="stylesheet" href="/css/member/forgotId.css" type="text/css"></link>
</head>

<body>
	<header> 
			<a href="/views/home/index.jsp">
                <img src="/css/picture/owls.PNG" alt="로고사진">
            </a>
			<a href="/member/login" class="signForm">로그인</a>
	</header>
	<section>
		<div class="findId__form">
			<h3>아이디 찾기</h3>
			<form action="/member/forgotIdProc" method="post" id="ckpoint">
				<div class="findId__name">
					<input type="text" placeholder="이름" id="name" name="name">
				</div>
				<div class="findId__tel">
					<input type="tel" placeholder="전화번호" id="tel" name="tel">
				</div>
				<div>
					<button id="findId__btn">
						<p>찾기</p>
					</button>
				</div>
			</form>

        </div>
    </section>
    <script defer="defer" src="/js/member/forgotId.js" type="text/javascript"></script>
</body>

</html>