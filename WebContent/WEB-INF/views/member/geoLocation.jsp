<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>geoLocation API</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bsd4urkj6r"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=bsd4urkj6r&submodules=geocoder"></script>
	<script type="text/javascript">
	
		function mapCreate(latitude, longitude) {
			var mapOptions = {
					center: new naver.maps.LatLng(latitude, longitude),
					zoom: 10,
					mapTypeId: naver.maps.MapTypeId.NORMAL
			}
			
			var map = new naver.maps.Map('map', mapOptions);
			return map;
		}
		
		function onSuccessGeolocation(position) {
		    var location = new naver.maps.LatLng(position.coords.latitude,
		                                         position.coords.longitude);
		    
		    console.log("latitude :" + position.coords.latitude);
		    console.log("longitude: " + position.coords.longitude);
			
		    var map = mapCreate(position.coords.latitude, position.coords.longitude);
		    
		    map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
		    map.setZoom(17); // 지도의 줌 레벨을 변경합니다.
		    
		    var infowindow = new naver.maps.InfoWindow();
	
		    infowindow.setContent('<div style="padding:20px;">' + 'geolocation.getCurrentPosition() 위치' + '</div>');
	
		    infowindow.open(map, location);
		    console.log('Coordinates: ' + location.toString());
		    
		    reverseGeocode(position.coords.latitude, position.coords.longitude);
		     
		}
	
		function onErrorGeolocation() {
		    var center = map.getCenter();
	
		    infowindow.setContent('<div style="padding:20px;">' +
		        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');
	
		    infowindow.open(map, center);
		}
		
		function geocode() {
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
					longitude = addresses[0].x;		// ex : 127.0681978
				
				var changeMap = mapCreate(latitude, longitude);
				changeMap.setZoom(17, true);
				var marker = new naver.maps.Marker({
					position: new naver.maps.LatLng(latitude, longitude),
					map: changeMap
				});
			});
		}
		
		function reverseGeocode(latitude, longitude) {
			naver.maps.Service.reverseGeocode({
		        coords: new naver.maps.LatLng(latitude, longitude),
		    }, function(status, response) {
		        if (status !== naver.maps.Service.Status.OK) {
		            return alert('Something wrong!');
		        }

		        var result = response.v2, // 검색 결과의 컨테이너
		            items = result.results, // 검색 결과의 배열
		            address = result.address; // 검색 결과로 만든 주소

		        document.getElementById('address').value = address.jibunAddress;
		    });
		}
		
		function locationSetting() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
			} else {
				var center = map.getCenter();
		        infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
		        infowindow.open(map, center);
			}
		}
	</script>
</head>
<body>
	<div id="map" style="width:100%;height:500px;">
		<script>
			//mapCreate();
		</script>
	</div>
	<div>
		<input type="button" value="현재 위치 설정" onclick="javascript:locationSetting();"/>
		<input type="text" name="address" id="address">
		<input type="button" value="검색" onclick="javascript:geocode();">
	</div>
</body>
</html>