
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<title>${title } | OnlineShop</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/main.css" rel="stylesheet">
<!--  Custom bootstrap theme-->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="shared/navigation.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickedHome == true }">
				<%@include file="content.jsp"%>
			</c:if>

			<c:if test="${userClickedAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickedContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickedShowAll == true or userClickedShowCategoryProducts == true}">
				<%@include file="showProducts.jsp"%>
			</c:if>

		</div>
		<!-- Footer -->
		<%@include file="shared/footer.jsp"%>
	</div>

	<!-- Custom jquery file -->
	<script src="${js}/jquery.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${js}/jquery.min.js"></script>

</body>

</html>
