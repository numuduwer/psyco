<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>paymentTest</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			IMP.init('imp29075190');	
		})
		
		// 호출 전 db에 주문 정보를 전달하고 서버가 생성 한 주문 번호를 param의 merchant_uid 속성에 지정하기 
		function payment() {
			
			var buyer_name = document.getElementById("buyerName");
			var name = document.getElementById("name").value;
			
			// IMP.request_pay(param, callback) 호출
			IMP.request_pay({ // param
				pg: "html5_inicis",
				payment_method: "card",					
				merchant_uid: "psyco20201013-000004",	// 주문 번호, 한번 결제 완료된 주문번호는 다시 사용할 수 없는 듯
				name: name,
				amount: 100,
				buyer_email: "youngsson@gmail.com",
				buyer_name: buyer_name,
				buyer_tel: "010-4010-3153",
				buyer_addr: "서울특별시 광진구 화양동",
				buyer_postcode: "00308"
			}), function(response) {
				if (response.success) {
					
					$.ajax({
						url: "http://localhost:8080/psyco/member/paymentInsert.com",
						method: "post",
						headers: { "Content-Type": "application/json"},
						data: {
							imp_uid: response.imp_uid,	// imp_uid : 아임포트에서 부여하는 거래건 당 고유번호(sucess:false 일 때, 사전 validation에 실패한 경우라면 imp_uid는 null일 수 있음)
							merchant_uid: response.merchant_uid,
							paid_amount: response.paid_amount,
							apply_num: response.apply_num
						}
					}).done(function(data){
						// 가맹점 서버 결제 API 성공시 로직
						
					})
				} else {
					var msg = "결재가 실패하였습니다.";
					msg += '에러내용 :' + response.error_msg;
					console.log(msg);
				}
			}
		}
		
	</script>
</head>
<body>
	<form name="pgForm">
		<input type="text" id="name">
		<input type="hidden" name="BuyerName" id="BuyerName" value="홍길동">
		<input type="button" value="결제 테스트" onclick="javascript:payment()">
	</form>
</body>
</html>