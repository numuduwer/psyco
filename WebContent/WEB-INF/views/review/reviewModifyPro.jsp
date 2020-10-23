<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 모디</title>
</head>

<body>
	<c:if test="${result == 1}">
		<script>
			alert("수정완료");
			window.location.href='/psyco/user/reviewDetail.com?review_num=${review_num}&pageNum=${pageNum}';
		</script>		
	</c:if>
	<c:if test="${result != 1}">
		<script type="text/javascript">
			alert('오류 발생');
			window.location.href='/psyco/user/reviewDetail.com?review_num=${review_num}&pageNum=${pageNum}';
		</script>
	</c:if>


</body>
</html>