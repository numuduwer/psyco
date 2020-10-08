<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 선택 페이지</title>
</head>
<body>
	<div id="wrap">
		<div>
			<input type="button" value="일반 회원가입" onclick="window.location.href='/psyco/member/normalSignupForm.com'" /> <br />
			<input type="button" value="사업자 회원가입" onclick="window.location.href='/psyco/member/businessSignupForm.com'" />
		</div>
	</div>
</body>
</html>