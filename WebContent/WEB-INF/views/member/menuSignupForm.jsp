<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Form</title>
</head>
<script type="text/javascript"></script>
<script>
	function goBack(){ 
		window.history.back();
	}
	function bigSelect(val){
		console.log(typeof(val));
		$.ajax({
			url:"ajaxMenuSelect.com?bigname="+val,
			type:"get",
			success:function(result){
			$("#midmenu").find("option").remove().end().append("<option value=0>선택</option>");	
			$.each(result, function(i){
				$("#midmenu").append("<option value='"+result[i]+"'>"+result[i]+"</option>")
			});
			},
			error: function(jqXHR,textStatus,errorThrown){
				alert("오류발생");
			}
		}); 
	}
</script>
<body>

 <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>메뉴 등록 </h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle"> [3단계 ]메뉴 등록  </h2>
        </div>
    </div>
	
	<div class="form_box">
	
			<form action="/psyco/menuSignupPro.com" class="form"  method="post" enctype="multipart/form-data">
                 	<input type="hidden" name="shop_num" value=2/>
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
                <td><input type="text" name="license_number" value="${license_number}" readonly />
            </div>

            <ul class="form_btn_box">
                <li>
                    <input class=form_btn2 type="button" value="뒤로가기" onclick="licenseNumber()" disabled>
                </li>
                <li>
                    <input class=form_btn2 type="submit" id="nextBtn" value="다음으로" onclick="licenseNumber()" disabled>
                </li>
            </ul>



            <input type="button" value="뒤로가기" onclick="goBack();">
            <input type="submit" value="다음">
            </form>
	</div>
	

</body>
</html>