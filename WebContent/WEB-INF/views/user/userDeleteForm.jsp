<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>유저 삭제</title>
	<script type="text/javascript">
		function request_delete() {
			var pw = document.getElementById("pw").value;
			$.ajax({
				url: "/psyco/user/userDeletePro.com",
				type: "post",
				data: "pw=" + pw,
				dataType: "json",
				success: function(data) {
					if (data.count == 1) {
						if (data.result == 1) {
							alert('삭제가 완료 되었습니다.');
							window.location.href='/psyco/user/myPageList.com';
						} else {
							alert('오류 발생. 관리자에게 문의하세요');
							window.location.href='/psyco/user/userDeleteForm.com';
						}
					} else if (data.count == 0) {
						alert('비밀번호가 일치하지 않습니다.');
						window.location.href='/psyco/user/userDeleteForm.com';
					}
				},
				error: function() {
					console.log('실패');
				}
			});
		}
	</script>
</head>
<body>
	<div id="wrap">
		<h4>회원 탈퇴</h4>
		<input type="text" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
		<input type="button" value="삭제" onclick="javascript:request_delete()">
	</div>
</body>
</html>