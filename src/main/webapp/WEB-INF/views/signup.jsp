<div class="col-xs-offset-2 col-xs-4" style="margin: auto">
						<div class="main-login main-center">

							<sf:form method="post"
								action="${pageContext.request.contextPath}/signup"
								modelAttribute="account">

								<div class="form-group">
									<label for="firstName" class="cols-sm-2 control-label">Your
										First Name</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="firstName"
												id="firstName" placeholder="First Name" />
													<sf:errors path="firstName" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="firstName" class="cols-sm-2 control-label">Your
										Last Name</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="lastName"
												id="lastName" placeholder="Last Name" />
													<sf:errors path="lastName" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

												<div class="form-group">
									<label for="email" class="cols-sm-2 control-label">Your
										Email</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<sf:input type="text" class="form-control" path="email"
												id="email" placeholder="Email" />
													<sf:errors path="email" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="password" class="cols-sm-2 control-label">Password</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <sf:input
												type="password" class="form-control" path="password"
												id="password" placeholder="Enter your Password" />
													<sf:errors path="password" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="cols-sm-2 control-label">Your
										Phone Number</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-envelope fa" aria-hidden="true"></i></span> <sf:input
												type="text" class="form-control" path="phoneNumber"
												id="phoneNumber" placeholder="Enter your number" />
													<sf:errors path="phoneNumber" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<fieldset class="form-group">
									<div class="form-check">
										<label class="radio-inline">
										<sf:radiobutton path="userRole" value="CUSTOMER"/> Customer</label>
										<label class="radio-inline"><sf:radiobutton path="userRole" value="MANAGER"/> Manager</label>

									</div>



								</fieldset>
	<sf:hidden path="id" />

								<div class="form-group ">
									<input type="submit" id="button"
										class="btn btn-primary btn-lg btn-block login-button" value="Register"/>
								</div>

							</sf:form>
						</div>

					</div>