
<div class="container">

	<div class="row">

		<%@include file="shared/sidebar.jsp"%>

		<div class="col-lg-9">

			<c:if test="${userClickedShowCategoryProducts ==true}">
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="active">/ Category</li>
					<li class="active">/ ${category.getName() }</li>

				</ol>

			</c:if>

			<c:if test="${userClickedShowAll ==true}">
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="active">/ All products</li>

				</ol>

			</c:if>


		</div>
	</div>
</div>