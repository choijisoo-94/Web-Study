<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp04_JSTL.jsp</title>
</head>
<body>
	<h3>1. if tag �н�</h3>
	<c:if test="${2==2}">
		1. if ���ǽ��� test��� �Ӽ� , EL tag�� ���ǽ� ǥ�� <br>
		2. ���ǽ��� true�� ��츸 ����Ǵ� ���
	</c:if>
	
	<br><hr><br>
	
	<h3>2. if ���ǽĿ� �ڹ� ������ ��</h3>
	<% request.setAttribute("rData", "string"); %>
	
	<%-- request�� string ���ڿ� ���忩�� Ȯ�� --%>
	
	<c:if test="${requestScope.rData == 'string'}">
		1. if ���ǽ��� test��� �Ӽ� , EL tag�� ���ǽ� ǥ�� <br>
		2. ���ǽ��� true�� ��츸 ����Ǵ� ���
	</c:if>
	
	<br><hr><br>
	
	<h3>3. if ���ǽĿ� �ڹ� ������ ���翩�� ��</h3>
	<c:if test="${requestScope.sData == null}">
		3-1. �ش� �����Ͱ� null�� ��츸 ��� <br>
	</c:if>
	
	<c:if test="${empty requestScope.sData}">
		3-2. �ش� �����Ͱ� null�� ��쿣 empty������ ��� ���� ����  <br>
	</c:if>
	
	
	<c:if test="${not empty requestScope.sData}">
		3-3. �ش� �����Ͱ� null�� �ƴ� ��쿡�� ���  <br>
	</c:if>
	
	<br><hr><br>
	
	
	<h3>4. ���� ���ǽ� : if tag ������ ���� ���ǽ� ���� �Ұ�, else ǥ������ ����</h3>
	<c:choose>
	<c:when test="${2==3}">
		1 <br>
	</c:when>
	<c:when test="${2==2}">
		2 <br>
	</c:when>
	<c:otherwise>
		3
	</c:otherwise>
	</c:choose>





</body>
</html>