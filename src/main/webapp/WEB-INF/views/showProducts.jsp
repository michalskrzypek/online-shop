
<div class="container">

	<div class="row">

		<%@include file="shared/sidebar.jsp"%>

		<div class="col-lg-9">

			<c:if test="${userClickedShowCategoryProducts ==true}">
			<script>window.categoryId ='${category.getId()}'</script>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/show/all/products">All
							products</a></li>
					<li class="breadcrumb-item active">${category.getName() }</li>

				</ol>

			</c:if>

			<c:if test="${userClickedShowAll ==true}">
		<script>window.categoryId =''</script>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="breadcrumb-item active">All products</li>

				</ol>

			</c:if>


			<div class="col-xs-12">

				<table id="products_table" class="table table-striped table-bordered">

					<thead>

						<tr>
						
						<th>ID</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Price</th>
						<th>Quantity</th>
						
						</tr>
						
					</thead>

				</table>

			</div>

		</div>
	</div>
</div>