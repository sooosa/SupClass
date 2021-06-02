<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SupClass | 로그인</title>
</head>
<body>
	<!--session : 브라우져 가꺼지않는이상 브라우져를 계속가지고있다 -->
	<!-- POST로하는이유: 패스워드를 가리고 가기때문에 GET로하면 정보를 다보여주기 때문에  -->
	<!-- colspan:두개의 표를 하나로 합치겠다 -->
	<!-- submit :  -->
	<!-- 현재오류가는이유 는 주소받을 서블릿 만들지 않기때문에 -->
	<form action="MBLogin" method="POST">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mId"></td>
			</tr>

			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mPw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
				</td>

			</tr>

		</table>

	</form>
</body>
</html>