<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- http://stackoverflow.com/questions/22824190/how-to-use-format-date-as-yyyy-mm-dd-with-jstl -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--head.jsp include Goes Here -->
<!--body.jsp include Goes Here -->

<%@ page import="java.text.SimpleDateFormat"%>

<%
	String format = "(mm/dd/yyyy)";
	SimpleDateFormat formatDate = new SimpleDateFormat(format);
%>
<BODY BGCOLOR="white">
		<H1>Welcome to Update Baruch Course Schedule</H1>
		<br>

		<FORM ACTION="/18_Prince_Thomas_HW3/admin/display" method="post">
			<label>Semester: <select name="semester">
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
			End Date:</B> <INPUT TYPE="TEXT" NAME="endDate" VALUE=""><br>
			<br> <br> <INPUT TYPE="SUBMIT" value="Update Schedule">
			<!-- Press this button to submit form -->
		</FORM>
	<!--foot.jsp include Goes Here -->