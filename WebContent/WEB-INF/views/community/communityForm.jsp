<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
		<h1 align="center"> 글 작성  </h1>
		<form action="/spring/board/writePro.git" method="post">
			<input type="hidden" name="num" value= "${num}"/>
			<input type="hidden" name="ref" value= "${ref}"/>
			<input type="hidden" name="re_step" value= "${re_step}"/>
			<input type="hidden" name="re_level" value= "${re_level}"/>
		
		
		
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${sessionScope.memId}"></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td>
						<input type="text" name="subject"/>				
				</td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="70" name="content"></textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" /> 
					<input type="reset" value="재작성" />
					<input type="button" value="리스트보기"  onclick="window.location='/spring/board/list.git'"/>
				</td>
			</tr>
		</table>
	</form>




</body>
</html>