
<div class="container" style="margin: auto;">

        <div class = "row">
            <div class="row bs-wizard" style="border-bottom:0;">
                
                <div class="col-xs-3 bs-wizard-step complete">
                  <div class="text-center bs-wizard-stepnum">Cart details</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Take a look at the products you are going to buy.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step complete">
                  <div class="text-center bs-wizard-stepnum">Shipping address</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Specify shipping address details.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step active"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Confirm & Pay</div>
                  <div class="progress"><div class="progress-bar"></div></div>
         <a class="bs-wizard-dot"></a>

                  <div class="bs-wizard-info text-center">Last chance to check whether information provided are correct. Enter your credit card details and pay.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled"><!-- active -->
                  <div class="text-center bs-wizard-stepnum">Receipt</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Your order confirmation. </div>
                </div>
            </div>
        
        </div>
        

	<div class="row">

		<div class="col-xs-12 col-sm-12 col-md-12" style="margin-top: 0;">

		<!-- 	<div class="col-xs-14 col-md-14"> -->


				<!-- ORDER ITEMS FORM STARTS HERE -->
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table" style="width: 100%;">
						<div class="row display-tr">
							<h3 class="panel-title display-td" style="padding: 5px;">Order
								items</h3>
							<div class="display-td">
								<!--  <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png"> -->
							</div>
						</div>
					</div>
					<div class="panel-body">
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

								<c:forEach items="${checkoutModel.getCartLines()}"
									var="cartline">
									<tr>
										<td data-th="Product">
											<div class="row">
												<div class="col-sm-2 hidden-xs">
													<img
														src="${pageContext.request.contextPath }/resources/images/${cartline.getProduct().getCode() }.jpg"
														alt="${cartline.getProduct().getName() }" class="orderImg" />
												</div>
												<div class="col-sm-10">
													<h4 class="nomargin">${cartline.getProduct().getName() }</h4>
												</div>
											</div>
										</td>

										<td data-th="Brand">${cartline.getProduct().getBrand() }</td>

										<td data-th="Price">&#36;${cartline.getProduct().getUnitPrice() }</td>
										<td data-th="Quantity">${cartline.getProductCount()}</td>
										<td data-th="Subtotal" class="text-center">&#36;${cartline.getTotal() }</td>

									</tr>

								</c:forEach>


							</tbody>
							<tfoot>
								<tr class="visible-xs">
									<td class="text-center"><strong>Total
											&#36;${checkoutModel.getCheckoutTotal() }</strong></td>
								</tr>
								<tr>
									<td></td>
									<td colspan="3" class="hidden-xs"></td>
									<td class="hidden-xs text-center"><strong>Total
											&#36;${checkoutModel.getCheckoutTotal() }</strong></td>

								</tr>
							</tfoot>
						</table>
					<!-- </div> -->
				</div>
			</div>

		<!-- 	<div class="col-xs-14 col-md-14"> -->


				<!-- SHIPPING ADDRESS FORM STARTS HERE -->
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table" style="width: 100%;">
						<div class="row display-tr">
							<h3 class="panel-title display-td" style="padding: 5px;">Shipping
								address</h3>
							<div class="display-td"></div>
						</div>
					</div>
					<div class="panel-body">
						<table id="cart" class="table table-hover table-condensed">
							<thead>
								<tr>
									<th style="width: 15%">First Name</th>
									<th style="width: 15%">Last Name</th>
									<th style="width: 15%">Street</th>
									<th style="width: 15%">City</th>
									<th style="width: 15%">Postal Code</th>
									<th style="width: 15%">Country</th>

								</tr>
							</thead>
							<tbody>

								<tr>
									<td data-th="First Name">${checkoutModel.getShipping().getFirstName() }</td>

									<td data-th="Last Name">${checkoutModel.getShipping().getLastName() }</td>

									<td data-th="Street">${checkoutModel.getShipping().getStreet() }</td>
									<td data-th="City">
										${checkoutModel.getShipping().getCity() }</td>
									<td data-th="Postal Code">${checkoutModel.getShipping().getPostalCode() }</td>
									<td data-th="Country">${checkoutModel.getShipping().getCountry() }</td>

								</tr>



							</tbody>
						</table>
					</div>
		<!-- 		</div> -->
			</div>

<!-- 
			<div class="col-xs-14 col-md-14"> -->


				<!-- CREDIT CARD FORM STARTS HERE -->
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table" style="width: 100%;">
						<div class="row display-tr">
							<h3 class="panel-title display-td">Payment Details</h3>
							<div class="display-td">
								<img class="img-responsive pull-right"
									src="http://i76.imgup.net/accepted_c22e0.png">
							</div>
						</div>
					</div>
					<div class="panel-body">
						<form role="form" id="payment-form" method="POST"
							action="${pageContext.request.contextPath }/checkout/receipt">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="cardNumber">CARD NUMBER</label>
										<div class="input-group">
											<input type="tel" class="form-control" name="cardNumber"
												placeholder="Valid Card Number" autocomplete="cc-number"
												required autofocus />
											<span class="input-group-addon"><i
												class="fa fa-credit-card"></i></span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span
											class="visible-xs-inline">EXP</span> DATE</label> <input type="tel"
											class="form-control" name="cardExpiry" placeholder="MM / YY"
											autocomplete="cc-exp" required />
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label for="cardCVC">CV CODE</label> <input type="tel"
											class="form-control" name="cardCVC" placeholder="CVC"
											autocomplete="cc-csc" required />
									</div>
								</div>
							</div>
							<div class="row">
								
					<div class="col-xs-12">
									<button type="submit" class="btn btn-success btn-lg btn-block"
										style="color: white;" type="button">
										Confirm & Pay <span class="glyphicon glyphicon-ok-circle"></span>
									</button>
								</div>
							</div>
							<div class="row" style="display: none;">
								<div class="col-xs-12">
									<p class="payment-errors"></p>
								</div>
							</div>
						</form>
						
							
			
					</div>
					</div>
				</div>
				<div class="col-xs-2" style="margin-bottom:20px">
					<form method="post" action="${pageContext.request.contextPath }/checkout/confirm_cart">
					<button type="submit" class="btn btn-warning btn-block"><span class="glyphicon glyphicon-menu-left"></span>Shipping address
					</button>
					</form>
					</div>
	<!-- 		
		</div> -->
	</div>
</div>