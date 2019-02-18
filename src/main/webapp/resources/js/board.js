function orderSubmit(order){
	order = order > 0 ? 0 : 1;
	
	$("input[name='orderById']").val(order);
	$("form").submit();
}
function movePage(page){
	$("input[name='page']").val(page);
	$("form").submit();
}