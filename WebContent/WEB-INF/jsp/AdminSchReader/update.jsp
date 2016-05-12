<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- http://stackoverflow.com/questions/22824190/how-to-use-format-date-as-yyyy-mm-dd-with-jstl -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--head.jsp include Goes Here -->
<!--body.jsp include Goes Here -->
<%@ include file="../head.jsp" %>
<!--body.jsp include Goes Here -->
<%@ include file="../body.jsp" %>

<%@ page import="java.text.SimpleDateFormat"%>
<%@page session="true"%>

<%
	// http://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm
	String format = "(mm/dd/yyyy)";
	SimpleDateFormat formatDate = new SimpleDateFormat(format);
%>
<!-- 
	Hacking in a date picker: https://jqueryui.com/datepicker/
	In production this would be minified and put in external files 
-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
$(function() {
    $( ".date-picker" ).datepicker();
  });
</script>
<BODY BGCOLOR="white">
	<H1>Welcome to Update Baruch Course Schedule</H1>
	<h3>Logged in as: ${pageContext.request.userPrincipal.name}</h3>
	<br>
	<!-- Make fields required required="required" -->
	<form:form action="/18_Prince_Thomas_HW4/admin/display" method="post"
		commandName="semesterForm">
		
		
		<label for="semesterId">Semester</label> <font color="red"><form:errors path="semesterId"></form:errors></font><br>
		<form:select path="semesterId">
			<form:option value="" label="--- Select ---" selected="true" disabled="true" />
			<c:forEach items="${semesters}" var="semester">
					<form:option value="${semester.semesterId}" label="${semester.semesterName}">${semester.semesterName}
						(<fmt:formatDate value="${semester.startDate}"
							pattern="dd/MM/yyyy" /> to
						<fmt:formatDate value="${semester.endDate}"
							pattern="dd/MM/yyyy" />)
					</form:option>
				</c:forEach>
		</form:select>
		<br/><br/>
		<label for="startDate">Start Date</label> <font color="red"> <form:errors path="startDate"></form:errors></font><br>
		<form:input path="startDate" placeholder="mm/dd/yyyy" class="date-picker"/>
		<br/><br/>
		<label for="endDate">End Date</label> <font color="red"><form:errors path="endDate"></form:errors></font><br>
		<form:input path="endDate" placeholder="mm/dd/yyyy"  class="date-picker"/>
		
		<%-- <label>Semester: <select name="semester">
					<option selected="selected" disabled>Semester Select</option>
					<c:forEach items="${semesters}" var="semester">
						<option value="${semester.semesterId}">${semester.semesterName}
							(<fmt:formatDate value="${semester.startDate}"
								pattern="dd/MM/yyyy" /> to
							<fmt:formatDate value="${semester.startDate}"
								pattern="dd/MM/yyyy" />)
						</option>
					</c:forEach>
			</select>


			</label>&nbsp;&nbsp; Start Date: <INPUT TYPE="TEXT" NAME="startDate" VALUE="">&nbsp;&nbsp;&nbsp;
			End Date:</B> <INPUT TYPE="TEXT" NAME="endDate" VALUE=""><br> --%>
		<br>
		<br>
		<INPUT TYPE="SUBMIT" value="Update Schedule">
		<!-- Press this button to submit form -->
	</form:form>
	<!--foot.jsp include Goes Here -->
	<%@ include file="../foot.jsp" %>