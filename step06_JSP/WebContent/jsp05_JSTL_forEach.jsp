<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList, model.domain.People" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp05_JSTL_forEach.jsp</title>
</head>
<body>
   
   <h3>1. 1~5���� forEach��� jstl �ݺ� �±׷� ���</h3>
   <c:forEach begin="1" end="5" step="1" var="data">
      ${data}<br>
   </c:forEach>
   
   <br><hr><br>
   
   <h3>2. �ݺ��Ǵ� Ƚ�� ī����</h3>
   <c:forEach begin="10" end="20" step="2" var="data" varStatus="status">
      ${status.index}- ${data} - ${status.count} <br>
   </c:forEach>
   
   <br><hr><br>
   
   <%
   ArrayList<People> all = new ArrayList<People>();
   all.add(new People("�ٿ�",26));   
   all.add(new People("����",26));   
   all.add(new People("�ΰ�",46));   
   
   application.setAttribute("aData1", all);
   %>
   
   <h3>3. ArrayList�� ����� ��ü���� ���밪�� �ݺ��� ���ؼ� ���</h3>
   <c:forEach items="${applicationScope.aData1}" var="data">
      ${data.name}=${data.age}<br>
   </c:forEach>
      
</body>
</html>