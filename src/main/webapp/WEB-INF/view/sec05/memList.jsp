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
	<p><a href="memInsert.htm">글쓰기</a></p>
	
	<c:forEach var="mem" items="${aList}">
		<p>${mem.num } / ${mem.name } / ${mem.age } / ${mem.loc }</p>
	</c:forEach>

</body>
</html>