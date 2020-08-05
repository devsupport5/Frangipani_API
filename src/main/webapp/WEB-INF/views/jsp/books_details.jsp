<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">                

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
<li><a href="<%=request.getContextPath() %>/category"> ${category.categoryName } </a></li>
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
						<a href="<%=request.getContextPath() %>/resources/images/book-default.jpeg" rel="prettyPhoto[product]">
							<i class="fas fa-search"></i>
						</a>
						<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpeg" alt="${productList.bookTitle }" title="${productList.bookTitle }">
					</div>
				</div>
				
				<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpeg" alt="${productList.bookTitle }" title="${productList.bookTitle }">
			</c:otherwise>
		</c:choose>
				
		
		
<div class="item-carousel-full">
<div class="gallery-img">
<a href="<%=request.getContextPath() %>/resources/images/books/2.jpg" rel="prettyPhoto[product]">
<i class="fas fa-search"></i>
</a>
<img src="<%=request.getContextPath() %>/resources/images/books/2.jpg">
</div>
</div>
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

<h6> <span>SKU:</span> ${product.bookSKU } </h6>

<div class="pro-pricing"> ${product.originalPrice } </div>

<div class="add-2-cart"> <strong>Quantity:</strong>
<input type="number" name="quantity" id="quantity" min="1" max="99" placeholder="1" value="1" >   
<input type="submit" value="Add to Cart" name="Add to Cart" onclick="addToCart('${product.id}')" >
</div> 



</div>
</div>
</div>


<div class="row">
<div class="col-md-12">
<div class="products-tabs wf100 p80">

<nav>
<div class="nav nav-tabs" id="nav-tab" role="tablist"> 
<a class="nav-item nav-link active" id="nav-one-tab" data-toggle="tab" href="#nav-one" role="tab" aria-controls="nav-one" aria-selected="true"> Overview </a> 
<a class="nav-item nav-link" id="nav-two-tab" data-toggle="tab" href="#nav-two" role="tab" aria-controls="nav-two" aria-selected="true"> Details </a> 
<a class="nav-item nav-link" id="nav-three-tab" data-toggle="tab" href="#nav-three" role="tab" aria-controls="nav-three" aria-selected="false"> Meet the Author </a>
</div>
</nav>





<div class="tab-content" id="nav-tabContent">

<div class="tab-pane fade show active" id="nav-one" role="tabpanel" aria-labelledby="nav-one-tab">
<p> On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains. </p>
</div>

<div class="tab-pane fade" id="nav-two" role="tabpanel" aria-labelledby="nav-two-tab">
<table>
<tr>
<td style="width: 13%;">SKU:</td>
<td> 1250010083 </td>
</tr>
<tr>
<td>Publisher:</td>
<td> Boyds Mills Press </td>
</tr>
<tr>
<td>Publish Date:</td>
<td> 1990 </td>
</tr>
<tr>
<td>Page Count:</td>
<td>  4000 </td>
</tr>
</table>
</div>







<div class="tab-pane fade" id="nav-three" role="tabpanel" aria-labelledby="nav-three-tab">
<div class="team-details">

<div class="row">
<div class="col-md-3">
<div class="team-large-img"> <img src="<%=request.getContextPath() %>/resources/images/authors/Authors-photo.jpg" alt=""> </div>
</div>
<div class="col-md-9">
<div class="team-details-txt">
<h2> Abyna-Ansaa Adjei </h2>
<strong class="trank"> 1879 </strong>
<p> Abyna-Ansaa Adjei is the author of eleven books. Ghana: The Story So Far is her most recent book. Published in March 2017, to celebrate Ghanas 60 th anniversary of independence, this coffee table book brings Ghanas history alive with its captivating images. Her first book was a biography of the Ashanti King - Otumfuo Osei Tutu II: King of Gold. Originally her undergraduate thesis, this book is found on the shelves of Yale, Harvard, Stanford and many other great institutions worldwide. </p>


</div>
</div>
</div>

</div>
</div>



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
<script src="<%=request.getContextPath() %>/resources/js/isotope.min.js"></script> 
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
					'<img class="preview" src="<%=request.getContextPath() %>/resources/images/books/1.jpg" alt="">'+
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

</script>

</body>


</html>