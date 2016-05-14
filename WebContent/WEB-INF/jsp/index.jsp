<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="./head.jsp"%>
<!--body.jsp include Goes Here -->
<%@ include file="./body.jsp"%>
<%--
<!DOCTYPE html>
<html data-ng-app="courseSearch">

<head>
<style>
/* This helps the ng-show/ng-hide animations start at the right place. */
/* Since Angular has this but needs to load, this gives us the class early. */
.ng-hide {
	display: none !important;
}
</style>
<title data-ng-bind="title"></title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link REL="icon" href="http://www.baruch.cuny.edu/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="http://www.baruch.cuny.edu/css/baruch_interior.css" />
<link rel="stylesheet" type="text/css"
	href="http://www.baruch.cuny.edu/css/application.css" />
<spring:url value="/" var="appRoot" /> 


<link href="resources/content/bootstrap.min.css" rel="stylesheet" />
<link href="resources/content/font-awesome.min.css" rel="stylesheet" />
<link href="resources/content/toastr.css" rel="stylesheet" />
</head>
<body>--%>
<base href="/18_Prince_Thomas_HW4/" />
<div ng-app="courseSearch">
	<a ui-sref="course_search">Search</a>
	<a href="./admin/update" target="_self">Admin</a>
	<div ui-view></div>
</div>

<!-- Vendor Scripts -->
<script src="resources/scripts/angular.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.18/angular-ui-router.min.js"></script>

<!-- Bootstrapping -->
<script src="resources/app/app.js"></script>
<script src="resources/app/config.js"></script>
<script src="resources/app/config.route.js"></script>

<!--foot.jsp include Goes Here -->
<%@ include file="./foot.jsp"%>
<!-- </body>
</html> -->
