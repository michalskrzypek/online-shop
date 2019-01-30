<div class="content">
	<div class="container">
		<div class="row">
			<div class="col-xs-offset-2 col-xs-4" style="margin: auto">
				<div class="main-login main-center">

					<sf:form method="post"
						action="${pageContext.request.contextPath}/profile/update/address"
						modelAttribute="address">

						<div class="form-group">
							<label for="firstName" class="cols-sm-2 control-label">First
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<sf:input type="text" class="form-control" path="firstName"
										id="firstName" placeholder="First Name..." />
									<sf:errors path="firstName" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="lastName" class="cols-sm-2 control-label">Last
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
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
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
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
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
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
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<sf:input type="text" class="form-control" path="postalCode"
										id="email" placeholder="Postal Code..." />
									<sf:errors path="postalCode" cssClass="help-block" element="em" />
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
						<sf:hidden path="billing" value="true" />

						<div class="form-group ">
							<input type="submit" id="button"
								class="btn btn-primary btn-lg btn-block login-button"
								value="Confirm" />
						</div>

					</sf:form>
				</div>

			</div>
		</div>
	</div>
</div>