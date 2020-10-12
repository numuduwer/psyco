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
		}
	
		function onErrorGeolocation() {
		    var center = map.getCenter();
	
		    infowindow.setContent('<div style="padding:20px;">' +
		        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');
	
		    infowindow.open(map, center);
		}
		
		
		$(document).ready(function(){
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
			} else {
				var center = map.getCenter();
		        infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
		        infowindow.open(map, center);
			}
		})
	
	</script>
</head>
<body>
	<div id="map" style="width:100%;height:500px;">
		<script>
			mapCreate();
		</script>
	</div>
</body>
</html>