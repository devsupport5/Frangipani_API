
$( document ).ready(function() {
	getCart();
});


function addToCart(orderId){
	$.ajax({
		type : "POST", 
		url : "<%=request.getContextPath()%>/addToCart",
		data : {
			orderId : orderId,
			qty : 1, 
		},success:function(data){
			 
			getCart();
		},error : function(e){
			console.log("Error :::"+e)
		}
	}); 
}

function getCart(){
	$.ajax({
		type : "POST", 
		url : "<%=request.getContextPath()%>/getCart",
		data : {
		},success:function(data){
			var cartTotal = "";
			var cartData = "0";
			var cartFinalTotal = "0";  
			if(data.length > 0){	
				for (var i = 0; i < data.length; i++) {
					cartData += '<li class="item">'+
					'<a href="#" class="preview-image">'+
					'<img class="preview" src="'+data[i].image+'" alt="">'+
					'</a>'+
					'<div class="description">'+ 
					'<a href="#"> '+data[i].bookTitle+'</a>'+ 
					'<strong class="price"> '+data[i].qty+' x '+data[i].price+' </strong> '+
					'</div>'+
					'</li> <br /> '; 
					  
					cartTotal = data[i].qty * data[i].price; 
					cartFinalTotal = parseInt(cartTotal) + parseInt(cartFinalTotal);					   
				}  
			}else{
				cartData = "Cart is empty";
			}
			
			 
			$("#cartData").html(cartData);
			$("#cartTotal").html(cartFinalTotal);
			$("#cateItemTotal").html(data.length);
		},error : function(e){ 
			console.log("Error :::"+e)
		}
	});

}