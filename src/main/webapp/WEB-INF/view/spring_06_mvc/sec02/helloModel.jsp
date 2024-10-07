<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>helloModel page</p>
	<!-- HelloModelController에서 지정한 model.addAttribute("id", "korea"); 의 id에 의해서 값이 넘어옴.  -->
	<!-- id(키)로 korea(값)에 접근 -->
	<p>${id }</p>
</body>
</html>