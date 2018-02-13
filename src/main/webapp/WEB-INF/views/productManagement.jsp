<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">

		<div class="col-md-offset-2 col-md-8">
			<c:if test="${not empty message }">
				<div class="alert alert-info">
					<strong>Info!</strong> ${message }
				</div>
			</c:if>

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${pageContext.request.contextPath}/manage/products"
						method="post" enctype="multipart/form-data">


						<div class="form-group">
							<label class="control-label col-md-4">Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>


						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Brand:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>


						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product
								Description:</label>
							<div class="col-md-8">
								<sf:textarea rows="5" cols="10" path="description"
									class="form-control" placeholder="Product Description" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>


						</div>

						<div class="form-group" style="margin: 0">
							<label class="control-label col-md-4">Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId" style="height: 40px"
									items="${categories }" itemLabel="name" itemValue="id" />
							</div>
						</div>
						<div class="text-right" style="margin: 10px; padding: 0">
							<button type="button" class="btn btn-warning" data-toggle="modal"
								data-target="#addCategoryModal">Add Category</button>
						</div>
						<br>
						<div class="form-group">
							<label class="control-label col-md-4">Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Unit price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Quantity" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Product image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="multipartFile" class="form-control" />
							</div>
						</div>

						<sf:hidden path="id" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
						<sf:hidden path="active" />
						<br>
						<div class="text-center">
							<c:if test="${product.getId() == 0}">
								<input type="submit" class="btn btn-primary btn-lg"
									value="Add Product">
							</c:if>

							<c:if test="${product.getId() != 0}">
								<input type="submit" class="btn btn-primary btn-lg"
									value="Update Product">
							</c:if>
						</div>
					</sf:form>

				</div>

			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="container">
		<div class="row">
			<!-- Modal -->
			<div class="modal fade" id="addCategoryModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title align-left">Add new category</h4>
						</div>
						<div class="modal-body">
							<sf:form id="categoryForm"
								action="${pageContext.request.contextPath }/manage/category/add"
								modelAttribute="category" method="POST">

								<div class="form-group">
									<label class="control-label col-md-4">Name</label>
									<div class="col-md-8 validate">
										<sf:input type="text" path="name" class="form-control"
											placeholder="Category Name" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4">Description</label>
									<div class="col-md-8 validate">
										<sf:textarea path="description" class="form-control"
											placeholder="Enter category description here!" />
									</div>
								</div>


								<div class="form-group">
									<div class="col-md-offset-4 col-md-4">
										<input type="submit" name="submit" value="Save"
											class="btn btn-primary" />
									</div>
								</div>
							</sf:form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>







	<div class="col-xs-12">

		<table id="admin_products_table"
			class="table table-striped table-bordered">

			<thead>

				<tr>
					<th>ID</th>
					<th></th>
					<th>Name</th>
					<th>Brand</th>
					<th>Price in &#36;</th>
					<th>Quantity</th>
					<th></th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

			</thead>

		</table>

	</div>












</div>