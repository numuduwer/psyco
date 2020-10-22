<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>일반 회원가입</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			IMP.init('imp29075190');
		})
	
		function execDaumPostCode() {
			new daum.Postcode({
				/*
				oncomplete : 우편번호 검색 결과 목록에서 특정 항목을 클릭한 경우, 해당 정보를 받아서 처리할 콜백 함수를 정의하는 부분 (null값 또는 정의하지 않을 시 검색은 가능하지만, 결과 항목을 클릭하면 아무일도 일어나지 않음)
						이 함수를 정의할 때 넣는 인자에는 우편번호 검색 결과 목록에서 사용자가 클릭한 주소 정보가 들어가게 됨
				*/
				oncomplete: function(data) {
					// 팝업에서 검색결과 항목을 클릭했을 때 실행할 코드를 작성하는 부분
					
					// 도로명 주소의 노출 규칙에 따라 주소를 표시
					// 내려오는 변수가 값이 없는 경우에는 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var roadAddr = data.roadAddress;
					var extraRoadAddr = '';
					
					// 법정동 명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postcode').value = data.zonecode;
					document.getElementById('roadAddress').value = roadAddr;
					document.getElementById('jibunAddress').value = data.jibunAddress;
					
					// 참고 항목 문자열이 있을 경우 해당 필드에 넣는다.
					if (roadAddr !== '') {
						document.getElementById('extraAddress').value = extraRoadAddr;
					} else {
						document.getElementById('extraAddress').value = '';
					}
					
					var guideTextBox = document.getElementById('guide');
					// 사용자가 '선택 안함' 을 클릭한 경우, 예상 주소라는 표시를 해준다.
					if (data.autoRoadAddress) {
						var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
						guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
						guideTextBox.style.display = 'block';
					} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						guideTextBox.innerHTML = '(예상 지번 주소 :' + expJibunAddr + ')';
						guideTextBox.style.display = 'block';
					} else {
						guideTextBox.innerHTML = '';
						guideTextBox.style.display = 'none';
					}
				}
			}).open();
		}
		
	</script>
</head>
<body>
	<c:if test="${param.license_number != null}">
		<div>
			사업자 번호 : <c:out value="${param.license_number}"></c:out>
		</div>
	</c:if>
	<div class="form_box">


        <div>
            <form action="/psyco/member/signup.com" method="post" class="form">
                <input class="form_input" type="hidden" name="license_number" value="${param.license_number}">
                <div class=form_tab>
                    <label for="" class="form_title"> 아이디</label>
                    <input class="form_input" type="text" name="member_Id" placeholder="아이디를 입력" />
                </div>
                <div class=form_tab>
                    <label for="" class="form_title"> 비밀번호</label>
                    <input class="form_input" type="password" name="pw" placeholder="비밀번호를 입력" />
                </div>
                <div class=form_tab>
                    <label for="" class="form_title"> 비밀번호 확인</label>
                    <input class="form_input" type="password" name="pw_confirm" placeholder="비밀번호 재입력" />
                </div>

                <div class=form_tab>
                    <label for="" class="form_title">이름</label>
                    <input class="form_input" type="text" name="name" placeholder="이름 입력" />
                </div>
                <div class=form_tab>
                    <label for="" class="form_title">생년월일</label>
                    <input class="form_input" type="date" name="birth" />
                </div>
                <div class=form_tab>
                    <label for="" class="form_title">핸드폰</label>
                    <input class="form_input" type="text" name="phoneNum" placeholder="번호 입력" />
                </div>
                <div class="form_male_tab">
                    <label for="male">남성</label>
                    <input class="form_checkbox" type="radio" name="gender" id="male" value="M" />
                    <label for="female">여성</label>
                    <input class="form_checkbox" type="radio" name="gender" id="female" value="F" />
                </div>
                <div class=form_tab>
                    <label for="" class="form_title">닉네임</label>
                    <input class="form_input" type="text" name="nickname" placeholder="닉네임(활동 이름) 입력" />
                </div>
                <div class=form_tab>
                    <label for="" class="form_title">E-mail</label>
                    <input class="form_input" type="text" name="email" placeholder="이메일 입력" />
                </div>

                <div class=form_tab>
                    <input class="form_input" type="text" id="postcode" placeholder="우편번호">
                    <input class="form_postbtn" type="button" id="btn1" onclick="execDaumPostCode()" value="우편번호 찾기">
                </div>

                <div class=form_tab>
                    <label for="" class="form_title">지번주소</label>
                    <input class="form_input" type="text" id="jibunAddress" placeholder="지번주소">
                </div>
                <div class=form_tab>
                    <label for="" class="form_title">도로명주소</label>
                    <input class="form_input" type="text" id="roadAddress" placeholder="도로명주소">
                </div>
                <div class=form_tab>
                    <label for="" class="form_title">싱세주소</label>
                    <input class="form_input" type="text" id="detailAddress" placeholder="상세주소">
                </div>



                <div class=form_tab>
                    <input type="submit" value="가입" class="form_btn" />
                    <input type="button" value="취소" onclick="history.go(-1) " class="form_btn" />
                </div>

            </form>
        </div>
    </div>
	
</body>
</html>