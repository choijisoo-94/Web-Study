<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
b를 포함 전

<br><hr><br>

<%-- b.jsp파일을 마치 a.jsp 파일인듯하게 포함하는 tag --%>

${pageContext.request.contentType} <br>

http://localhost/step07_layout/view01/b.jsp <br>

<jsp:include page="${pageContext.request.contextPath}/view01/b.jsp" />


<br><hr><br>
b 포함 후




</body>
</html>