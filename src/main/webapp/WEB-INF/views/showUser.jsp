<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	readAreaXmlFile Result : success = ${success }
	<br>
	saveUser Result : name = ${name }
	<br>
	getAll Result : 
	<c:forEach items="${userList }" var="user">
		${user.name }<br/>
	</c:forEach>
	<br>
	showUser Result : user.name = ${user.name }
	<br>
</body>
</html>