<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사업자 등록 정보 입력</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#text1").focus();
			$("#checkBtn").click(function(){
				var text1 = $("#text1").val();
				var text2 = $("#text2").val();
				var text3 = $("#text3").val();
				var allData = {"text1" : text1, "text2" : text2, "text3" : text3};
				
				$.ajax({
					url : "/psyco/member/licenseLookup.com",
					type : "post",
					data : allData,
					dataType : "json",
					tranditional : true,	// 배열 및 리스트로 값을 넘기기 위해서는 꼭 선언되어야 함.
					success : function(data){
						alert(data.status);
						if (data.status == "부가가치세 일반과세자 입니다.") {
							$("#nextBtn").prop('disabled', false);
						} else {
							$("#nextBtn").prop('disabled', true);
						}
					},
					error : function() {
						alert('오류 관리자에게 문의하세요');
					}
				});
			});
		});
		
	</script>
</head>
<body>
	
	<script>
		function licenseNumber(){
			var license_number = document.getElementById("text1").value + "-" + document.getElementById("text2").value + "-" + document.getElementById("text3").value;
			window.location.href='/psyco/member/shopSignupForm.com?license_number=' + license_number;
		}
	</script>

	<div id="wrap">
		<form>
			<div class="group">
				<input type="text" name="text1" id="text1"> - <input type="text" name="text2" id="text2"> - <input type="text" name="text3" id="text3">
				<input type="button" value="유효성 검사"  id="checkBtn">
				<br />
				<span id="chkMsg"></span>
				<input type="button" id="nextBtn" value="다음" onclick="licenseNumber()" disabled>
			</div>
			
		</form>
	</div>
</body>
</html>