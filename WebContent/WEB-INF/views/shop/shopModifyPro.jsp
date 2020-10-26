<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수정 되었는지 알림만 띄워주는 페이지</title>
</head>
<body>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			alert('수정 성공 .');
			window.location.href='/psyco/shop/shopPageList.com?member_num=${sessionScope.memNum}';
		</script>
	</c:if>
	<c:if test="${result != 1}">
		<script type="text/javascript">
			alert('오류 발생');
			window.location.href='/psyco/shop/shopPageList.com?member_num=${sessionScope.memNum}';
		</script>
	</c:if>
</body>
</html>