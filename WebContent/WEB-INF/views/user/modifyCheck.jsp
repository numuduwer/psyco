<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수정 결과 체크 페이지</title>
</head>
<body>
	<c:if test="${count == 1}">
		<script>
			alert('수정 완료');
			window.location.href='/psyco/user/modifyInputPw.com';
		</script>
	</c:if>
	<c:if test="${count != 1}">
		<script>
			alert('오류 발새 관리자에게 문의하세요');
			history.go(-1);
		</script>
	</c:if>
</body>
</html>