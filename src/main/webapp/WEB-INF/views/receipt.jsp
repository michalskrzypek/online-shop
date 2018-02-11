<div class="container">

        <div class = "row">
            <div class="row bs-wizard" style="border-bottom:0;">
                
                <div class="col-xs-3 bs-wizard-step complete">
                  <div class="text-center bs-wizard-stepnum">Cart details</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a  class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Take a look at the products you are going to buy.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step complete">
                  <div class="text-center bs-wizard-stepnum">Shipping address</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Specify shipping address details.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step complete"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Confirm & Pay</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Last chance to check whether information provided are correct. Enter your credit card details and pay.</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step active"><!-- active -->
                  <div class="text-center bs-wizard-stepnum">Receipt</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Your order confirmation. </div>
                </div>
            </div>
        
        </div>
        

	<div class="row">

		<div
			class="receipt-main col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
			<div class="row">
				<div class="receipt-header">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<div class="receipt-left">
							<img class="img-responsive" alt="No Photo available"
								src="${images }/Account_${checkoutModel.getAccount().getId()}"
								style="width: 71px; border-radius: 43px;">
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 text-right">
						<div class="receipt-right">
							<h5>Shipping address.</h5>
							<p>
								<b>First name:</b> ${shipping.getFirstName() } 
							</p>
							<p>
								<b>Last name:</b> ${shipping.getLastName() } 
							</p>
							<p>
								<b>Street:</b> ${shipping.getStreet() }  
							</p>
							<p>
								<b>City:</b> ${shipping.getCity() }  
							</p>
							<p>
								<b>Postal code:</b> ${shipping.getPostalCode() }
							
							</p>
							<p>
								<b>Country:</b> ${shipping.getCountry() }  
							</p>

						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="receipt-header receipt-header-mid">
					<div class="col-xs-8 col-sm-8 col-md-8 text-left">
						<div class="receipt-right">
							<h5>
							${checkoutModel.getAccount().getFirstName() } ${checkoutModel.getAccount().getLastName() }
							</h5>
							<p>
								<b>Mobile :</b> ${checkoutModel.getAccount().getPhoneNumber() }
							</p>
							<p>
								<b>Email :</b> ${checkoutModel.getAccount().getEmail() }
							</p>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="receipt-left">
							<h1>Receipt</h1>
						</div>
					</div>
				</div>
			</div>

			<div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Item</th>
							<th>Quantity</th>
							<th>Unit Price</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${items }" var="item">
							<tr>
								<td class="col-md-9">${item.getProduct().getName()} <b>${item.getProduct().getBrand() }
								</b></td>
								<td class="col-md-3"><i class="fa fa-inr"></i>
									${item.getProductCount()}</td>
								<td class="col-md-3"><i class="fa fa-inr"></i>
									${item.getPrice()}</td>
							</tr>
						</c:forEach>

						<tr>

							<td class="text-right"><h2>
									<strong>Total: </strong>
								</h2></td>
							<td class="text-left text-danger"><h2>
									<strong><i class="fa fa-inr"></i>
										${checkoutModel.getOrderDetail().getTotal() }</strong>
								</h2></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="row">
				<div class="receipt-header receipt-header-mid receipt-footer">
					<div class="col-xs-8 col-sm-8 col-md-8 text-left">
						<div class="receipt-right">
							<p>
								<b>Date :</b> ${checkoutModel.getOrderDetail().getOrderDate() }
							</p>
							<h5 style="color: rgb(140, 140, 140);">Thank you for
								shopping with us!</h5>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="receipt-left">
							<h3>OnlineShop by Michal Skrzypek</h3>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>