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
.pageArea {
		width:400px;
		height:40px;
		padding:10px auto;
	}
	.pageList {
		width: 100px;
		height:30px;
		margin:10px auto;
	}
	.btnArea {
		width:70px;
		height:35px;
		margin:10px auto;
	}
	.pageList a {
		text-decoration:none;
		color:black;
	}
	.pageList a:hover, .pageList .pagecolor{
		text-decoration:underline;
		color:red;
	}
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
	
	<!-- 페이징 처리 하기 (이미지가 있으면 좋음) -->
	<div class="pageArea">
		<div class="pageList">
			<!-- "이전" 출력 -->
			<!-- startPage가 될 수 있는 값들은 1, 4, 7, 10,.... 인데 1만 아니면 이전에 출력 되어야함. -->
			<c:if test="${pv.startPage > 1 }">					<!-- 이전 클릭했을때 1,2,3 이 나와야함. startPage-blockPage(한 블록에 보여줄 페이지수) = currentPage-->
				<%-- <a href="main.do?currentPage=${pv.startPage-pv.blockPage}&searchKey=${pv.searchKey}&searchWord=${pv.searchWord}">이전</a> --%>
				<a href="main.do?currentPage=${pv.startPage - 1}">이전</a>
			</c:if>
	
			<!-- "페이지 번호" 출력(forEach 사용) -->
			<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
				<!-- 현재 페이지값을 넘기기. parameter명을 currentPage로 해야함 -->
				<%-- <span>
					<a class="pagecolor" href="main.do?currentPage=${i}">${i}</a></span> --%>
				<span>
					<c:url var="currPage" value="main.do">
						<c:param name="currentPage" value="${i}" />
<%-- 						<c:param name="searchKey" value="${pv.searchKey}" /> --%>
<%-- 						<c:param name="searchWord" value="${pv.searchWord}" /> --%>
					</c:url>
					<c:choose>
						<c:when test="${i==pv.currentPage}">    <!-- 현재 보고 있는 페이지의 번호에 css 적용 -->
							<a href="${currPage}" class="pagecolor">
								<c:out value="${i}" /></a>
						</c:when>
						<c:otherwise>
							<a href="${currPage}">
								<c:out value="${i}" /></a>
						</c:otherwise>
					</c:choose>
				</span>
			</c:forEach>
			<!-- 페이지 출력 끝 -->
	
			<!-- "다음" 출력 시작 -->
			<!-- endPage<totalPage 이면 보여줄께 있다.는 의미-->
			<c:if test="${pv.endPage < pv.totalPage}">
				<!-- 다음 클릭했을때 4가 나와야함. startPage(1)+blockPage(한 블록에 보여줄 페이지수, 3)-->
				<a href="main.do?currentPage=${pv.startPage+pv.blockPage}">다음</a>
			</c:if>
			<!-- 다음 출력 끝 -->
		</div>  <!-- end pageList -->
	</div>  <!-- end pageArea-->
		
	<div style="margin:auto; padding:auto;width:1000px; margin-top:20px">
		<a href="write.do">글쓰기</a>
	</div>
</body>
</html>