<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>가입 되었는지 알림만 띄워주는 페이지</title>
</head>
<body>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			alert('가입이 완료 되었습니다.');
			window.location.href='/psyco/main/main.com';
		</script>
	</c:if>
	<c:if test="${result != 1}">
		<script type="text/javascript">
			alert('오류 발생');
			window.location.href='psyco/main/main.com';
		</script>
	</c:if>
</body>
</html>