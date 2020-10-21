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
		<script type="text/javascript">
			alert('수정이 완료되었습니다.');
			window.location='/psyco/shop/itemDetail.com?item_num=${item_num}';
		</script>
	</c:if>
	
	<c:if test="${result == 0}">
		<script type="text/javascript">
			alert('수정 오류입니다.');
			history.go(-1)
		</script>
	</c:if>

</body>
</html>