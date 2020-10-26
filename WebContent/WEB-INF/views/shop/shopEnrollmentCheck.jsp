<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:if test="${result == 1}">
		<script>
			alert('등록이 완료 되었습니다.');
			window.location.href='/psyco/shop/shopPageList.com?member_num=' + ${member_num};
		</script>
	</c:if>
	<c:if test="${result == 0}">
		<script>
			alert('오류 발생 관리자에게 문의하세요');
			window.location.href='/psyco/shop/shopPageList.com?member_num=' + ${member_num};
		</script>
	</c:if>

</body>
</html>