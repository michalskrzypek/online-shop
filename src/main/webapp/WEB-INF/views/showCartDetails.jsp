<div class="container">

		
        <div class = "row">
            <div class="row bs-wizard" style="border-bottom:0;">
                
                <div class="col-xs-3 bs-wizard-step active">
                  <div class="text-center bs-wizard-stepnum">Cart details</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Take a look at the products you are going to buy.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Shipping address</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Specify shipping address details.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Confirm & Pay</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Last chance to check whether information provided are correct. Enter your credit card details and pay.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled"><!-- active -->
                  <div class="text-center bs-wizard-stepnum">Receipt</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Your order confirmation. </div>
                </div>
            </div>
        
        </div>
        
        
        




<div class="row">


<c:choose>
	<c:when test="${cartLines != null}">
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 32%">Product</th>
					<th style="width: 22%">Brand</th>
					<th style="width: 12%">Price</th>
					<th style="width: 10%">Quantity</th>
					<th style="width: 24%" class="text-center">Subtotal</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach items="${cartLines}" var="cartline">
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
								</div>
							</div>
						</td>

						<td data-th="Brand">${cartline.getProduct().getBrand() }</td>

						<td data-th="Price">&#36;${cartline.getProduct().getUnitPrice() }</td>
						<td data-th="Quantity">
							${cartline.getProductCount()}</td>
						<td data-th="Subtotal" class="text-center">&#36;${cartline.getTotal() }</td>

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
						href="${pageContext.request.contextPath }/cart/show"
						class="btn btn-warning"><span
							class="glyphicon glyphicon-menu-left"></span>Go back </a></td>
					<td colspan="3" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>Total
							&#36;${accountModel.getCart().getTotal() }</strong></td>
					<td>
		
		<form method="post" action="${pageContext.request.contextPath }/checkout/confirm_cart">
					<button type="submit" class="btn btn-success btn-block">Shipping address
					<span class="glyphicon glyphicon-menu-right"></span></button>
					</form></td>
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
	</div>