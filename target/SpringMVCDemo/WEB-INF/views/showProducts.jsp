
<div class="container">

	<div class="row">

		<%@include file="shared/sidebar.jsp"%>

		<div class="col-lg-9">

			<c:if test="${userClickedShowCategoryProducts ==true}">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/show/all/products">All products</a></li>
					<li class="breadcrumb-item active">${category.getName() }</li>

				</ol>

			</c:if>

			<c:if test="${userClickedShowAll ==true}">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
					 <li class="breadcrumb-item active">All products</li>

				</ol>

			</c:if>


		</div>
	</div>
</div>