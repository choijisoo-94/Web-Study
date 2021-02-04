<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dept.model.domain.DeptDTO,java.util.ArrayList"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>successDeptView.jsp</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
		<body>
	<table border="1">
	<tr>
		<th>image</th> <th>Deptno</th> <th>Dname</th> <th>Loc</th> 
	</tr>
	<c:forEach items="${sessionScope.all}" var="data">
		<tr>
			<td><i class="fa fa-youtube-play" style="font-size:36px;color:red"></i></td>
			<td>${data.deptno}</td>
			<td>${data.dname}</td>
			<td>${data.loc}</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<a href= "${pageContext.request.contextPath}/login.html">돌아가기</a>
</body>

​
</body>
</html>