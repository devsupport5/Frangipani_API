<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Books by Category | Frangipani Books </title>

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
<!-- CSS  -->

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
<li><a href="resources/index.html">Home</a></li>
<li> Books </li>
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
<c:forEach items="${products }" var="products">
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
	<div class="product">

		<div class="product-img">
			<a href="#">
				<img class="img-responsive" src="${products.image }" alt="">
			</a>
		</div>
		
				
		<div class="product-body">
			<p class="product-category"> Details  </p>
				<h3 class="product-name"><a href="<%=request.getContextPath() %>/product/${products.id }"> ${products.bookTitle } </a></h3>
				<h4 class="product-price"> <del>${products.originalPrice }</del> ${products.discountedPrice }</h4>
			<div class="add-to-cart">
				<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
			</div>
		
		</div>

   </div>
</div>

</c:forEach>
<!-- /product -->





</div>
<!-- /store products -->

<!-- store bottom filter -->
<div class="store-filter clearfix">
<span class="store-qty">Showing 20-100 products</span>
<ul class="store-pagination">
<li class="active">1</li>
<li><a href="#">2</a></li>
<li><a href="#">3</a></li>
<li><a href="#">4</a></li>
<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
</ul>
</div>
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
<!-- <!-- includes function START 
<script>
w3IncludeHTML();
</script>  
includes function END   
 -->

<!--   JS Files Start  --> 
<script src="resources/js/jquery-3.3.1.min.js"></script> 
<script src="resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="resources/js/popper.min.js"></script> 
<script src="resources/js/bootstrap.min.js"></script> 
<script src="resources/js/owl.carousel.min.js"></script> 
<script src="resources/js/jquery.prettyPhoto.js"></script> 
<script src="resources/js/isotope.min.js"></script> 
<script src="resources/js/custom.js"></script>
</body>


</html>