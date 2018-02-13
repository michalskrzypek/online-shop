<div class="container">
	<div class="row">

		<div class="col-md-offset-2 col-md-8">
			<c:if test="${not empty message}">
				<div class="alert alert-success">
					<b>Info!</b> ${message }
				</div>
			</c:if>


		</div>
	</div>
	<div class="row">

		<!-- Account Info  -->
		<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="page-header">
				<h2>Profile Information</h2>
			</div>
			<div class="well well-sm">
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<img src="${images}/Account_${account.getId()}.jpg"
							alt="No photos available!"
							class="img-rounded img-responsive profileImg" /> <br>

					</div>
					<br> <br>


					<div class="col-sm-6 col-md-8">
						<h4>${account.getFirstName()} ${account.getLastName()}</h4>
						<p>
							<i class="glyphicon glyphicon-envelope"></i> ${account.getEmail() }
							<br /> <i class="glyphicon glyphicon-phone"></i>${account.getPhoneNumber() }
						</p>


						<c:if test="${billingAddress != null }">
							<small><cite>Street: ${billingAddress.getStreet() }<br>City:
									${billingAddress.getCity() }<br>Postal Code:
									${billingAddress.getPostalCode() }<br>Country:
									${billingAddress.getCountry() }
							</cite></small>

						</c:if>


						<c:if test="${billingAddress == null }">
							<em class="help-block">No billing address available!</em>

						</c:if>

						<br> <br> <br />
					</div>

					<div class="col-sm-12 col-md-12">



<!--  LIST OF ACTIONS -->

						<div class="list-group">

							<form
								action="${pageContext.request.contextPath }/profile/addPhoto"
								method="post" enctype="multipart/form-data">
								<input type="file" name="file" id="file" />
								<button type="submit" class="list-group-item">Upload
									photo</button>
							</form>

							<c:choose>

								<c:when test="${billingAddress != null }">
									<a
										href="${pageContext.request.contextPath}/profile/update/address"
										class="list-group-item">Update billing address</a>
								</c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/profile/add/address?address=billing"
										class="list-group-item">Add billing address</a>

								</c:otherwise>
							</c:choose>
							
							<a
										href="${pageContext.request.contextPath}/profile/show/orders"
										class="list-group-item">Your orders</a>


						</div>

					</div>



				</div>
			</div>
		</div>




		<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="page-header">
				<h2>Shipping Addresses</h2>
			</div>
			<div class="well well-sm">
				<div class="row">

					<div class="col-sm-6 col-md-8">

						<c:choose>

							<c:when
								test="${shippingAddresses == null or shippingAddresses.size() == 0}">

								<div>
									<em class="help-block">You have no shipping addresses.</em>
								</div>

								<a
									href="${pageContext.request.contextPath}/profile/add/address?address=shipping"><span
									class="btn btn-primary"> Add address</span></a>


							</c:when>
							<c:otherwise>

								<c:forEach items="${shippingAddresses}" var="address">

									<h4 style="margin-top: 10px;">Address:</h4>
									<p><b>First Name:</b><i> ${address.getFirstName() }</i><br>
									<b>Last Name:</b><i> ${address.getLastName() }</i><br>
										<b>Street:</b><i> ${address.getStreet() }</i><br> <b>City:</b><i>
											${address.getCity() }</i><br> <b>Postal Code:</b><i>
											${address.getPostalCode() }</i><br> <b>Country:</b><i>
											${address.getCountry() }</i><br>

									</p>
								</c:forEach>
								<br>
								<a
									href="${pageContext.request.contextPath}/profile/add/address?address=shipping"><span
									class="btn btn-primary"> Add another address</span></a>

							</c:otherwise>


						</c:choose>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
