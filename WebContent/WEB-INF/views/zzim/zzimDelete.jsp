<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript">

	function closeWin() {
		var nvua = navigator.userAgent;
		if (nvua.indexOf('MSIE') >= 0){
			if(nvua.indexOf('MSIE 5.0') == -1) {
			top.opener = '';
			}
		} else if (nvua.indexOf('Gecko') >= 0){
			top.name = 'CLOSE_WINDOW';
			wid = window.open('','CLOSE_WINDOW');
			}
		top.close();
	}
	
</script>

<body>
		<button><a href="/psyco/user/zzimDeletePro.com?zzim_num=${zzim_num}">삭제하기</a></button>
		<button><a href="#" onclick="javascript:self.close()">취소</a></button>
</body>
</html>