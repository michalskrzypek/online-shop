var $table = $('#products_table');

if($table.length){
	
	var jsonUrl = '';
	
	if(window.categoryId == ''){
		jsonUrl = window.contextRoot + '/json/data/all/products';
		console.log('YES');
	}else{
		jsonUrl = window.contextRoot + '/json/data/category/'+  window.categoryId +'/products';
		console.log('NO');
	}
	
	$table.DataTable({
		lengthMenu: [[3,5,10,-1],['3 Products', '5 Products', '10 Products', 'All']],
		pageLength:5,
		ajax:{
			url : jsonUrl,
			dataSrc : ''
		},
		columns: [
			{data : 'id'},
			{data : 'name'},
			{data : 'brand'},
			{data : 'unitPrice'},
			{data : 'quantity'}
		]
		
		
		
	});
	
	
}