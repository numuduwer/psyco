<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 선택 페이지</title>
</head>
<body>
	<!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>회원가입 </h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle">[1단계]일반 or 사업자 </h2>
        </div>
    </div>
	
	
	  <div class="form_box">
        <input class=select_tab type="button" value="일반 회원가입"
            onclick="window.location.href='/psyco/member/normalSignupForm.com'" />
        <br>
        <input class=select_tab type="button" value="사업자 회원가입"
            onclick="window.location.href='/psyco/member/businessSignupForm.com'" />
    </div>
</body>

</html>