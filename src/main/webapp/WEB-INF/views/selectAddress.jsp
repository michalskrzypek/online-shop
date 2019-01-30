
<div class="container" style="margin: auto;">

	<div class="row">
		<div class="row bs-wizard" style="border-bottom: 0;">

			<div class="col-xs-3 bs-wizard-step complete">
				<div class="text-center bs-wizard-stepnum">Cart details</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">Take a look at the
					products you are going to buy.</div>
			</div>

			<div class="col-xs-3 bs-wizard-step active">
				<div class="text-center bs-wizard-stepnum">Shipping address</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">Specify shipping
					address details.</div>
			</div>

			<div class="col-xs-3 bs-wizard-step disabled">
				<!-- complete -->
				<div class="text-center bs-wizard-stepnum">Confirm & Pay</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">Last chance to check
					whether information provided are correct. Enter your credit card
					details and pay.</div>
			</div>

			<div class="col-xs-3 bs-wizard-step disabled">
				<!-- active -->
				<div class="text-center bs-wizard-stepnum">Receipt</div>
				<div class="progress">
					<div class="progress-bar"></div>
				</div>
				<a class="bs-wizard-dot"></a>
				<div class="bs-wizard-info text-center">Your order
					confirmation.</div>
			</div>
		</div>

	</div>

	<c:if test="${not empty message }">
	<div class="alert alert-warning">
							<strong>${message }</strong>
						</div>
						</c:if>


	<div class="row">

		<div class="col-xs-10 col-sm-6 col-md-6">
			<div class="page-header">
				<h2>Select shipping address</h2>
			</div>
			<form method="post"
				action="${pageContext.request.contextPath }/checkout/select_address">
				<div class="well well-sm">
					<div class="row">

						<div class="col-sm-8 col-md-10">

							<c:forEach items="${shippingAddresses}" var="address">

								<div class="form-group ">
									<input name="address" type="radio" value="${address.getId() }">
									<label for="radio100"></label>
									<table style="border: none;">
										<tr>
											<td style="text-align: right;"><b>First name:</b></td>
											<td style="text-align: left;"><i>
													${address.getFirstName() }</i></td>
										</tr>
										<tr>
											<td style="text-align: right;"><b>Last name:</b></td>
											<td style="text-align: left;"><i>
													${address.getLastName() }</i></td>
										</tr>
										<tr>
											<td style="text-align: right;"><b>Street:</b></td>
											<td style="text-align: left;"><i>${address.getStreet() }</i></td>
										</tr>
										<tr>
											<td style="text-align: right;"><b>City:</b></td>
											<td style="text-align: left;"><i>${address.getCity() }</i></td>
										</tr>
										<tr>
											<td style="text-align: right;"><b>Postal Code:</b></td>
											<td style="text-align: left;"><i>${address.getPostalCode() }</i></td>
										</tr>
										<tr>
											<td style="text-align: right;"><b>Country:</b></td>
											<td style="text-align: left;"><i>${address.getCountry() }</i></td>
										</tr>
									</table>

								</div>
							</c:forEach>


						</div>

					</div>
				</div>
				<div style="float: left;">
					<a href="${pageContext.request.contextPath }/checkout/cart_details"
						class="btn btn-warning btn-block"> <span
						class="glyphicon glyphicon-menu-left"></span>Go back
					</a>
				</div>

				<div style="float: right;">

					<button type="submit" class="btn btn-success btn-block">
						Select address <span class="glyphicon glyphicon-menu-right"></span>
					</button>


				</div>
			</form>
		</div>



		<!--  Adding new address -->
		<div class="col-xs-10 col-sm-6 col-md-6">
			<div class="page-header">
				<h2>or add new address</h2>
			</div>
			<div class="well well-sm">
				<div class="row">

					<div class="col-sm-8 col-md-12">

						<div class="main-login main-center">

							<sf:form method="post"
								action="${pageContext.request.contextPath}/checkout/add/address"
								modelAttribute="address">

								<div class="form-group">
									<label for="firstName" class="cols-sm-2 control-label">First
										Name</label>
									<div class="cols-sm-12">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="firstName"
												id="firstName" placeholder="First Name..." />
											<sf:errors path="firstName" cssClass="help-block"
												element="em" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="lastName" class="cols-sm-2 control-label">Last
										Name</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="lastName"
												id="lastName" placeholder="Last Name..." />
											<sf:errors path="lastName" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="street" class="cols-sm-2 control-label">Street</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="street"
												id="street" placeholder="Street..." />
											<sf:errors path="street" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="city" class="cols-sm-2 control-label">City</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="city"
												id="city" placeholder="City..." />
											<sf:errors path="city" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="postalCode" class="cols-sm-2 control-label">Postal
										Code</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="postalCode"
												id="email" placeholder="Postal Code..." />
											<sf:errors path="postalCode" cssClass="help-block"
												element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="Country" class="cols-sm-2 control-label">Country</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-envelope fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="country"
												id="phoneNumber" placeholder="Country..." />
											<sf:errors path="country" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<sf:hidden path="id" />
								<sf:hidden path="shipping" />
								<sf:hidden path="billing" />


								<div class="form-group ">
									<input type="submit" id="button"
										class="btn btn-primary btn-lg btn-block login-button"
										value="Add address" />
								</div>

							</sf:form>
						</div>



					</div>
				</div>
			</div>
		</div>
	</div>
</div>