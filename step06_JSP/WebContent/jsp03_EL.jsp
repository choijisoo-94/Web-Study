<%@page import="model.domain.People, java.util.ArrayList, java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp03_EL.jsp</title>
</head>
<body>
	EL tag �н�
	<br><hr><br>
	
	1. ��Ģ����� ���ڿ� �� <br>
	
	<table border="1">
		<tr><th>non-el</th><th>el</th></tr>
	
	
		<tr><td>2+3</td><td>${2+3}</td></tr>
		<tr><td>3==3</td><td>${3==3}</td></tr>
		<tr><td>"a"=="a"</td><td>${"a"=="a"}</td></tr>
	</table>
	
	
	<br><hr><br>
	<%-- servlet���� �̹� ��û ��ü �Ǵ� ���� ��ü�� �����͸� �����ϰ� ��� ���� ���� �����ߴ� ���� --%>
	
	<% //EL �н��� ���� TEST ������ ����
	   //setAttribute() - ������ ����/getAttribute() - ������ ��ȯ
	   
	   //1�ܰ� - �ܼ� ���ڿ� ����
	   //2�ܰ� - DTO ����
	   //3�ܰ� - ArrayList<~DTO>
		//4�ܰ� - Map�� ArrayList ����
	   request.setAttribute("rData1", "����");
	   session.setAttribute("sData1", new People("����", 26));
	   
	   
	   ArrayList<People> all = new ArrayList<People>();
	   all.add(new People("�ٿ�", 26)); //0
	   all.add(new People("����", 26)); //1
	   all.add(new People("�ΰ�", 26)); //2
	   
	   application.setAttribute("aData1", all);
	   
	   //? 
		HashMap<String, ArrayList<People>> all2 = new HashMap<>();
	   	all2.put("one", all);
	   	session.setAttribute("sData2", all2);
	   	
	   	/*
	   	sessionScope.sData2.one[1].name
	   	sessionScope : session
	   	sData2 : HashMap
	   	one : ArrayList<People>
	   	[1] : new People("����", 26)
	   	name : People�� name�� getName()
	   	
	   	*/
	  	 
	%>
	
	2. ��û�� ���ǰ� ���ؽ�Ʈ�� ����� �����͵� ȭ�鿡 ����ϴ� ���<br>
		1. ��û�� ����� ������ ��� : ${requestScope.rData1} <br>
	 	2. ���ǿ� ����� ������ �� �̸��� ��� : ${sessionScope.sData1.name} <br> <!-- getName() -->
		3. context�� ����� ������ �� �ٿ��� �̸��� ��� : ${applicationScope.aData1[0].name} <br>
		4. context�� ����� ������ �� �ΰǾ� ���̸� ��� : ${applicationScope.aData1[2].age} <br>
		5. ���ǿ� ����� sData2�� ���ε� ������ �� ���� �̸��� ��� : ${sessionScope.sData2.one[1].name} <br>
</body>
</html>