<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SupClass | 회원가입</title>
</head>
<body>

	<!-- action : 데이터를 가지고 이동할 주소 -->
	<!-- method : 데이터를 url(주소창)에 표시할건지(GET, 기본값) 안할건지(POST) -->
	<!-- enctype : 파일업로드를 위해 추가 -->
	<!-- <button onclick="location.href='MBjoin?mId=inchoriya'"></button> -->
	<form action="MBjoin" method="POST" enctype="multipart/form-data">
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
				<td>이름</td>
				<td><input type="text" name="mName"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="mBirth"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>남자<input type="radio" value="남자" name="mGender"> 
					여자<input type="radio" value="여자" name="mGender"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="mEmail"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="mFile"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입"> 
					<input type="reset" value="다시작성">
				</td>
			</tr>

		</table>
	</form>

</body>
</html>