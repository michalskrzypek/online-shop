<div class="container">

	<c:if test="${param.success !=null}">

		<div class="row">
			<div style="margin: auto;">
			
				
				
				<c:choose>

					<c:when test="${param.success == 'add' }">
						<div class="alert alert-success">
							<strong>${message }</strong>
						</div>
					</c:when>

					<c:when test="${param.success == 'delete' }">
						<div class="alert alert-danger">
							<strong>${message }</strong>
						</div>
					</c:when>

					<c:when test="${param.success == 'update' }">
						<div class="alert alert-info">
							<strong>${message }</strong>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</c:if>

	<c:if test="${param.error != null }">
		<div class="row">
			<div style="margin: auto;">

				<c:choose>
					<c:when test="${param.error == 'add' }">
						<div class="alert alert-warning">
							<strong>${message }</strong>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</c:if>

<div class="page-header">
					<h2><span class="glyphicon glyphicon-shopping-cart"></span> Your cart </h2>
				</div>
	<c:choose>
		<c:when test="${not empty cartlines }">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 30%">Product</th>
						<th style="width: 20%">Brand</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${cartlines }" var="cartline">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img
											src="${pageContext.request.contextPath }/resources/images/${cartline.getProduct().getCode() }.jpg"
											alt="${cartline.getProduct().getName() }" class="cartImg" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartline.getProduct().getName() }</h4>
										<p>${cartline.getProduct().getDescription() }</p>
									</div>
								</div>
							</td>

							<td data-th="Brand">${cartline.getProduct().getBrand() }</td>

							<td data-th="Price">&#36;${cartline.getProduct().getUnitPrice() }</td>
							<td data-th="Quantity"><input type="number"
								id="count_${cartline.getId() }" min=1
								max="${cartline.getProduct().getQuantity()}"
								class="form-control text-center"
								value="${cartline.getProductCount()}" /></td>
							<td data-th="Subtotal" class="text-center">&#36;${cartline.getTotal() }</td>
							<td class="actions" data-th="">
								<%-- <form action="${pageContext.request.contextPath }/cart/update/cartline/ }"> --%>
								<button type="submit" name="refreshButton"
									value="${cartline.getId()}" class="btn btn-info btn-sm">
									<span class=" glyphicon glyphicon-refresh"></span>
								</button>

								<form
									action="${pageContext.request.contextPath }/cart/delete/cartline/${cartline.getId() }"
									method="post">
									<button type="submit" class="btn btn-danger btn-sm">
										<span class=" glyphicon glyphicon-trash"></span>
									</button>
								</form>
							</td>
						</tr>

					</c:forEach>


				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total
								&#36;${accountModel.getCart().getTotal() }</strong></td>
					</tr>
					<tr>
						<td><a
							href="${pageContext.request.contextPath }/show/all/products"
							class="btn btn-warning"><span
								class="glyphicon glyphicon-menu-left"></span> Continue Shopping</a></td>
						<td colspan="3" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#36;${accountModel.getCart().getTotal() }</strong></td>
						<td><a
							href="${pageContext.request.contextPath }/checkout/cart_details"
							class="btn btn-success btn-block">Checkout <span
								class="glyphicon glyphicon-menu-right"></span>
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>

			<div class="page-header">
				<h1 style="text-align: center;">Your cart is empty!</h1>
			</div>
			<a href="${pageContext.request.contextPath }/show/all/products"
				class="btn btn-warning"><span
				class="glyphicon glyphicon-menu-left"></span> Continue Shopping</a>
		</c:otherwise>


	</c:choose>


</div>