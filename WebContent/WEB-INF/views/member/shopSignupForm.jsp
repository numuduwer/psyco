<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function goBack(){
		window.history.back();
	}
</script>
<body>

    <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>가게 등록 </h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle"> [2단계]가게 정보를 입력해 주세요. </h2>
        </div>
    </div>
    
<!-- 히든값 value member_num으로 나중에 수정  -->
<<<<<<< HEAD
<<<<<<< HEAD:WebContent/WEB-INF/views/store/shopSignupForm.jsp
	<form action="/psyco/shopSignupPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value="${member_num}">
=======
	<form action="/psyco/member/shopSignupPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value=2>
>>>>>>> 9bb5c41c0db0b336ed6c754e870748b95e449c5e:WebContent/WEB-INF/views/member/shopSignupForm.jsp
		<table>
			<tr>
				<td>가게이름</td>
				<td><input type="text" name="shop_name"/></td>
			</tr>
			<tr>
				<td>가게번호</td>
				<td><input type="text" name="shop_phone"/></td>
			</tr>
			<tr>
				<td>영업시간</td>
				<td><input type="text" name="operating_time"/></td>
			</tr>
			<tr>
				<td>가게 주소</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>원산지</td>
				<td><input type="text" name="origin"/></td>
			</tr>
			<tr>
				<td>포장 여부</td>
				<td><input type="checkbox" name="takeout" value="1"/></td>
			</tr>
			<tr>
				<td>가게 이미지</td>
				<td><input type="file" name="shop_img"/></td>
			</tr>
			<tr>
				<td>사업자 번호</td>
				<td><input type="text" name="license_number" value="${license_number}" readonly/></td>
			</tr>
			<tr>
				<td><input type="button" value="뒤로가기" onclick="goBack();"></td>
				<td><input type="submit" value="다음"></td>
			</tr>
		</table>
	</form>
=======
>>>>>>> 439a0ceef5cbd13a356220fca0522ec61d32dffb

    <div class="form_box">

        <form  class="form" action="/psyco/member/shopSignupPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value=91>
            <div class=form_tab>
                <label for="" class="form_title"> 가게이름</label>
                <input class="form_input" type="text" name="shop_name" />
            </div>
            <div class=form_tab>
                <label for="" class="form_title"> 가게번호</label>
                <input class="form_input" type="text" name="shop_phone" />
            </div>
            <div class=form_tab>
                <label for="" class="form_title"> 영업시간</label>
                <input class="form_input" type="text" name="operating_time" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">가게 주소</label>
                <input class="form_input" type="text" name="address" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">원산지</label>
                <input class="form_input" type="text" name="origin" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">포장여부</label>
                <input type="checkbox" name="takeout" value="1" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">가게이미지</label>
                <input type="file" name="shop_img" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">사업자 번호</label>
                 <input type="text" name="license_number" />
             <!--     <input type="text" name="license_number" value="${license_number}" readonly />-->
            </div>

            <ul class="form_btn_box">
                <li>
                    <input class=form_btn2 type="button" value="뒤로가기" onClick="history.go(-1);" >
                </li>
                <li>
                    <input class=form_btn2 type="submit" id="nextBtn" value="다음으로">
                </li>
            </ul>
</form>
</div>

	
</body>
</html>