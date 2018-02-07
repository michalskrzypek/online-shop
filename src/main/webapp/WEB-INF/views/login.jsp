<div class="col-xs-offset-2 col-xs-4" style="margin: auto">
	<div class="main-login main-center">

		<sf:form method="post"
			action="${pageContext.request.contextPath }/authenticate">


			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<strong>Invalid username or password!</strong>
				</div>
			</c:if>

			<div class="form-group">
				<label for="email" class="cols-sm-2 control-label">Your
					Email</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa"
							aria-hidden="true"></i></span> <input type="text" class="form-control"
							name="username" id="email" placeholder="Email" />

					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="cols-sm-2 control-label">Password</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock fa-lg"
							aria-hidden="true"></i></span> <input type="password"
							class="form-control" name="password" id="password"
							placeholder="Enter your Password" />
					</div>
				</div>
			</div>


			<div class="form-group ">
				<input type="submit" id="button"
					class="btn btn-primary btn-lg btn-block login-button" value="Login" />
			</div>

		</sf:form>
	</div>

</div>
