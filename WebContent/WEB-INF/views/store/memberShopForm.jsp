<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script>
	function goBack(){ 
		window.history.back();
	}
</script>
<body>
	<form action="/psyco/memberShopPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value=1>
		<table>
			<tr>
				<td>�����̸�</td>
				<td><input type="text" name="shop_name"/></td>
			</tr>
			<tr>
				<td>���Թ�ȣ</td>
				<td><input type="text" name="shop_phone"/></td>
			</tr>
			<tr>
				<td>�����ð�</td>
				<td><input type="text" name="operating_time"/></td>
			</tr>
			<tr>
				<td>���� �ּ�</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>������</td>
				<td><input type="text" name="origin"/></td>
			</tr>
			<tr>
				<td>���� ����</td>
				<td><input type="text" name="takeout" value="1"/></td>
			</tr>
			<tr>
				<td>���� �̹���</td>
				<td><input type="file" name="shop_img"/></td>
			</tr>
			<tr>
				<td>����� ��ȣ</td>
				<td><input type="text" name="license_number"/></td>
			</tr>
			<input type="submit" value="�ۼ� �Ϸ�">
			<input type="button" value="�ڷΰ���" onclick="goBack();">
		</table>
	</form>

</body>
</html>