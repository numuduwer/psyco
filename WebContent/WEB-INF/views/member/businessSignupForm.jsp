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
			
			console.log(${sessionScope.memId});
			var license_number = document.getElementById("text1").value + "-" + document.getElementById("text2").value + "-" + document.getElementById("text3").value;
			
			window.location.href='/psyco/member/normalSignupForm.com?license_number=' + license_number;
		}
	</script>

	 <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>사업자 등록 확인 </h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle"> 가게 사업자 번호를 인증해주세요 </h2>
        </div>
    </div>
    <form class="form_box">
        <div class="group">
            <input class="form_input2" type="text" name="text1" id="text1"> - <input class="form_input2" type="text"
                name="text2" id="text2">
            - <input class="form_input2" type="text" name="text3" id="text3">
            <input type="button" value="사업자 중복확인" id="checkBtn">
            <br />
            <span id="chkMsg"></span>

            <ul class="form_btn_box">
                <li>
                    <input class=form_btn2 type="button" id="nextBtn" value="뒤로가기" onClick="history.go(-1);" >
                </li>
                <li>
                    <input class=form_btn2 type="button" id="nextBtn" value="다음으로" onclick="licenseNumber()">
                </li>
            </ul>

        </div>
  
    </form>
</body>
</html>