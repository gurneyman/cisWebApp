<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/" var="appRoot" />

<link href="${mainCss}" rel="stylesheet" />
</head>
<body ng-controller="HelloController">
	JSP TEST!
	
	<a href="#" id="get-data">Get JSON data</a>
    <div id="show-data"></div>
    
    <h2>Hello {{helloTo.title}} !</h2>
	<pre>{{ helloTo.data }}</pre>
	
	<h1>{{ helloTo.data.userName }}</h1>
	<h1>{{ helloTo.data.password }}</h1>
	
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.0/angular.js"></script>
	<script>
		/* $(document).ready(
				function() {
					$('#get-data').click(
							function() {
								var showData = $('#show-data');
								showData.text('Loading the JSON file.');
								$.getJSON('${appRoot}/users', function(data) {
									console.log(data);
									
									showData.append(data);

								});

								
							});
				}); */
				
				angular.module("myapp", [])
			    .controller("HelloController", function($scope, $http) {
			        $scope.helloTo = {};
			        $scope.helloTo.title = "World, AngularJS";
			        
			        $http.get('${appRoot}/user').then(function successCallback(response) {
			            // this callback will be called asynchronously
			            // when the response is available
			        	$scope.helloTo.data = response.data;
			          }, function errorCallback(response) {
			            // called asynchronously if an error occurs
			            // or server returns response with an error status.
			        	  $scope.helloTo.data = "Error Code: " + response.data.status;
			          });
			    } );
	</script>
</body>
</html>