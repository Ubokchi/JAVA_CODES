<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    bokchi.MemberVO loginUser = (bokchi.MemberVO) session.getAttribute("loginUser");
    if (loginUser == null) {
    	out.print("<script>alert('로그인이 필요한 서비스입니다!!');</script>");
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 정보</title>
    <h2>회원 정보</h2>

    <dl>
      <dt>아이디</dt>
      <dd><%= loginUser.getUserid() %></dd>

      <dt>이메일</dt>
      <dd><%= loginUser.getEmail() == null ? "" : loginUser.getEmail() %></dd>

      <dt>이메일 수신 동의</dt>
      <dd><%= loginUser.getEmailAgree() == null ? "" : loginUser.getEmailAgree() %></dd>

      <dt>관심분야</dt>
      <dd><%= loginUser.getInterestJoin() == null ? "" : loginUser.getInterestJoin() %></dd>

      <dt>전화번호</dt>
      <dd><%= loginUser.getPhone() == null ? "" : loginUser.getPhone() %></dd>

      <dt>자기소개</dt>
      <dd><%= loginUser.getIntroduce() == null ? "" : loginUser.getIntroduce() %></dd>
    </dl>

      <form action="<%= request.getContextPath() %>/memberUpdate.jsp" method="get">
      <button type="submit" class="btn">회원 정보 수정하기</button>
    </form>

    <form action="<%= request.getContextPath() %>/delete.do" method="post"
          onsubmit="return confirm('정말 탈퇴하시겠습니까?');">
      <input type="hidden" name="userid" value="<%= loginUser.getUserid() %>">
      <button type="submit" class="btn btn-danger">회원 탈퇴</button>
      </form>
      </form>
      <form action="<%= request.getContextPath() %>/logout.do" method="post">
      <button type="submit">로그아웃</button>
    </form>
    </div>
  </div>
</body>
</html>