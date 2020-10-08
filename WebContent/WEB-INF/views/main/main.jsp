<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
</head>
<body>
	<c:if test="${sessionScope.memId != null}">
		<h3><c:out value="${sessionScope.memId}" /> 님 환영합니다.</h3>
		<input type="button" value="로그아웃" onclick="window.location.href='/psyco/member/logout.com'" />
	</c:if>
	<c:if test="${sessionScope.memId == null}">
		<input type="button" value="로그인" onclick="window.location.href='/psyco/member/loginForm.com'" /> <br />
		<input type="button" value="회원가입" onclick="window.location.href='/psyco/member/signupSelect.com'" />
	</c:if>
	<h1> 나는 메인이다.</h1>
	
</body>
</html>