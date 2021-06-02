<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SupClass | 글쓰기</title>
</head>
<body>

	<!-- action : 데이터를 가지고 이동할 주소 -->
	<!-- method : 데이터를 url(주소창)에 표시할건지(GET, 기본값) 안할건지(POST) -->
	<!-- enctype : 파일업로드를 위해 추가 -->
	<!-- <button onclick="location.href='MBjoin?mId=inchoriya'"></button> -->
	<form action="BMWrite" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>작성자</td>
				<td>${sessionScope.loginId} <input type="hidden" name="bId" value="${sessionScope.loginId}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="15" cols="20" name="bContent"></textarea></td>
			</tr>
			
			<tr>
				<td>파일</td>
				<td><input type="file" name="bFile"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성"> 
				</td>
			</tr>

		</table>
	</form>

</body>
</html>

