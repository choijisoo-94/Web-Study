<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp02_actionView.jsp</title>
</head>
<body>
${pageContext.request.contextPath}
<br><hr><br>

	<% System.out.println("jsp02_actionView.jsp");
	
		String msg = request.getParameter("msg"); //?msg=��
		out.println(msg);
	
	%>
	
	
	<%-- ��ư���� jsp01_scripting.jsp�� �̵��Ǵ� �ڵ� �߰��ϱ�--%>
	<button onclick="location.href='${pageContext.request.contextPath}/jsp01_scripting.jsp'">01 jsp�� �̵�</button>
	
</body>
</html>