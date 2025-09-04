<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
	<!-- request 내장 객체를 이용한 데이터 출력 -->
	<%
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
	
		// String getParameter(String name) :
		// - request는 form에서 전송된 데이터를 불러오는 parameter를 제공
		// - request 객체에 form data가 저장되고,
		//   getParameter()로 데이터 참조
		
		// * GET 방식 url 정보
		// http://localhost:8080/ : 도메인 정보
		// JSP-Servlet/ : Context Root(서버 기본 경로)
		// ch12/result.jsp : 페이지 경로
		// ?name=%EB%AA%A9%EC%A7%84%ED%98%81&age=22 : query string
		// parameter : name, age
	%>
	
	이름 : <%= request.getParameter("name") %><br>
	나이 : <%= request.getParameter("age") %><br>

</body>
</html>








