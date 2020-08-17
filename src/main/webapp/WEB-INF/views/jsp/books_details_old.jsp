<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Books Details | Frangipani Books </title>

<meta http-equiv="ScreenOrientation" content="autoRotate:disabled">
<meta name="theme-color" content="#ED008C">

<link rel="apple-touch-icon" sizes="152x152" href="<%=request.getContextPath() %>/resources/images/favicon/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath() %>/resources/images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath() %>/resources/images/favicon/favicon-16x16.png">
<link rel="manifest" href="<%=request.getContextPath() %>/resources/images/favicon/site.webmanifest">
<link rel="mask-icon" href="<%=request.getContextPath() %>/resources/images/favicon/safari-pinned-tab.svg" color="#5bbad5">
<meta name="msapplication-TileColor" content="#da532c">
<meta name="theme-color" content="#ffffff">


<!-- Font Awesome -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/font-awesome-4.7.0/css/font-awesome.min.css">                

<!-- CSS  -->
<link href="<%=request.getContextPath() %>/resources/css/custom.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/color.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/responsive.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/owl.carousel.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
<!--<link href="<%=request.getContextPath() %>/resources/css/prettyPhoto.css" rel="stylesheet">-->
<link href="<%=request.getContextPath() %>/resources/css/all.min.css" rel="stylesheet">
<!-- CSS  -->

<link rel='stylesheet' href='https://cdn.rawgit.com/OwlCarousel2/OwlCarousel2/develop/dist/assets/owl.carousel.min.css'>


<!-- Pretty Photo Light box Scrept start-->

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/prettyPhoto.css" type="text/css" media="screen" charset="utf-8" />
<!-- Pretty Photo Light box Scrept End-->


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
	<c:if test="${fn:length(category.categoryName) > 0 }">  
		<li><a href="<%=request.getContextPath() %>/productList/${category.id}/${category.categoryName }"> ${category.categoryName } </a></li> 
	</c:if> 

<li> ${product.bookTitle }  </li>
</ul>
</div>
</section>
<!--Inner Header End--> 



<!--Blog Start-->
<section class="wf100 gallery clearfix  shop">
<div class="product-details">
<div class="container">
<div class="row">

<!--<li style="display: none"><a href="" rel="prettyPhoto[gallery1]" title=""></a></li>-->




<div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">

<div class="wrapCarouselFull">

<!--<li class="d-none"><a href="" rel="prettyPhoto[gallery1]" title=""></a></li>-->
    
<div class="owl-carousel carousel-full">

<div class="item-carousel-full gallery clearfix">
<div class="gallery-img"> 
<a href="<%=request.getContextPath() %>/resources/images/book-default.jpg" rel="prettyPhoto[gallery1]" title="Things Every Child Show Know About J.B .Danquah">
<i class="fas fa-search"></i>
</a> 
<img src="<%=request.getContextPath() %>/resources/images/book-default.jpg">
</div>
</div>

<div class="item-carousel-full"> 
<div class="gallery-img">
<a href="<%=request.getContextPath() %>/resources/images/books/2.jpg" rel="prettyPhoto[gallery1]" title="Things Every Child Show Know About J.B .Danquah">
<i class="fas fa-search"></i>
</a> 
<img src="<%=request.getContextPath() %>/resources/images/books/2.jpg">
</div>
</div>

</div>
</div>

<div class="wrapCarouselThumbs">
<div class="owl-carousel carousel-thumbs"> 
<div class="item-carousel-thumbs"><img src="<%=request.getContextPath() %>/resources/images/book-default.jpg" alt=""></div>
<div class="item-carousel-thumbs"><img src="<%=request.getContextPath() %>/resources/images/books/2.jpg" alt=""></div>
</div>
</div>

</div>
















<div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
<!--<div class="pro-large">
<img src="<%=request.getContextPath() %>/resources/images/books/shoplarge.jpg" alt="">
</div>-->
<div class="wrapCarouselFull">
<div class="owl-carousel carousel-full">
		
		
		<c:choose>
			<c:when test="${product.image ne null }">
				<div class="item-carousel-full">
					<div class="gallery-img">
						<a href="${product.image }" rel="prettyPhoto[product]">
							<i class="fas fa-search"></i>
						</a>
						<img class="img-responsive" src="${product.image }" alt="">
					</div>
				</div>
			</c:when>
			<c:otherwise>
				 
				<div class="item-carousel-full">
					<div class="gallery-img">
						<a href="<%=request.getContextPath() %>/resources/images/book-default.jpg" rel="prettyPhoto[product]">
							<i class="fas fa-search"></i>
						</a>
						<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpg" alt="${productList.bookTitle }" title="${productList.bookTitle }">
					</div>
				</div>
				
				<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpg" alt="${productList.bookTitle }" title="${productList.bookTitle }">
			</c:otherwise>
		</c:choose> 
				
		
		
<%-- <div class="item-carousel-full">
<div class="gallery-img">
<a href="<%=request.getContextPath() %>/resources/images/books/2.jpg" rel="prettyPhoto[product]">
<i class="fas fa-search"></i>
</a>
<img src="<%=request.getContextPath() %>/resources/images/books/2.jpg">
</div>
</div> --%> 
</div>
</div>

<%-- <div class="wrapCarouselThumbs">
<div class="owl-carousel carousel-thumbs">
<div class="item-carousel-thumbs"><img src="<%=request.getContextPath() %>/resources/images/books/1.jpg" alt=""></div>
<div class="item-carousel-thumbs"><img src="<%=request.getContextPath() %>/resources/images/books/2.jpg" alt=""></div>
</div>
</div> --%>

</div>


<div class="col-lg-7 col-md-7 col-sm-6 col-xs-12">
<div class="product-text">
<h2> ${product.bookTitle } </h2>

<h6> <span>by: </span> ${author.authorName }</h6>


<p>  ${product.description } </p>
  
<h6> <span>ISBN:</span> ${product.bookISNB } </h6>
  
<div class="pro-pricing">${product.currency.currencySymbol}<fmt:formatNumber type = "number"  minFractionDigits="2" value =" ${product.originalPrice } "></fmt:formatNumber></div>
  
<span><font size="3" id="successAddtoCart${product.id}" color="green"></font> </span> 

<div class="add-2-cart"> <strong>Quantity:</strong>  
<input type="text" name="quantity" onblur="allnumeric(this)"  id="quantity" min="1" max="99" maxlength="2" placeholder="1" value="1" >   
<input type="submit" value="Add to Cart" name="Add to Cart" onclick="addToCart('${product.id}')" >
</div>  
<span><font size="errorQTY" id="errorQTY" color="red"></font> </span>

 


</div>
</div>
</div>


<div class="row">
<div class="col-md-12">
<div class="products-tabs wf100 p80">


<nav>
	<div class="nav nav-tabs" id="nav-tab" role="tablist">
		<c:forEach items="${productTabList }" var="productTabList" varStatus="coun">
			<c:choose>
				<c:when test="${coun.index == 0 }">
					<a class="nav-item nav-link active" id="nav-one-tab" data-toggle="tab" href="#nav-one${coun.count}" role="tab" aria-controls="nav-one" aria-selected="true"> ${productTabList.tabName } </a>	
				</c:when>
				<c:otherwise>
					<a class="nav-item nav-link" id="nav-one-tab" data-toggle="tab" href="#nav-one${coun.count}" role="tab" aria-controls="nav-one" aria-selected="true"> ${productTabList.tabName } </a>
				</c:otherwise>
			</c:choose>
			
		</c:forEach>
	</div>
</nav>


	<div class="tab-content" id="nav-tabContent">
		<c:forEach items="${productTabList }" var="productTabList" varStatus="coun">
			<c:choose>
				<c:when test="${coun.index == 0 }">
					<div class="tab-pane fade show active" id="nav-one${coun.count}" role="tabpanel" aria-labelledby="nav-one-tab">
						<p>${productTabList.description } </p>
					</div>
				</c:when>
				<c:otherwise> 
					<div class="tab-pane fade show" id="nav-one${coun.count}" role="tabpanel" aria-labelledby="nav-one-tab">
							<p>${productTabList.description } </p>
						</div>
			</c:otherwise>
			</c:choose>
				
					
		</c:forEach>
	</div>

</div>
</div> 
</div>



</div>
</div>


</section>
<!--Blog End--> 

<!--/#footer START-->
<%@include file="includes/footer.jsp" %>
<!--/#footer END-->

</div>



<!-- includes function START-->
<script>
w3IncludeHTML();
</script>
<!-- includes function END-->   


<!--   JS Files Start  --> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/prettyphoto.jquery.js" type="text/javascript" charset="utf-8"></script>
<!--<script src="<%=request.getContextPath() %>/resources/js/jquery.prettyPhoto.js"></script> -->
<%-- <script src="<%=request.getContextPath() %>/resources/js/isotope.min.js"></script> --%>  
<script src="<%=request.getContextPath() %>/resources/js/custom.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>

<!--<script src="<%=request.getContextPath() %>/resources/js/prettyphoto-jquery.min.js" type="text/javascript"></script>-->


<script  src="<%=request.getContextPath() %>/resources/js/script.js"></script>


<!-- Pretty Photo Light box Scrept start-->			
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
$("area[rel^='prettyPhoto']").prettyPhoto();

$(".gallery:first a[rel^='prettyPhoto']").prettyPhoto({animation_speed:'normal',theme:'light_square',slideshow:3000, autoplay_slideshow: true});
$(".gallery:gt(0) a[rel^='prettyPhoto']").prettyPhoto({animation_speed:'fast',slideshow:10000, hideflash: true});

$("#custom_content a[rel^='prettyPhoto']:first").prettyPhoto({
custom_markup: '<div id="map_canvas" style="width:260px; height:265px"></div>',
changepicturecallback: function(){ initialize(); }
});

$("#custom_content a[rel^='prettyPhoto']:last").prettyPhoto({
custom_markup: '<div id="bsap_1259344" class="bsarocks bsap_d49a0984d0f377271ccbf01a33f2b6d6"></div><div id="bsap_1237859" class="bsarocks bsap_d49a0984d0f377271ccbf01a33f2b6d6" style="height:260px"></div><div id="bsap_1251710" class="bsarocks bsap_d49a0984d0f377271ccbf01a33f2b6d6"></div>',
changepicturecallback: function(){ _bsap.exec(); }
});
});

</script>
<!-- Pretty Photo Light box Scrept End-->	


<script type="text/javascript">

$( document ).ready(function() {
	getCart();
});


function addToCart(orderId){
	$.ajax({
		type : "POST", 
		url : "<%=request.getContextPath()%>/addToCart",
		data : {
			orderId : orderId,
			qty : $("#quantity").val(), 
		},success:function(data){
			getCart(); 
			$("#successAddtoCart"+orderId).html("Product added in cart");
			setTimeout(function(){ $("#successAddtoCart"+orderId).html(""); }, 7000);
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
			var cartFinalTotal = "0";   
			if(data.length > 0){	
				for (var i = 0; i < data.length; i++) {
					cartData += '<li class="item">'+
					'<a href="#" class="preview-image">'+
					'<img class="preview" src="'+data[i].image+'" alt="">'+
					'</a>'+
					'<div class="description">'+ 
					'<a href="#"> '+data[i].bookTitle+'</a>'+ 
					'<strong class="price"> '+data[i].qty+' x '+data[i].currencySymbol +data[i].price+' </strong> '+
					'</div>'+
					'</li> <br /> '; 
					  
					cartTotal = data[i].qty * data[i].price; 
					cartFinalTotal = parseInt(cartTotal) + parseInt(cartFinalTotal);					   
				}  
			}else{
				cartData = "Cart is empty";
			}
			
			 if(cartData==0)
				$("#cartData").html("");
			 else
				$("#cartData").html(cartData);
			$("#cartTotal").html("Total: "+$("#currencySymbol").val()+""+cartFinalTotal);
			$("#cateItemTotal").html(data.length);
		},error : function(e){ 
			console.log("Error :::"+e)
		}
	});

} 


function allnumeric(inputtxt)
{
   var numbers = /^[0-9]+$/;
   if(inputtxt.value.match(numbers)){    
   		return true;
   }else{
	   $("#errorQTY").html("Please enter number only");
	   $("#quantity").val("1");
	   $("#quantity").focus();
	   setTimeout(function(){ $("#errorQTY").html(""); }, 7000);
   }
} 

</script>
<input type="hidden" name="currencySymbol" id="currencySymbol" value="<%=session.getAttribute("currencySymbol")%>">
<style>
 
.add-2-cart input[type="text"] {
    height: 48px;
    border: 1px solid #dddddd;
    width: 75px;
    padding: 0 10px;
    margin-right: 10px;
}
</style>

</body>


</html>