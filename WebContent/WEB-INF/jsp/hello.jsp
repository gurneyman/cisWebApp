<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
	<h2>${message}</h2>
	
	<table border="1" cellpadding="20">
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Role</th>
			<th>Dept</th>
			<th>School</th>
		</tr>
	
	<c:forEach items="${adminUsers}" var="adminUser">
		<tr>
			<td align="center"><c:out value="${adminUser.userName}" /></td>
			<td align="center"><c:out value="${adminUser.password}" /></td>
			<td align="center"><c:out value="${adminUser.role}" /></td>
			<td align="center"><c:out value="${adminUser.dept}" /></td>
			<td align="center"><c:out value="${adminUser.school}" /></td>
		</tr>
	</c:forEach>
	
	</table>
	
	<form action="/hello" method="POST">
		<input type="submit" value="Create"/>
	</form>
</body>
</html>