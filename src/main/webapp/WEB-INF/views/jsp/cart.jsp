<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Cart | Frangipani Books </title>

<meta http-equiv="ScreenOrientation" content="autoRotate:disabled">
<meta name="theme-color" content="#ED008C">

<link rel="apple-touch-icon" sizes="152x152" href="resources/images/favicon/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicon/favicon-16x16.png">
<link rel="manifest" href="resources/images/favicon/site.webmanifest">
<link rel="mask-icon" href="resources/images/favicon/safari-pinned-tab.svg" color="#5bbad5">
<meta name="msapplication-TileColor" content="#da532c">
<meta name="theme-color" content="#ffffff">
 

<!-- Font Awesome -->
<link rel="stylesheet" href="resources/font-awesome-4.7.0/css/font-awesome.min.css">                

<!-- CSS  -->
<link href="resources/css/custom.css" rel="stylesheet">
<link href="resources/css/color.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<link href="resources/css/owl.carousel.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/all.min.css" rel="stylesheet">

<!--<link href="css/cart.css" rel="stylesheet">-->
<!-- CSS  -->

<style>
.center{
width: 150px;
margin: 40px auto;

}
</style>

<!-- includes js File START-->
<script src="resources/js/w3data.js"></script>
<!-- includes js File END-->

</head>
<body>

<div class="wrapper">

<!--/header START-->
<%@include file="includes/header.jsp" %>
<!--/header END-->



<!--Inner Header Start-->
<section class="wf100 inner-header">
<div class="container">
<ul> 
<li><a href="<%=request.getContextPath()%>/">Home</a></li>
<li><a href="#"> Cart </a></li>
</ul>
</div>
</section>
<!--Inner Header End--> 



<!--Inner Header Start-->
<section style="background-color: #e9ecef9c;     padding: 5em 0em 10em 0em;" class="wf100 ">

<div class="container">
<div class="row">
<div class="box box-default">
<div style="text-align: center;"> ${error }</div>

<c:if test="${fn:length(error) eq 0 }">



<div class="box-header with-border">
<h3 class="box-title"> My Cart (03) </h3>
</div>
		
<div class="box-body">
<div class="table-responsive">
<table class="table table-bordered">
<thead>
<tr>
<th> Product </th>
<th  class="text-right"> Price </th>
<th class="text-center" style="width: 12%;"> Quantity </th>
<th  class="text-right"> Total </th>
<th  class="text-right">  </th>
</tr>
</thead>
<tbody>
 

<c:forEach items="${cartList }" var="cartList">
<tr>

<td>
<div class="widget-thumb">
<a href="#"><img src="images/books/1.jpg" alt=""></a>
</div>
<div class="widget-content">
<h5><a href="#"> ${cartList.bookTitle } </a></h5>
<span> <strong>Author:</strong> ${cartList.authorName } </span> <br>
<span> <strong>Book Category:</strong> ${cartList.categoryName }  </span>
</div>
<div class="clearfix"></div>
</td>

<td class="text-right"> ${cartList.price } </td>

<td>
<div class="input-group">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-minus"></i>
</button>
</span>

<input style="height: auto; padding: 0px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="${cartList.qty }" min="1" max="10">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-plus"></i>
</button>
</span>

</div>
</td>

<td class="text-right"> ${cartList.qty * cartList.price } </td>

<td class="text-right remove"> 
<a href="#" onclick="removeToCart(${cartList.orderId})">
<i class="fa fa-trash"></i> 
</a>
</td>

</tr>
</c:forEach>
<!-- <tr>

<td>
<div class="widget-thumb">
<a href="#"><img src="images/books/1.jpg" alt=""></a>
</div>
<div class="widget-content">
<h5><a href="#"> Things Every Child Show Know About J.B .Danquah </a></h5>
<span> <strong>Author:</strong> Abyna-Ansaa Adjei </span> <br>
<span> <strong>Book Category:</strong> Drama, Romance </span>
</div>
<div class="clearfix"></div>
</td>

<td class="text-right"> ₵40.00 </td>

<td>
<div class="input-group">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-minus"></i>
</button>
</span>

<input style="    height: auto; padding: 0px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="1" min="1" max="10">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-plus"></i>
</button>
</span>

</div>
</td>

<td class="text-right"> ₵40.00 </td>

<td class="text-right remove"> 
<a href="#">
<i class="fa fa-trash"></i> 
</a>
</td>

</tr>


<tr>

<td>
<div class="widget-thumb">
<a href="#"><img src="images/books/1.jpg" alt=""></a>
</div>
<div class="widget-content">
<h5><a href="#"> Things Every Child Show Know About J.B .Danquah </a></h5>
<span> <strong>Author:</strong> Abyna-Ansaa Adjei </span> <br>
<span> <strong>Book Category:</strong> Drama, Romance </span>
</div>
<div class="clearfix"></div>
</td>

<td class="text-right"> ₵40.00 </td>

<td>
<div class="input-group">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-minus"></i>
</button>
</span>

<input style="    height: auto; padding: 0px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="1" min="1" max="10">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-plus"></i>
</button>
</span>

</div>
</td>

<td class="text-right"> ₵40.00 </td>

<td class="text-right remove"> 
<a href="#">
<i class="fa fa-trash"></i> 
</a>
</td>

</tr>
 --> 
</tbody>

<tfoot>
<tr>

<td colspan="3" class="text-right"><strong> Subtotal:  </strong> </td>
<td class="text-right"><strong> ₵80.00 </strong></td>
<td>  </td>

</tr>

<tr>

<td colspan="3" class="text-right"><strong> Total: </strong> </td>
<td class="text-right"><strong> �80.00 </strong></td>
<td>  </td>

</tr>

</tfoot>


</table>
</div>
</div><!-- /.box-body -->
</c:if>
 
<div class="box-footer">
<a class="checkout-btn" href="checkout"> Place Order </a>
</div>

</div><!-- /.box -->
</div>



</div>


</section>
<!--Inner Header End--> 



<!--/#footer START-->
<%@include file="includes/footer.jsp" %>
<!--/#footer END-->

</div>
 

<!--   JS Files Start  --> 
<script src="resources/js/jquery-3.3.1.min.js"></script> 
<script src="resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="resources/js/popper.min.js"></script> 
<script src="resources/js/bootstrap.min.js"></script> 
<script src="resources/js/owl.carousel.min.js"></script> 
<script src="resources/js/jquery.prettyPhoto.js"></script> 
<script src="resources/js/isotope.min.js"></script> 
<script src="resources/js/custom.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script> 



<script>
//plugin bootstrap minus and plus
//http://jsfiddle.net/laelitenetwork/puJ6G/
$('.btn-number').click(function(e){
e.preventDefault();

fieldName = $(this).attr('data-field');
type      = $(this).attr('data-type');
var input = $("input[name='"+fieldName+"']");
var currentVal = parseInt(input.val());
if (!isNaN(currentVal)) {
if(type == 'minus') {

if(currentVal > input.attr('min')) {
input.val(currentVal - 1).change();
} 
if(parseInt(input.val()) == input.attr('min')) {
$(this).attr('disabled', true);
}

} else if(type == 'plus') {

if(currentVal < input.attr('max')) {
input.val(currentVal + 1).change();
}
if(parseInt(input.val()) == input.attr('max')) {
$(this).attr('disabled', true);
}

}
} else {
input.val(0);
}
});
$('.input-number').focusin(function(){
$(this).data('oldValue', $(this).val());
});
$('.input-number').change(function() {

minValue =  parseInt($(this).attr('min'));
maxValue =  parseInt($(this).attr('max'));
valueCurrent = parseInt($(this).val());

name = $(this).attr('name');
if(valueCurrent >= minValue) {
$(".btn-number[data-type='minus'][data-field='"+name+"']").removeAttr('disabled')
} else {
alert('Sorry, the minimum value was reached');
$(this).val($(this).data('oldValue'));
}
if(valueCurrent <= maxValue) {
$(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
} else {
alert('Sorry, the maximum value was reached');
$(this).val($(this).data('oldValue'));
}


});
$(".input-number").keydown(function (e) {
// Allow: backspace, delete, tab, escape, enter and .
if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
// Allow: Ctrl+A
(e.keyCode == 65 && e.ctrlKey === true) || 
// Allow: home, end, left, right
(e.keyCode >= 35 && e.keyCode <= 39)) {
// let it happen, don't do anything
return;
}
// Ensure that it is a number and stop the keypress
if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
e.preventDefault();
}
});
</script>

<script type="text/javascript">
function removeToCart(orderId){
	$.ajax({
		type : "POST", 
		url : "<%=request.getContextPath()%>/removeToCart",
		data : {
			orderId : orderId
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
			
			var cartData = "";
			if(data.length > 0){	
				for (var i = 0; i < data.length; i++) {
					cartData += '<li class="item">'+
					'<a href="#" class="preview-image">'+
					'<img class="preview" src="<%=request.getContextPath() %>/resources/images/books/1.jpg" alt="">'+
					'</a>'+
					'<div class="description">'+ 
					'<a href="#"> '+data[i].bookTitle+'</a>'+ 
					'<strong class="price"> '+data[i].qty+' x '+data[i].price+' </strong> '+
					'</div>'+
					'</li> <br /> '; 
				}
			}else{
				cartData = "Cart is empty";
			}
			
			
			$("#cartData").html(cartData);
			 
			
		},error : function(e){
			console.log("Error :::"+e)
		}
	});

}
</script>

</body>


</html>