
	
	<div class="container">

		<div class="row">
		<%-- 	<%@include file="shared/sidebar.jsp" %> --%>
		
			<div class="col-xs-12">
		<ol class="breadcrumb">
		
		<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
		<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/show/all/products">All products</a></li>
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/show/category/${category.getId() }/products">${category.getName() }</a></li>
		<li class="breadcrumb-item active">${product.getName() }</li>
		</ol>
</div>
</div>
<div class="row">
<div class="page-header">
  <h1>${product.getBrand()} ${product.getName()}</h1>
   </div>
   </div>
   <div class="row">
<div class="float-left" ><img src="${pageContext.request.contextPath }/resources/images/${product.getCode() }.jpg" class="img-fluid" alt="Responsive image"></div> 

<div class="col-xs-9">

		<div class="jumbotron">
		
   <p class="lead">${product.getDescription()}</p>
  <hr class="my-2">
  <p>$${product.getUnitPrice()}</p>
<br>
 <c:choose>
  <c:when test="${product.getQuantity() > 0}">
      <p>
  Quantity available: ${product.getQuantity() }</p>
  <p class="lead">
    <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath }/cart/add/product/${product.getId()}" role="button">Add to cart!</a>
    <a class="btn btn-secondary btn-lg" href="${pageContext.request.contextPath }/show/all/products" role="button">Continue shopping</a>
  </p>
  </c:when>
  <c:otherwise>
      <p style="color:red">
  Out of stock!</p>
  <p class="lead">
    <a class="btn btn-success btn-lg disabled" href="${pageContext.request.contextPath }/cart/add/product/${product.getId()}" role="button">Add to cart!</a>
    <a class="btn btn-secondary btn-lg" href="${pageContext.request.contextPath }/show/all/products" role="button">Continue shopping</a>
  </p>
  </c:otherwise>
  </c:choose>
  
</div>
		</div>
		
		</div>
		
		</div>