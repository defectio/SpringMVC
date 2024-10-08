<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
body {margin:30px 0; padding: 0px;}
table { width:1000px; margin:auto;}
th, td {text-align : center;}
th {background-color: beige;}
</style>
</head>
<body>
	<table>
		<tr>
			<th style="width:5%;">글번호</th>
			<th style="width:5%;">작성자</th>
			<th style="width:20%;">제목</th>
			<th style="width:10%;">등록일</th>
			<th style="width:5%;">조회수</th>
		</tr>
		<c:choose>
			<c:when test="${!empty board}">
				<c:forEach items="${board }" var="board">
					<tr>
						<td>${board.num }</td>
						<td>${board.writer }</td>
						<td style="text-align:left;">
							<!-- 제목 클릭 시 조회페이지로 이동 -->
							<%-- <a onclick="location.href='view.do?num=${board.num }'" style="cursor:pointer;">${board.subject }</a> --%>
							<c:if test="${board.re_level!=0 }">  
								<!--스프링에서 css,js,img,xml...등 정적페이지는 바로 넣을 수 없음. -> web.xml에 추가해야함  -->
								<%-- <img alt="공백" src="images/level.gif" height="15" width="${board.re_level*20}">
								<img alt="공백" src="images/re.gif"> --%>
								<span style="height:15px; width:${board.re_level*20}px; display:inline-block;"></span> <!-- 들여쓰기 span -->
								<span>[답변] : </span>
							</c:if>
							<a href="view.do?num=${board.num }" style="cursor:pointer;">${board.subject }</a>
						</td>
						<td>${board.reg_date }</td>
						<td>${board.readcount }</td>	
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td rowspan="5">등록된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	
	<div style="margin:auto; padding:auto;width:1000px; margin-top:20px">
		<a href="write.do">글쓰기</a>
	</div>
</body>
</html>