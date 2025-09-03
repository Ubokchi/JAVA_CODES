<%@ page import="bokchi.MemberVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h2>회원 정보 수정</h2>

	<%
		   if (session.getAttribute("loginUser") != null) {
		        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		    } else {
		    	out.print("<script>alert('로그인이 필요한 서비스입니다!!');</script>");
		        out.print("<script>location.href='login.jsp'</script>");
		    }
	%>

	<form action="${pageContext.request.contextPath}/memberUpdate.do"
		method="post">

		<input type="hidden" name="userid" value="${loginUser.userid}">

		아이디: <input type="text" value="${loginUser.userid}" disabled><br>

		비밀번호: <input type="password" name="password" required><br>

		이메일: <input type="email" name="email" value="${loginUser.email}"
			required><br> 이메일 수신 동의: <input type="checkbox"
			name="emailAgree" value="Y"
			${loginUser.emailAgree == 'Y' ? 'checked' : ''}> 동의 <br>

		<div>
			<label>관심분야: </label> <input type="checkbox" name="interest"
				value="서버 개발"> 서버 개발 <input type="checkbox" name="interest"
				value="앱 개발"> 앱 개발 <input type="checkbox" name="interest"
				value="웹 개발"> 웹 개발
		</div>

		전화번호: <input type="text" name="phone" value="${loginUser.phone}"><br>

		자기소개: <br>
		<textarea name="introduce" rows="4" cols="40">${loginUser.introduce}</textarea>
		<br>

		<button type="submit" name="action" value="update">수정하기</button>

		<a href="${pageContext.request.contextPath}/memberResult.jsp">취소</a>
		<form action="<%= request.getContextPath() %>/login.do" method="post">
    </form>
	</form>
</body>
</html>