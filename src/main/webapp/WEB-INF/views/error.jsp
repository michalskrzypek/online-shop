
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title} | OnlineShop</title>

<!-- Custom styles for this template -->
<link href="${css}/myApp.css" rel="stylesheet"> 
<!--  Custom bootstrap theme-->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">
<!--  Custom bootstrap for datatable -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="shared/navigation.jsp"%>

		<!-- Page Content -->
		<div class="content">

<div class="jumbotron" style="width:70%; margin:0 auto">
  <h1 class="display-3">${errorTitle}</h1>
  <hr class="my-2">
  <p>${errorDesc }</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/home" role="button">Home page</a>
  </p>
</div>


		</div>
		<!-- Footer -->
		<%@include file="shared/footer.jsp"%>
	</div>
</body>

</html>
