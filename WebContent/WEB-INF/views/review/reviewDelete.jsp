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
	<c:if test="${res ne 'null'}">
		<script>
			alert("삭제완료");
			window.location.href='/psyco/user/myPageList.com?pageNum=${pageNum}';
		</script>		
	</c:if>
	<c:if test="${res eq 'null'}">
		<script type="text/javascript">
			alert('오류 발생');
			window.location.href='/psyco/user/myPageList.com?pageNum=${pageNum}';
		</script>
	</c:if>

</body>
</html>