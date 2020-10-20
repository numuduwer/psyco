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
	<!-- 나중에 히든 value 값변경  -->
	<form action="/psyco/menuSignupPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="shop_num" value="${shop_num}"/>
		<table>
			<tr>
				<td>메뉴 이름</td>
				<td><input type="text" name="menu_name"/></td>
			</tr>
			<tr>
				<td>메뉴 사진</td>
				<td><input type="file" name="menu_img"/></td>
			</tr>
			<tr>
				<td>메뉴 소개</td>
				<td><input type="text" name="content"/></td>
			</tr>
			<tr>
				<td>메뉴 가격</td>
				<td><input type="number" name="price"/></td>
			</tr>
			<tr>
				<td>메뉴 종류</td>
				<td>
					<select name="bigmenu" id="bigname" onchange="bigSelect(this.value);">
						<option value=0>선택</option>
						<option value=1>한식</option>
						<option value=2>양식</option>
						<option value=3>치킨</option>
						<option value=4>일식</option>
						<option value=5>분식</option>
						<option value=6>야식</option>
						<option value=7>중식</option>
					</select>
					<select id="midmenu" name="midmenu">
						<option value=0>선택</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>제철 음식</td>
				<td><input type="radio" name="season" value="0"/>없음</td>
				<td><input type="radio" name="season" value="1"/>여름</td>
				<td><input type="radio" name="season" value="2"/>겨울</td>
			</tr>
			<tr>
				<td>세트 여부</td>
				<td><input type="radio" name="sett" value="0"/>1인</td>
				<td><input type="radio" name="sett" value="1"/>세트</td>
			</tr>
			<tr>
				<td><input type="button" value="뒤로가기" onclick="goBack();"/></td>
				<td><input type="submit" value="등록하기"></td>
			</tr>
		</table>
		
	</form>

</body>
</html>