<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/" var="appRoot" />

<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
	JSP TEST!
	
	<a href="#" id="get-data">Get JSON data</a>
    <div id="show-data"></div>

	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script>
		$(document).ready(
				function() {
					$('#get-data').click(
							function() {
								var showData = $('#show-data');
								showData.text('Loading the JSON file.');
								$.getJSON('${appRoot}/user', function(data) {
									console.log(data);
									
									showData.append(data);

								});

								
							});
				});
	</script>
</body>
</html>