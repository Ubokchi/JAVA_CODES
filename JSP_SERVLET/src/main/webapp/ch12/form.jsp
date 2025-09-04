<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송 테스트</title>
</head>
<body>
	<!-- GET 방식으로 result.jsp에 데이터 전송 -->
	<form action="result.jsp" method="GET">
		 <p>이름</p>
		 <input type="text" name="name">
		 <p>나이</p>
		 <input type="number" name="age">
		 <br><br>
		 <input type="submit" value="전송">
	</form>
	
	<!-- 
		input name="parameter 이름" : 전송할 데이터를 인식하는 parameter
		input value="값" : 전송할 값
	 -->

</body>
</html>






