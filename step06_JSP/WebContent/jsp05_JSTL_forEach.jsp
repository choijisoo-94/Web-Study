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
   
   <h3>1. 1~5까지 forEach라는 jstl 반복 태그로 출력</h3>
   <c:forEach begin="1" end="5" step="1" var="data">
      ${data}<br>
   </c:forEach>
   
   <br><hr><br>
   
   <h3>2. 반복되는 횟수 카운팅</h3>
   <c:forEach begin="10" end="20" step="2" var="data" varStatus="status">
      ${status.index}- ${data} - ${status.count} <br>
   </c:forEach>
   
   <br><hr><br>
   
   <%
   ArrayList<People> all = new ArrayList<People>();
   all.add(new People("다영",26));   
   all.add(new People("연식",26));   
   all.add(new People("민건",46));   
   
   application.setAttribute("aData1", all);
   %>
   
   <h3>3. ArrayList에 저장된 객체들의 내용값을 반복을 통해서 출력</h3>
   <c:forEach items="${applicationScope.aData1}" var="data">
      ${data.name}=${data.age}<br>
   </c:forEach>
      
</body>
</html>