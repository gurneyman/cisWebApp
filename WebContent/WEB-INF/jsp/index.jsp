<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="./head.jsp"%>
<!--body.jsp include Goes Here -->
<%@ include file="./body.jsp"%>

<div ng-app="courseSearch">
	<a ui-sref="course_search">Search</a>
	<a href="./admin/update" target="_self">Admin</a>
	<div ui-view></div>
</div>


<!--foot.jsp include Goes Here -->
<%@ include file="./foot.jsp"%>
<!-- </body>
</html> -->
