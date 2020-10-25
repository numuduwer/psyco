<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			dataType: "json",
			success:function(result){
				colose.log(result);
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
	
			<form action="/psyco/member/menuSignupPro.com?member_num=${member_num}&shop_num=${shop_num}" class="form"  method="post" enctype="multipart/form-data">
                 	<input type="hidden" name="shop_num" value="${shop_num}"/>
            <div class=form_tab>
                <label for="" class="form_title"> 메뉴 이름</label>
                <input class="form_input" type="text" name="menu_name" />
            </div>
            <div class=form_tab>
                <label for="" class="form_title"> 메뉴 사진</label>
                <input class="form_input" type="file" name="menu_img" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">메뉴 가격</label>
                <input class="form_input" type="text" name="price" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">세트 여부</label>
                <input  type="radio" name="sett" value="0"/>1인
				<input  type="radio" name="sett" value="1"/>세트
            </div>

            <div class=form_tab>
                <label for="" class="form_title">제철 음식</label>
                <td><input type="radio" name="season" value="0"/>없음</td>
				<td><input type="radio" name="season" value="1"/>여름</td>
				<td><input type="radio" name="season" value="2"/>겨울</td>
            </div>

            <div class=form_tab>
                <label for="" class="form_title">메뉴 소개</label>
                <input class="form_input" type="text" name="content" />
            </div>


            <ul class="form_btn_box">
                <li>
                    <input class=form_btn2 type="button" value="뒤로가기" onclick="goBack();" >
                </li>
                <li>
                    <input class=form_btn2 type="submit" id="nextBtn" value="등록하기"/>
                </li>
                <li>
                    <input class=form_btn2 type="button" id="nextBtn" value="완료하기" onclick="location.href='/psyco/shop/shopPageList.com?member_num=${member_num}&shop_num=${shop_num}'" >
                </li>
            </ul>

            </form>
	</div>
	

</body>
</html>