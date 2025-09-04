<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		String savedId = "";
		String savedPW = "";
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					savedId = cookie.getValue();
				} else if (cookie.getName().equals("pw")) {
					savedPW = cookie.getValue();
				}
			}
		}
	
	%>
	<form action="practiceResult.jsp" method="post">
		아이디<br> <input type="text" name="id" value="<%= savedId %>"><br> 비밀번호<br>
		<input type="password" name="pw" value="<%= savedPW %>"><br> <input
			type="checkbox" name="saveAgreed" value="agreed"> 아이디 저장<br>
		<br> <input type="submit" value="로그인">
	</form>
</body>
</html>