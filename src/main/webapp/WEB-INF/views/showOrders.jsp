
<div class="container">
	<div class="row">

		<div class="col-xs-12 col-sm-12 col-md-12" style="margin-top: 0;">

			<!-- 	<div class="col-xs-14 col-md-14"> -->


			<!-- ORDER ITEMS FORM STARTS HERE -->
			<div class="panel panel-default credit-card-box">
				<div class="panel-heading display-table" style="width: 100%;">
					<div class="row display-tr">
						<h3 class="panel-title display-td" style="padding: 5px;">Orders
							history</h3>
						<div class="display-td"></div>
					</div>
				</div>
				<div class="panel-body">
					<table id="cart" class="table table-hover table-condensed">
						<thead>
							<tr>
								<th style="width: 15%">Order ID</th>
								<th style="width: 25%">Order Date</th>
								<th style="width: 35%">Products</th>
								<th style="width: 25%">Total</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${orders}" var="order">
								<tr>
									<td data-th="Order ID">${order.getId() }</td>

									<td data-th="Order Date">${order.getOrderDate().toString().substring(0, 10) }</td>

									<td data-th="Products"><c:forEach
											items="${orderDAO.listAllItems(order.getId()) }" var="item">
										
										Name: <b><i>${item.getProduct().getName() }</i></b>
										<br>
Price: <i>${item.getPrice() }</i>
<br>
Quantity: <i>${item.getProductCount() }</i> 
<br>
<br>

										</c:forEach></td>
									<td data-th="Total">${order.getTotal()}</td>


								</tr>

							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>