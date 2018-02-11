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
				<h2> Customer details </h2>
			</div>
            <div class="well well-sm">
                <div class="row">

                   
								
					                    <div class="col-sm-6 col-md-8">
                        <h4>
                            ${account.getFirstName()} ${account.getLastName()}</h4>
                              <p>
                            <i class="glyphicon glyphicon-envelope"></i> ${account.getEmail() }
                            <br />
                            
                            <i class="glyphicon glyphicon-phone"></i>${account.getPhoneNumber() }
                            </p>
                            
                            
                            <c:if test="${billingAddress != null }">
                        <small><cite>Street: ${billingAddress.getStreet() }<br>City: ${billingAddress.getCity() }<br>Postal Code: ${billingAddress.getPostalCode() }<br>Country: ${billingAddress.getCountry() }</cite></small>
                      <form action="${pageContext.request.contextPath}/profile/update/address">
                         <button type="submit" class="btn btn-primary">
                                Update address</button>
                                </form>
                        </c:if>
                        
                        
                         <c:if test="${billingAddress == null }">
                         <em class="help-block">No billing address available!</em>
                         <a href="${pageContext.request.contextPath}/profile/add/address?address=billing">
                         <span class="btn btn-primary">
                                Add address</span></a>
                                
                         </c:if>
                         
                         <br>
                         <br>
                      
                            <br />
                    </div>
                </div>
            </div>
        </div>
        
        
        

            
    </div>

	