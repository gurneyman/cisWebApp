<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/baruch_interior.css" />
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/application.css" />
<spring:url value="/resources/css/schedule.css" var="mainCss" />
<spring:url value="/" var="appRoot" />

<link href="${mainCss}" rel="stylesheet" />
<base href="/18_Prince_Thomas_HW4/" />
<!--HEAD Include Ends -->
