<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>소셜 회원가입</title>
	
</head>
<body>
	<div class="wrap">
		<div id="content">
			<h3>추가 정보 입력</h3>
		</div>
		<div id="formContent">
			<form action="/psyco/member/signup.com" method="post">
				<input type="hidden" name="name" value="${memberProfile.name}" />
				<input type="hidden" name="gender" value="${memberProfile.gender}" />
				<input type="hidden" name="nickname" value="${memberProfile.nickname}" />
				<input type="hidden" name="email" value="${memberProfile.email}" />
				<input type="text" name="member_Id" placeholder="아이디를 입력하세요" /> <br>
				<input type="text" name="phoneNum" placeholder="휴대전화 번호를 입력하세요" /> 
				
				<br>
				<input type="date" name="birth" /> <br>
				<input type="submit" value="회원가입" />
			</form>
		</div>
	</div>
</body>
</html>