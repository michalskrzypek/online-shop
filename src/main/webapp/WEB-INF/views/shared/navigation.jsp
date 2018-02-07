
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
					
					<security:authorize access="hasAuthority('MANAGER') and isAuthenticated()">
					
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/manage/products">Product
						Management</a></li>
						
						</security:authorize>
			</ul>


			<security:authorize access="!isAuthenticated()">

				<ul class="nav navbar-nav navbar-right ml-auto">
					<li><a href="${pageContext.request.contextPath }/signup"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="${pageContext.request.contextPath }/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>

			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<sf:form method="post"
					action="${pageContext.request.contextPath }/logout">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-log-out"></span> Logout
							</button>
							</li>
					</ul>
				</sf:form>
			</security:authorize>
		</div>
	</div>
</nav>