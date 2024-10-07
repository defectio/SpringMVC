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
	<a href="orderInsert.htm">글쓰기</a>
	<p>
		<!-- ${aList}:mav에서 정한 값 -->
		<!-- mav.addObject("aList", dao.selectMethod()); -->
		<c:choose>
			<c:when test="${!empty aList }">
				<c:forEach var="dto" items="${aList}">
				<c:forEach var="item" items="${dto.list}">
					<p>
						${item.id} / ${item.cnt} / ${item.remark} / ${dto.address}
					</p>
				</c:forEach>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>등록된 상품이 없습니다.</p>
			</c:otherwise>
		</c:choose>
			
	</p>
		
</body>
</html>