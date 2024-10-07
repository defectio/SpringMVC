<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- orderInsert.htm에서 값들을 받는다. -->
	<!-- OrderItem의 id, cnt, remark에 일차적으로 저장하고, 최종적으로 OrderDTO의 list로 저장됨. -->
	<form action="orderInsert.htm" method="post">
		상품1 : ID-<input type="text" name="list[0].id">
				 수량-<input type="text" name="list[0].cnt">
				 주의사항-<input type="text" name="list[0].remark"><br>
				 
		상품2 : ID-<input type="text" name="list[1].id">
				 수량-<input type="text" name="list[1].cnt">
				 주의사항-<input type="text" name="list[1].remark"><br>
		주소 : <input type="text" name="address"><br>
		<input type="submit" value="commit" >
	</form>
</body>
</html>