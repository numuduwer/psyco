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
        <ul class="shignupStep">
            <li>
                <div class="shignupStep_box_on">1. 가입유형 선택</div>
            </li>
            <li>
                <div class="shignupStep_box">2. 사업자등록 확인</div>
            </li>
            <li>
                <div class="shignupStep_box">3. 회원정보</div>
            </li>
            <li>
                <div class="shignupStep_box">4. 가게정보</div>
            </li>
        </ul>
        <div class="myPage_userTitle">
            <h3 class="myPage_subTitle"> 1. 가입유형 선택</h3>
        </div>
      
    </div>
	 <div class="form_box3">
        <div class="select_btn_step">
            <input class=select_tab2 type="button" value="일반 회원가입"
                onclick="window.location.href='/psyco/member/normalSignupForm.com'" />
            <br>
            <input class=select_tab2 type="button" value="사업자 회원가입"
                onclick="window.location.href='/psyco/member/businessSignupForm.com'" />

        </div>
    </div>
	
</body>

</html>