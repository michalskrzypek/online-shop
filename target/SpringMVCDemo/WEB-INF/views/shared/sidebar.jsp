
<div class="col-lg-3">

	<h1 class="my-4">OnlineShop</h1>
	<div class="list-group">
		<c:forEach items="${categories}" var="category">
			<a
				href="${pageContext.request.contextPath}/show/category/${category.getId()}/products"
				class="list-group-item">${category.getName()}</a>
		</c:forEach>
	</div>

</div>