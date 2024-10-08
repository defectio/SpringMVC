<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$("#btnList").on('click', btnListProcess);
	$("#btnUpdate").on('click', btnUpdateProcess);
});

//목록으로
function btnListProcess(){
	//alert("back to list btn clicked");
	$('#frm').attr('action', 'main.do');
	$('#frm').attr('method', 'get');
	$('#frm').submit();
}

//수정하기 버튼 클릭 -> DB에 update
function btnUpdateProcess(){
	//alert("수정 버튼 클릭");
	//제목, 내용 변경사항을 컨트롤러에 전달
	$('#frm').attr('action', 'update.do');
	$('#frm').submit();
}
</script>
</head>
<body>
	<form name="frm" id="frm" method="post">
		<table border="1">
			<tr>
				<td width="20%" align="center">글쓴이</td>
				<td>
					<!-- readOnly : form 전송 가능 / disabled : form 전송 불가능 -->
					<%-- <input type="text" name="writer" value="${board.writer }" readOnly /> --%>
					${board.writer }
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">이메일</td>
				<td>
					<%-- <input type="text" name="writer" value="${board.email }" readOnly /> --%>
					${board.email }
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">조회수</td>
				<td>${board.readcount }</td>
			</tr>
			<tr>
				<td width="20%" align="center">글제목</td>
				<td>
					<input type="text" name="subject" value="${board.subject }">
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">내용</td>
				<td>
					<textarea name="content" rows="13" cols="40">${board.content }</textarea>
				</td>
			</tr>
		</table>
		
		<input type="button" id="btnList" value="목록으로">
		<input type="button" id="btnUpdate" value="수정하기">
		num : <input type="text" name="num" value="${board.num }">
	</form>
	<!-- <input type="button" id="btnSave" value="저장"> -->
</body>
</html>