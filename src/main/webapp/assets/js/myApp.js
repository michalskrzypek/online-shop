var $table = $('#products_table');

if($table.length){
	
	var jsonUrl = '';
	
	if(window.categoryId == ''){
		jsonUrl = window.contextRoot + '/json/data/all/products';
	}else{
		jsonUrl = window.contextRoot + '/json/data/category/'+  window.categoryId +'/products';
	}
	
	$table.DataTable({
		lengthMenu: [[3,5,10,-1],['3 Products', '5 Products', '10 Products', 'All']],
		pageLength:5,
		ajax:{
			url : jsonUrl,
			dataSrc : ''
		},
		columns: [
			{data: 'code',
				mRender: function(data, type, row){
					var src = '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';	
					return src;
				}
				
			
			},
			
			{data : 'name'},
			{data : 'brand'},
			{data : 'unitPrice',
				mRender: function(data, type, row){
					return '&#36;'+data
				}
			},
			{data : 'id',
				mRender: function(data, type,row){
					
					var str ='<a href="'+ window.contextRoot+'/show/product/'+data+'" class="btn btn-secondary"><span class="glyphicon glyphicon-eye-open"></span></a>';
					return str;
				}	
				},
			{data: 'id',
			mRender: function(data,type,row){
				if(row.quantity == 0){
					var str = '<a href="';
					str+='" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					return str;
				}else{
					var str = '<a href="';
					str+=window.contextRoot+'/cart/add/product/'+data+'" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					return str;
				}

			}	
			
			}
			
		]
		
		
		
	});
	
	
}