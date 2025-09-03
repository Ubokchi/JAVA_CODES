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
	
	String updated = request.getParameter("updated");
	String err = request.getParameter("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h2>회원 정보</h2>

	<% if (updated != null && updated.equals("1")) { %>
	<p>회원 정보가 수정되었습니다.</p>
	<% } %>
	<% if (err != null && err.equals("deleteFail")) { %>
	<p>탈퇴 처리에 실패했습니다.</p>
	<% } else if (err != null && err.equals("updateFail")) { %>
	<p>수정 처리에 실패했습니다.</p>
	<% } %>

	<dl>
		<dt>아이디</dt>
		<dd><%= user.getUserid() %></dd>
		<dt>이메일</dt>
		<dd><%= user.getEmail() %></dd>
		<dt>이메일 수신 동의</dt>
		<dd><%= user.getEmailAgree() == null ? "N" : user.getEmailAgree() %></dd>
		<dt>관심분야</dt>
		<dd><%= user.getInterestJoin() %></dd>
		<dt>전화번호</dt>
		<dd><%= user.getPhone() == null ? "" : user.getPhone() %></dd>
		<dt>자기소개</dt>
		<dd><%= user.getIntroduce() == null ? "" : user.getIntroduce() %></dd>
	</dl>

	<div class="actions">
		<form action="<%= request.getContextPath() %>/memberUpdate.jsp"
			method="get">
			<button type="submit">회원 정보 수정하기</button>
		</form>
		<form action="<%= request.getContextPath() %>/delete.do" method="post"
			onsubmit="return confirm('정말 탈퇴하시겠습니까?');">
			<button type="submit">회원 탈퇴</button>
		</form>
	</div>
</body>
</html>