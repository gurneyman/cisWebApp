<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../head.jsp" %>
<!--body.jsp include Goes Here -->
<%@ include file="../body.jsp" %>
<center>
	<h1>You have successfully updated the semester schedule</h1>
</center>


<p align="left">
	<b> <a href="${pageContext.request.contextPath}/logout"><font size="5">Log out</font></a>
	</b>&nbsp;<br> <br>
</p>
<center>
	<table width=600 border=1>
		<tr>
			<th align=left>Semester Name</th>
			<th align=left>Start Date</th>
			<th align=left>End Date</th>
		</tr>
		<tr>
			<td>${updatedSemester.semesterName}</td>
			<td><fmt:formatDate type="date" value="${updatedSemester.startDate}" /></td>
			<td><fmt:formatDate type="date" value="${updatedSemester.endDate}" /></td>
		</tr>
	</table>
</center>


<!--foot.jsp include Goes Here -->
<%@ include file="../foot.jsp" %>

