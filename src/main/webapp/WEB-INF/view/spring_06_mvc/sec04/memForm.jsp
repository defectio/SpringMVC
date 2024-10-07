<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Member Data</p>
	
	<!-- 입력한 이름,나이가 name 속성의 "name", "age"를 통해서, post 방식으로 mem.htm으로 넘어감. -->
	<form name="frm" action="mem.htm" method="post">
		<!-- 웹접근성 label의 for 속성값과 input 태그의 id 속성값과 동일해야함. 요즘은 placeholder씀 -->
		<label for="fname">이름</label>
		<input type="text" name="name" id="frname"><br>
		
		<label for="fage">나이</label>
		<input type="text" name="age" id="fage" />
		<input type="submit" value="send" />
	</form>
	
</body>
</html>