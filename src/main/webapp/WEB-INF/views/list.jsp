<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px 10px;
	}
</style>
</head>
<body>
<div>
	안녕하세요 ${sessionScope.loginId} 님
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="logout">로그아웃</a>  
</div>
	<h3>회원리스트</h3>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>gender</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td>${member.id}</td>
				<td><a href="detail?id=${member.id}">${member.name}</a></td>
				<td>${member.gender}</td>
				<td><a href="del?id=${member.id}">삭제</a></td>
			</tr>		
		</c:forEach>
	</table>
</body>
<script>
var msg = "${msg}";
if(msg != ""){
	alert(msg);
}
</script>
</html>