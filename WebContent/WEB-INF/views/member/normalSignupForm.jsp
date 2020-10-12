<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>일반 회원가입</title>
</head>
<body>
	<div id="wrap">
		<div>
			<form action="/psyco/member/signup.com" method="post">
				<input type="text" name="member_Id" placeholder="아이디를 입력" /> <br />
				<input type="password" name="pw" placeholder="비밀번호를 입력" /> <br />
				<input type="password" name="pw_confirm" placeholder="비밀번호 재입력" /> <br />
				<input type="text" name="name" placeholder="이름 입력" /> <br />
				<input type="date" name="birth" /> <br />
				<input type="text" name="phoneNum" placeholder="번호 입력" /> <br />
				<label for="male">남성</label>
				<input type="radio" name="gender" id="male" value="M" />
				<label for="female">여성</label>
				<input type="radio" name="gender" id="female" value="F" /> <br />
				<input type="text" name="nickname" placeholder="닉네임(활동 이름) 입력" /> <br />
				<input type="text" name="email" placeholder="이메일 입력" /> <br />
				<input type="submit" value="가입" />
				<input type="button" value="취소" onclick="history.go(-1)" />
			</form>
		</div>
	</div>
</body>
</html>