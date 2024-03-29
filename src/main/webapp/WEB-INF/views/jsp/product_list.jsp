<!doctype html>
<html lang="en">
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> ${categoryName }  | Frangipani Books </title>

<meta http-equiv="ScreenOrientation" content="autoRotate:disabled">
<meta name="theme-color" content="#ED008C">

<link rel="apple-touch-icon" sizes="152x152" href="<%=request.getContextPath() %>/images/favicon/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath() %>/images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/images/favicon/favicon-16x16.png">
<link rel="manifest" href="<%=request.getContextPath() %>/images/favicon/site.webmanifest">
<link rel="mask-icon" href="<%=request.getContextPath() %>/images/favicon/safari-pinned-tab.svg" color="#5bbad5">
<meta name="msapplication-TileColor" content="#da532c">
<meta name="theme-color" content="#ffffff">


<!-- Font Awesome -->
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">                

<!-- CSS  -->
<link href="<%=request.getContextPath() %>/resources/css/custom.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/color.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/responsive.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/owl.carousel.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/prettyPhoto.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/all.min.css" rel="stylesheet">
<!-- CSS  -->

<!-- includes js File START-->
<script src="<%=request.getContextPath() %>/resources/js/w3data.js"></script>
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
<li><a href="<%=request.getContextPath() %>/">Home</a></li>
<li><a href="<%=request.getContextPath() %>/category"> Category </a></li>
<li><a href="#"> ${categoryName } </a></li> 
</ul>
</div>
</section>
<!--Inner Header End--> 

<!--books Start-->
<section class="wf100 books">
<div class="container">
<div class="row">

<!-- STORE -->
<div class="col-md-12">

<!-- store products -->
<div class="row">
 


<!-- product -->
<c:forEach items="${productList }" var="productList">
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
<div class="product">
<div class="product-img">
<a href="<%=request.getContextPath() %>/product/${productList.id }">
<c:choose>
	<c:when test="${productList.image ne null }">
		<img class="img-responsive" src="${productList.image }"  alt="">	
	</c:when>
	<c:otherwise> 
		<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpg" alt="${productList.bookPrice }" title="${productList.bookPrice }">
	</c:otherwise>
</c:choose>

</a>
</div>
<div class="product-body">
<p class="product-category"> ${categoryName } </p>
<h3 class="product-name"><a href="<%=request.getContextPath() %>/product/${productList.id }" class="text_length"> ${productList.bookTitle }  </a></h3>
<h4 class="product-price">${productList.currency.currencySymbol}<fmt:formatNumber type = "number"  minFractionDigits="2" value ="${productList.originalPrice }"></fmt:formatNumber> </h4>
<div class="add-to-cart">  
<span><font size="3" id="successAddtoCart${productList.id}" color="green"></font> </span> 
<button class="add-to-cart-btn" onclick="addToCart(${productList.id});" ><i class="fa fa-shopping-cart"></i> add to cart</button>
</div>

</div> 

</div>
</div>
<div class="clearfix visible-lg visible-md"></div>
</c:forEach>
<!-- /product -->
 
</div>
<!-- /store products -->

<!-- store bottom filter -->
<!-- <div class="store-filter clearfix">
<span class="store-qty">Showing 20-100 products</span>
<ul class="store-pagination">
<li class="active">1</li>
<li><a href="#">2</a></li>
<li><a href="#">3</a></li>
<li><a href="#">4</a></li>
<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
</ul>
</div> -->
<!-- /store bottom filter -->


</div>
<!-- /STORE -->

</div>
</div>
</section>
<!--books End--> 


<!--/#footer START-->
<%@include file="includes/footer.jsp" %>
<!--/#footer END-->

</div>


 
<!--   JS Files Start  --> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery.prettyPhoto.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/isotope.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/custom.js"></script>
 
<%-- <script type="text/javascript">

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
			 $("#successMessage"+orderId).html("Product added in cart");
			    
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
			var cartData = "";
			var cartFinalTotal = 0;  
			if(data.length > 0){	
				for (var i = 0; i < data.length; i++) {
					cartData += '<li class="item">'+
					'<a href="#" class="preview-image">'+ 
					'<img class="preview" src="'+data[i].image+'" alt="">'+
					'</a>'+
					'<div class="description">'+ 
					'<a href="#"> '+data[i].bookTitle+'</a>'+   
					'<strong class="price"> '+data[i].qty+' x '+ data[i].currencySymbol +data[i].price.toFixed(2)+' </strong> '+
					'</div>'+
					'</li> <br /> '; 
					  
					cartTotal = data[i].qty * data[i].price; 
					cartFinalTotal = parseInt(cartTotal) + parseInt(cartFinalTotal);					   
				}  
			}else{
				cartData = "Cart is empty";
			} 
			 /* if(cartData==0)
				$("#cartData").html("");
			 else */ 
				$("#cartData").html(cartData);
		       
			//$("#cartData").html(""); 
			$("#cartTotal").html($("#currencySymbol").val()+""+cartFinalTotal.toFixed(2));
			$("#cateItemTotal").html(data.length);
		},error : function(e){ 
			console.log("Error :::"+e)
		}
	});

} 
</script> --%>




</body>


</html>