	<div class="row">
<c:forEach items="${products }" var="product">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="${pageContext.request.contextPath}/resources/images/${product.getCode()}.jpg" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">${product.getName()}</a>
								</h4>
								<h5>$${product.getUnitPrice() }</h5>
								<p class="card-text">${product.getDescription() }</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
</c:forEach>
				</div>
				<!-- /.row -->