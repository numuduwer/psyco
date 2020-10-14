<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginForm</title>
	<style type="text/css">
		.login-wrap {
			width: 100%;
			margin: auto;
			max-width: 525px;
			min-height: 670px;
			position: relative;
		}
		
		.login-html {
			width: 100%;
			height: 100%;
			position: absolute;
			padding: 90px 70px 50px 70px;
			background: rgba(40, 57, 101, .9);
		}
		
	</style>
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
			<input type="radio" id="tab-1" name="tab" class="sign-in" checked><label for="tab-1">로그인</label>
			<input type="radio" id="tab-2" name="tab" class="sign-up"><label for="tab-2">회원가입</label>
			<div class="login-form">
				<form action="/psyco/member/loginCheck.com" method="post">
					<div class="sign-in-htm">
						<div class="group">
							<label for="user" class="label">아이디</label>
							<input type="text" name="member_Id" id="member_Id" class="input">
						</div>
						<div class="group">
							<label for="passwd" class="label">패스워드</label>
							<input type="password" name="pw" id="pw" class="input">
						</div>
						<div class="group">
							<input type="checkbox" id="check" class="button">
							<label for="check">자동 로그인</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="로그인">
						</div>
						<div class="group">
							<a href="/psyco/member/naverLoginPro.com"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
						</div>
						<div class="hr"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>