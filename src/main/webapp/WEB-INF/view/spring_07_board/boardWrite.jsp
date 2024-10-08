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
	$("#btnSave").on('click', btnSaveProcess);
});

//목록으로
function btnListProcess(){
	$('#frm').attr('action', 'main.do');
	$('#frm').attr('method', 'get');
	$('#frm').submit();
}

//저장
function btnSaveProcess(){
	//alert("save btn clicked");
	$('#frm').attr('action', 'write.do');
	$('#frm').submit();
}
</script>
</head>
<body>
	<p>글쓰기 페이지</p>
	<form name="frm" id="frm" method="post">
		<table border="1">
			<tr>
				<td width="20%" align="center">글쓴이</td>
				<td>
					<input type="text" name="writer" style="width:400px;">
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">이메일</td>
				<td>
					<input type="text" name="email" style="width:400px;">
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">글제목</td>
				<td>
					<input type="text" name="subject" style="width:400px;">
				</td>
			</tr>
			<tr>
				<td width="20%" align="center">내용</td>
				<td>
					<textarea name="content" rows="13" cols="40"></textarea>
				</td>
			</tr>
		</table>
		${board}
			num : <input type="text" name="num" value="${board.num }">
			ref : <input type="text" name="ref" value="${board.ref }">
			re_step : <input type="text" name="re_step" value="${board.re_step }">
			re_level : <input type="text" name="re_level" value="${board.re_level }">
		<input type="button" id="btnList" value="목록으로"><!-- 클릭 시 원래페이지로 되돌아감  -->
		<input type="button" id="btnSave" value="저장"><!-- 클릭 시 DB 저장하고 원래페이지로 되돌아감. -->
	</form>
</body>
</html>