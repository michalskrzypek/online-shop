
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
<meta name="description"
	content="OnlineShop is my first spring and hibernate project.">
<meta name="author" content="Michal Skrzypek">
<meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />

<title>${title}|OnlineShop</title>

<script>
	window.contextRoot = '${pageContext.request.contextPath}'
</script>



<!--  Custom bootstrap theme-->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">
<!--  Custom bootstrap for datatable -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="${css}/myApp.css" rel="stylesheet">
<!--  -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->

		<%@include file="shared/navigation2.jsp"%>


		<!-- Page Content -->

		<div class="content">

			<div class="container">

				<div class="row">
					<div class="col-xs-4">

						<c:if test="${showCartDetails  == true}">
							<%@include file="showCartDetails.jsp"%>
						</c:if>

						<c:if test="${selectAddress  == true}">
							<%@include file="selectAddress.jsp"%>
						</c:if>


						<c:if test="${confirmAndPay  == true}">
							<%@include file="confirmationAndPayment.jsp"%>
						</c:if>

						<c:if test="${showReceipt  == true}">
							<%@include file="receipt.jsp"%>
						</c:if>
					</div>
				</div>
			</div>

		</div>
		<!-- Footer -->
		<%@include file="shared/footer.jsp"%>
	</div>

	<!-- Custom jquery file for particular bootstrap template-->
	<script src="${js}/jquery.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.min.js"></script>
	<!--JQuery datatable plugin  -->
	<script src="${js}/jquery.dataTables.js"></script>
	<!--Bootstrap custom template for JQuery datatable plugin  -->
	<script src="${js}/dataTables.bootstrap4.js"></script>

	<!--  jquery code for category form validation-->
	<script src="${js}/jquery.validate.js"></script>
	<%-- 	<script src="${js}/jquery.validate.min.js"></script> --%>
	<!--  Some javascript code written by myself-->
	<script src="${js}/myApp.js"></script>
</body>

</html>
