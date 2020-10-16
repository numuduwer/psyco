<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn1").click(function(){
				var pw = document.getElementById("pw").value;
				$.ajax({
					url: "/psyco/user/userPwCheck.com",
					type: "post",
					data: "pw=" + pw,
					dataType: "json",
					success: function(result){
						console.log(result.userType);
						if (result.userType == "social") {
							window.location.href='/psyco/user/modifySocialUserForm.com';
						} else if (result.userType == "normal") {
							window.location.href='/psyco/user/modifyNormalUserForm.com';
						}
					},
					error: function(){
						console.log('에러 발생');
					}
				});
			});	
		});
	
	</script>
</head>
<body>
	<div id="wrap">
		<h4>회원 정보 수정</h4>
		<input type="text" name="pw" id="pw" placeholder="비밀번호를 입력하세요">
		<input type="button" id="btn1" value="확인">
	</div>
</body>
</html>