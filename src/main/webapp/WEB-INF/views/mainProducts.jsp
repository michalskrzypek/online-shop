			<div class="page-header">
				<h3><i>Most viewed products</i></h3>
			</div>

<div class="row">

	<c:if test="${products.size() <=6 }">
		<c:forEach items="${productsSortedByViews }" var="product">
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<a href="${pageContext.request.contextPath }/show/product/${product.getId()}"><img class="card-img-top"
						src="${pageContext.request.contextPath}/resources/images/${product.getCode()}.jpg"
						alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/show/product/${product.getId()}"><i>${product.getBrand()}</i> ${product.getName()}</a>
						</h4>
						<h5>$${product.getUnitPrice() }</h5>

					</div>
					<div class="card-footer">
						<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
							&#9734;</small>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>



	<c:if test="${products.size() > 6 }">
		<c:forEach begin="0" end="5" items="${productsSortedByViews }" var="product">

			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<a href="${pageContext.request.contextPath }/show/product/${product.getId()}"><img class="card-img-top"
						src="${pageContext.request.contextPath}/resources/images/${product.getCode()}.jpg"
						alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/show/product/${product.getId()}"><i>${product.getBrand()}</i> ${product.getName()}</a>
						</h4>
						<h5>$${product.getUnitPrice() }</h5>
						
					</div>
					<div class="card-footer">
						<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
							&#9734;</small>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>


</div>
<!-- /.row -->