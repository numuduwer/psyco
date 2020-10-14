<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Maps 테스트</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bsd4urkj6r"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=bsd4urkj6r&submodules=geocoder"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn1").click(function() {
				var query = { query : $("#address").val() };
				console.log(query);
				
				naver.maps.Service.geocode(query, function(status, response) {
					if (status !== naver.maps.Service.Status.OK) {
						return alert('Something wrong!');
					}
					
					var v2 = response.v2,
						addresses = v2.addresses;
					
					console.log(addresses);
					
					var latitude = addresses[0].y,		// ex : 37.5438733
						longitude = addresses[0].x;	// ex : 127.0681978
					
					var changeMap = mapCreate(latitude, longitude);
					changeMap.setZoom(17, true);
					var marker = new naver.maps.Marker({
						position: new naver.maps.LatLng(latitude, longitude),
						map: changeMap
					});
				});
			});
		});
		
		function mapCreate(latitude, longitude) {
			if (typeof latitude == "undefined" || latitude == null || latitude == "") {
				latitude = 37.3595704;
				longitude = 127.105399;
			}
			
			var mapOptions = {
					center: new naver.maps.LatLng(latitude, longitude),
					zoom: 10
			};
			
			var map = new naver.maps.Map('map', mapOptions);
			return map;
		}
	</script>
</head>
<body>
	<div id="map" style="width:100%;height:400px;">
		<script>
			mapCreate();
		</script>
	</div>
	<div id="search">
		<label for="address">이건 지도검색임</label>
		<input type="text" name="address" id="address" />
		<input type="button" id="btn1" value="검색" />
	</div>
</body>
</html>