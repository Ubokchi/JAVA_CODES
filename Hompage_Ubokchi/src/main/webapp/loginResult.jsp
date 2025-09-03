<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="bokchi.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<h2>로그인 성공했습니다.</h2>
	<form action="<%=request.getContextPath()%>/logout.do" method="post">
		<button type="submit">로그아웃</button>
	</form>
	<form action="<%=request.getContextPath()%>/memberResult.jsp"
		method="get">
		<button type="submit">내 정보 보기</button>
	</form>
</body>
</html>