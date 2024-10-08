<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//alert("this document is ready");
	$("#btnList").on('click', btnListProcess);
	$('#btnUpdate').on('click', btnUpdateProcess);
	$('#btnDelete').on('click', btnDeleteProcess);
	$('#btnReply').on('click', btnReplyProcess);
});

//목록으로
function btnListProcess(){
	$('#frm').attr('action', 'main.do');
	$('#frm').attr('method', 'get');
	$('#frm').submit();
}
//수정하기
function btnUpdateProcess(){
	$('#frm').attr('action', 'update.do');
	$('#frm').submit();
}
//게시글 삭제
function btnDeleteProcess(){
	//alert("삭제 클릭");
	$('#frm').attr('action', 'delete.do');
	$('#frm').submit();
}
function btnReplyProcess(){
	alert("답변 클릭");
	$('#frm').attr('action', 'write.do');
	$('#frm').submit();
}
</script>
</head>
<body>
	<table border="1">
		<tr>
			<td width="20%" align="center">글쓴이</td>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<td width="20%" align="center">이메일</td>
			<td>${board.email }</td>
		</tr>
		<tr>
			<td width="20%" align="center">조회수</td>
			<td>${board.readcount }</td>
		</tr>
		<tr>
			<td width="20%" align="center">글제목</td>
			<td>${board.subject }</td>
		</tr>
		<tr>
			<td width="20%" align="center">내용</td>
			<td>
				<textarea name="content" rows="13" cols="40">${board.content }</textarea>
			</td>
		</tr>
	</table>
		
	<form name="frm" id="frm">
		num : <input type="text" name="num" value="${board.num }">
		ref : <input type="text" name="ref" value="${board.ref }">
		re_step : <input type="text" name="re_step" value="${board.re_step }">
		re_level : <input type="text" name="re_level" value="${board.re_level }">
		<input type="button" id="btnList" value="목록으로">
		<input type="button" id="btnUpdate" value="수정하기">
		<input type="button" id="btnDelete" value="삭제하기">
		<input type="button" id="btnReply" value="답변하기">
	</form>
	<!-- <input type="button" id="btnSave" value="저장"> -->
</body>
</html>