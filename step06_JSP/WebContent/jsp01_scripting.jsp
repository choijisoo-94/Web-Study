<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--
		1. ����, �޼ҵ� ����
		2. ���
		 
	
	 --%>
	 
	 <!--
		1. ����, �޼ҵ� ����
		2. ���
	-->
		 
		 
	 <%! 
	 String id="tester";
	 
	 public String getId(){
		 return id;
	 }
	 %>
	 
	1. <%= id %> <br>
	2. <%= getId() %> <br>
	3. <% out.println(id); %>
</body>
</html>