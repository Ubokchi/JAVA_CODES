<%@page import="edu.web.homework.BoardVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW1</title>
</head>
<body>
	<%
		// TODO : BoardVO list를 저장할 ArrayList 선언
		ArrayList<BoardVO> list = new ArrayList<>();
		
		// TODO : BoardVO 데이터 5개를 임의로 생성하고 list에 add
		// 날짜는 현재 날짜로
		list.add(new BoardVO(1, "test1", "mok", new Date()));
		list.add(new BoardVO(2, "test2", "mok", new Date()));
		list.add(new BoardVO(3, "test3", "mok", new Date()));
		list.add(new BoardVO(4, "test4", "mok", new Date()));
		list.add(new BoardVO(5, "test5", "mok", new Date()));
	%>
	<%-- table 태그 및 for문을 사용하여 list에 저장된 게시글 데이터 출력 --%>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0; i < list.size(); i++) { %>
			<tr>
				<td><%=list.get(i).getBoardId() %></td>
				<td><%=list.get(i).getBoardTitle() %></td>
				<td><%=list.get(i).getUserid() %></td>
				<td><%=list.get(i).getRegDate() %></td>
			</tr>
		<% } %>
		</tbody>
	</table>

</body>
</html>






