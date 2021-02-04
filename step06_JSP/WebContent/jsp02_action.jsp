<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp02_action.jsp</title>
</head>
<body>
	<!-- http://ip:port/step06_JSP/jsp02_action.jsp
			http://ip:port/step06_JSP/encore1/jsp02_actionView.jsp
			
			forward로 이동
			http://ip:port/step06_JSP/jsp02_action.jsp
			http://ip:port/step06_JSP/jsp01_scripting.jsp
 	-->	
	<%
		System.out.println("jsp02_action.jsp");
	%>
	<%-- <jsp:forward page="encore1/jsp02_actionView.jsp?msg=test"/> --%>
	<jsp:forward page="encore1/jsp02_actionView.jsp">
		<jsp:param value="tester---" name="msg"/>
	</jsp:forward>
</body>
</html>