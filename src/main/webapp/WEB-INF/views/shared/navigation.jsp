
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">OnlineShop
			by Michal Skrzypek</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/about">About</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/show/all/products">View
						products</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/contact">Contact</a></li>

				<security:authorize
					access="hasAuthority('MANAGER') and isAuthenticated()">

					<li class="nav-item"><a class="nav-link" style="text-shadow:1px 1px 1px red;"
						href="${pageContext.request.contextPath}/manage/products">! Product
							Management !</a></li>

				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="!isAuthenticated()">


					<li><a href="${pageContext.request.contextPath }/signup"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="${pageContext.request.contextPath }/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>


				</security:authorize>

				<security:authorize access="isAuthenticated()">


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span class="glyphicon glyphicon-user"></span>
							${accountModel.getFirstName() } </a>
						<ul class="dropdown-menu">
						
						<security:authorize access="hasAuthority('CUSTOMER')">
							<li><a href="${pageContext.request.contextPath }/cart/show"><span
									class="glyphicon glyphicon-shopping-cart"></span>
									<span class="badge">${accountModel.getCart().getCartLines() }</span> <span style="position: absolute; right:1em;">&#36;${accountModel.getCart().getTotal()}</span>
									</a></li>
							<li role="separator" class="divider"></li>


<li><sf:form method="post"
									action="${pageContext.request.contextPath }/profile/show">
									<button type="submit" class="btn btn-default"
										style="background-color: transparent; color: black; border: none;">
										<span class="glyphicon glyphicon-user"></span> Your profile
									</button>
								</sf:form></li>
								</security:authorize>
							<li><sf:form method="post"
									action="${pageContext.request.contextPath }/logout">
									<button type="submit" class="btn btn-default"
										style="background-color: transparent; color: black; border: none;">
										<span class="glyphicon glyphicon-log-out"></span> Logout
									</button>
								</sf:form></li>



						</ul></li>



					<!-- 	<li class="dropdown">
				<a href="javascript:void(0)"
					class="btn btn-default dropdown-toggle"
					id="drodownMenu1"
					data-toggle="dropdown">
					
					Hello Michal!
					<span class="caret"></span>
					</a>
					
					<ul class="dropdown-menu">
					<li>
					<a href="javascript:void(0)">
					<span class="glyphicon glyphicon-shopping-cat"></span>
					</a>
					</li>
					</ul>
				</li> -->

				</security:authorize>
			</ul>
		</div>
	</div>
</nav>