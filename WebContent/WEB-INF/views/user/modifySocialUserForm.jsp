<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url: "/psyco/user/getMemberProfile.com",
				type: "post",
				dataType: "json",
				success: function(result){
					$('input#phoneNum').val(result.phoneNum);
					$('input#birth').val(result.birth);
				},
				error: function(){
					
				}
			});
			
			$('input#btn1').click(function(){
				var phoneNum = document.getElementById("phoneNum").value;
				var birth = document.getElementById('birth').value;
				
				$.ajax({
					url: "/psyco/user/modifySocialUserPro.com",
					type: "post",
					dataType: "json",
					data: {"phoneNum": phoneNum, "birth": birth},
					success: function(result){
						if (result.count == 1) {
							alert('수정 완료');
							window.location.href='/psyco/user/myPageList.com';
						} else if (result.count != 1){				
							alert('오류 발생 관리자 에게 문의하세요');
							window.location.href='/psyco/user/myPageList.com';
						}
					},
					erorr: function(){
						
					}
				})
			})
		});
			
	</script>
</head>
<body>
	<div class="wrap">
		<div id="content">
			<h3>정보 수정</h3>
		</div>
		<div id="formContent">
			<input type="text" id="phoneNum" name="phoneNum"> <br>
			<input type="date" name="birth" id="birth"> <br>
			<input type="button" id="btn1" value="수정">
		</div>
	</div>
</body>
</html>