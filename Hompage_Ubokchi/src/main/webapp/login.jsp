<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="login.do" method="post">
		아이디<br>
		<input type="text" name="userid" required><br> 비밀번호<br>
		<input type="password" name="password" required><br>
		<button type="submit">로그인</button>
	</form>
	<form action="<%= request.getContextPath() %>/memberRegister.jsp" method="get">
	  	<button type="submit">회원가입하기</button>
	</form>

	<%
		String err = request.getParameter("error");
		String deleted = request.getParameter("deleted");
		String logout = request.getParameter("logout");
		if ("1".equals(err)) {
	%>
	<p>아이디 또는 비밀번호가 올바르지않습니다.</p>
	<% } else if ("loginRequired".equals(err)) { %>
	<p>로그인이 필요한 서비스입니다.</p>
	<% }if ("1".equals(deleted)) { %>
	<p>회원 탈퇴가 완료되었습니다.</p>
	<% }if ("1".equals(logout)) { %>
	<p>로그아웃되었습니다.</p>
	<% } %>

</body>
</html>



