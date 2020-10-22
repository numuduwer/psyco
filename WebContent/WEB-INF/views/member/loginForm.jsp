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
	    <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>로그인</h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle"> 일반 로그인 & 소셜 로그인 </h2>
        </div>
    </div>

    <div class="form_box">
        <form action="" class="form">
            <div class=form_tab>
                <label for="" class="form_title"> 아이디</label>
                <input type="text" class="form_input" />
            </div>
            <div class=form_tab>
                <label for="" class="form_title"> 회원가입</label>
                <input type="text" class="form_input" />
            </div>
            <div class=form_tab>
                <input type="checkbox" id="check" class="button">
                <label for="check">자동 로그인</label>
            </div>
            <div class=form_tab>
                <a href="/psyco/member/naverLoginPro.com"><img height="50"
                        src="http://static.nid.naver.com/oauth/small_g_in.PNG" /></a>
                <div class=form_tab>
                    <input type="button" class="form_btn" value="가입" />
                    <input type="button" class="form_btn" value="뒤로" />
                </div>
            </div>
        </form>
    </div>
</body>
</html>