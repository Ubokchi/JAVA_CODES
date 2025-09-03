<%@ page
	import="bokchi.MemberDAO, bokchi.MemberDAOImple, bokchi.MemberVO"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%
	String userid = (String) session.getAttribute("userid");
	if (userid == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
		return;
	}
	MemberDAO dao = MemberDAOImple.getInstance();
	MemberVO user = dao.selectByUserid(userid);
	if (user == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
		return;
	}
	String err = request.getParameter("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h2>회원 정보 수정</h2>

	<% if ("updateFail".equals(err)) { %>
	<p style="color: red;">회원 정보 수정 중 오류가 발생했습니다.</p>
	<% } %>

	<form action="<%= request.getContextPath() %>/memberUpdate.do"
		method="post">
		<input type="hidden" name="userid" value="<%= user.getUserid() %>">

		아이디: <input type="text" value="<%= user.getUserid() %>" disabled><br>
		비밀번호: <input type="password" name="password" required><br>
		이메일: <input type="email" name="email"
			value="<%= user.getEmail() %>" required><br>

		이메일 수신 동의: <input type="checkbox" name="emailAgree" value="Y"
			<%= "Y".equals(user.getEmailAgree()) ? "checked" : "" %>> 동의<br>

		<div>
			<label>관심분야: </label> <label><input type="checkbox"
				name="interest" value="서버 개발"
				<%= (user.getInterestJoin() != null && user.getInterestJoin().contains("서버 개발")) ? "checked" : "" %>>
				서버 개발</label> <label><input type="checkbox" name="interest"
				value="앱 개발"
				<%= (user.getInterestJoin() != null && user.getInterestJoin().contains("앱 개발")) ? "checked" : "" %>>
				앱 개발</label> <label><input type="checkbox" name="interest"
				value="웹 개발"
				<%= (user.getInterestJoin() != null && user.getInterestJoin().contains("웹 개발")) ? "checked" : "" %>>
				웹 개발</label>
		</div>
		<br> 전화번호: <input type="text" name="phone"
			value="<%= user.getPhone() == null ? "" : user.getPhone() %>"><br>
		자기소개:<br>
		<textarea name="introduce" rows="4" cols="40"><%= user.getIntroduce() == null ? "" : user.getIntroduce() %></textarea>
		<br>

		<button type="submit" name="action" value="update">수정하기</button>
		<a href="<%= request.getContextPath() %>/memberResult.jsp">취소</a>
	</form>
</body>
</html>