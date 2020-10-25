<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 체크하는 페이지</title>
</head>
<body>
	<c:if test="${count == 0}">
		<script type="text/javascript">
			alert('아이디 또는 패스워드가 일치하지 않습니다.');
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${count == 1}">
		<script type="text/javascript">
			alert('로그인 완료');
			window.location.href='/psyco/main/main.com';
		</script>
		
	
	</c:if>
</body>
</html>