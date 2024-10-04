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
	<!-- [방법1] -->
<!-- 	<h3>form 태그의 name 속성값으로 전달(request)받은 데이터를 ModelAndView 객체를 통해 전달(response)</h3> -->
<%-- 	<p>이름 : ${name }</p> --%>
<%-- 	<p>나이 : ${age }</p> --%>
<!-- 	<hr> -->
	
	<!-- [방법2] -->
<!-- 	<h3>form 태그의 name 속성값을 DTO 타입으로 받아서 전달</h3> -->
<%-- 	<p>이름 : ${dto.name}</p> --%>
<%-- 	<p>나이 : ${dto.age}</p> --%>
<!-- 	<hr> -->

	<!-- [방법3-1] -->
<!-- 	<h3>DTO & ModelAttribute 어노테이션 사용1</h3> -->
<%-- 	<p>이름 : ${vo1.name}</p> --%>
<%-- 	<p>나이 : ${vo1.age}</p> --%>
<!-- 	<hr> -->

	<!-- [방법3-2] -->
<!-- 	<h3>DTO & ModelAttribute 어노테이션 사용2</h3> -->
<%-- 	<p>이름 : ${vo2.name}</p> --%>
<%-- 	<p>나이 : ${vo2.age}</p> --%>
<!-- 	<hr> -->

	<!-- [방법4]. -->
	<h3>HttpServletRequest객체 사용</h3>
	<p>이름 : ${req_name}</p>
	<p>나이 : ${req_age}</p>
	<p>클라이언트 IP주소 : ${req_address}</p>	

</body>
</html>