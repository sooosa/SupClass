<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SupClass | 회원목록</title>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}
.td1{
	background-color:blue;
}

.td2{
	background-color:red;
}

</style>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>상세조회</th>
			<th>회원탈퇴</th>
		</tr>
			
		<c:forEach var="member" items="${memberlist}">
			<tr>
			<td>${member.mId}</td>
			<td class="td1">${member.mName}</td>
			<td class="td2">${member.mGender}</td>
			<td><button onclick="location.href='MBview?mId=${member.mId}'">조회</button></td>
			<td><button onclick="location.href='MBdelete?mId=${member.mId}'">탈퇴</button></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>