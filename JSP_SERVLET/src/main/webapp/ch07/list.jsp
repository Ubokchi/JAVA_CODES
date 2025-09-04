<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("둘리");
		list.add("도우너");
		list.add("고길동");
		list.add("또치");	
	%>
	
	<ul>
	<% for(int i = 0; i < list.size(); i++) { %>
		<li><%=list.get(i) %></li>
	<% } %>
	</ul>

</body>
</html>









