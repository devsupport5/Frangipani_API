<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
 
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Frangipani Books </title>

<meta http-equiv="ScreenOrientation" content="autoRotate:disabled">
<meta name="theme-color" content="#ED008C">

<link rel="apple-touch-icon" sizes="152x152" href="<%=request.getContextPath() %>/resources/images/favicon/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicon/favicon-16x16.png">
<link rel="manifest" href="resources/images/favicon/site.webmanifest">
<link rel="mask-icon" href="resources/images/favicon/safari-pinned-tab.svg" color="#5bbad5">
<meta name="msapplication-TileColor" content="#da532c">
<meta name="theme-color" content="#ffffff">


<!-- Font Awesome -->
<link rel="stylesheet" href="resources/resources/font-awesome-4.7.0/css/font-awesome.min.css">                

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

<script type="text/javascript">

function getSliderList(){
	$.ajax({
		type : "GET",
		url  : "getSliderList",
		data : {
		},
		success : function(data){
			var sliderContent = "";
			for (var i = 0; i < data.length; i++) {
				sliderContent += '<div class="item">'+
					'<div class="slider-caption h2slider">'+
				'<div class="container">'+
				'<h1>'+data[i].title  +'</h1>'+
				'<p> '+data[i].subTitle +' </p>'+
				'<a href="'+data[i].detailLink+'" > Details </a> <a class="active" href="'+data[i].buyNowLink+'"> Buy Now </a>'+ 
				'</div>'+
				'</div>'+
				'<img src="'+data[i].image+'" alt="">'+ 
				'</div>';  
				 
				 //alert(data[i].image);
			}
			 
			$("#sliderList").html(sliderContent);
		},error :function(e){
			console.log("Error ::"+e);
		}
	
		
		
	});
}



</script>

</head>
<body onload="">

<div class="wrapper home2">

<!--/header START-->
<%@include file="includes/header.jsp" %>
<!--/header END-->



<!--Slider Start-->
<section id="home-slider" class="owl-carousel owl-theme wf100">

<!-- <div id="sliderList"></div> -->

<c:forEach items="${sliderList }" var="sliderList">
	<div class="item">
		<div class="slider-caption h2slider">
			<div class="container">
				<h1> ${sliderList.title } </h1>
				<p> ${sliderList.subTitle } </p> 
				<a href="${sliderList.detailLink }" > Details </a> 
				<a href="${sliderList.buyNowLink }"  class="active"> Buy Now </a> 
			</div>
		</div>
		<img src="${sliderList.image }" alt="${sliderList.title }"> 
	</div>
</c:forEach>


<!-- <div class="item">
<div class="slider-caption h2slider">
<div class="container">
<h1>Demystifying  Science </h1>
<p> for Basic Schools Ghana </p>
<a href="#" > Details </a> <a class="active" href="#"> Buy Now </a> 
</div>
</div>
<img src="resources/images/h2-slide2.jpg" alt=""> 
</div> -->

</section>
<!--Slider End--> 




<!-- Featured Books Start-->
<section class="online-shop wf100 p80 fcampaigns">
<div class="container">


<div class="row mb-2">
<div class="col-md-6">
<div class="section-title-2">
<h2> Featured Books </h2>
</div>
</div>   	
<div class="col-md-6"> <a href="<%=request.getContextPath() %>/featured/product" class="view-more"> View All </a> </div>
</div>

<div class="row">
<!--Pro Box Start-->
<c:forEach items="${featuredProduct }" var="featuredProduct" >
	<div class="col-md-3 col-sm-6">
		<div class="product-box"> 
			<div class="pro-thumb"> <a href="#" onclick="addToCart('${featuredProduct.id}')">Add To Cart</a>
			
			<c:choose>
				<c:when test="${featuredProduct.image ne null }"> 
					<img class="img-responsive" src="${featuredProduct.image }" style="height: 275px;" alt="">	
				</c:when>
				<c:otherwise>
					<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpeg" alt="${featuredProduct.bookTitle }" title="${productList.bookTitle }">
				</c:otherwise>
			</c:choose>
		 </div>
				<div class="pro-txt"> 
					<h6><a href="<%=request.getContextPath() %>/product/${featuredProduct.id }"> ${featuredProduct.bookTitle } </a></h6>
					<p class="pro-price"><!-- <del>$25.00</del>  -->${featuredProduct.originalPrice }</p>
				</div>
		</div>
	</div>
</c:forEach>
<!--Pro Box End--> 
 
</div>
</div>
</section>
<!--Online Products End--> 




<!--Services Slider Start-->
<section class="home-services wf100 p80bottom">
<div class="container">


<div class="row mb-2">
<div class="col-md-6">
<div class="section-title-2">
<h2> Books by Category </h2>
</div>
</div>
<div class="col-md-6"> <a href="category" class="view-more"> View All </a> </div>
</div>



<div class="row">


<!--Services Box Start-->
<c:forEach items="${categories }" var="categories">
	<div class="ser-col col-md-3">
		<div class="ser-box">
			<div class="ser-thumb"><a href="<%=request.getContextPath() %>/productList/${categories.id }/${categories.categoryName }"><i class="fas fa-link"></i></a>
			
			<c:choose>
				<c:when test="${categories.image ne null }">
					<img src="${categories.image}" style="height: 295px;" alt="${categories.categoryName }" title="${categories.categoryName }">	
				</c:when>
				<c:otherwise>
					<img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/book-default.jpeg" alt="${categories.categoryName }" title="${categories.categoryName }">
				</c:otherwise>
			</c:choose>
			
			 </div>
			<div class="ser-txt"> 
				<h4> <a href="<%=request.getContextPath() %>/productList/${categories.id }/${categories.categoryName }"> ${categories.categoryName } </a></h4>
			<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
			</div>
		</div>
	</div>
</c:forEach>
<!--Services Box End--> 


<!--Services Box Start-->
<!-- <div class="ser-col col-md-3">
<div class="ser-box">
<div class="ser-thumb"><a href="#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg3.jpg" alt=""></div>
<div class="ser-txt">
<h4> <a href="#"> Comic Book  </a> 
</h4>
<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
</div>
</div>
</div> -->
<!--Services Box End--> 

<!--Services Box Start-->
<!-- <div class="ser-col col-md-3">
<div class="ser-box">
<div class="ser-thumb"> <a href="#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg4.jpg" alt=""></div>
<div class="ser-txt">
<h4> <a href="#"> Historical </a> 
</h4>
<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
</div>
</div>
</div> -->
<!--Services Box End--> 


<!--Services Box Start-->
<!-- <div class="ser-col col-md-3">
<div class="ser-box">
<div class="ser-thumb"><a href="#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg5.jpg" alt=""></div>
<div class="ser-txt">
<h4> <a href="#"> Historical Fiction </a> 
</h4>
<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
</div>
</div>
</div> --> 
<!--Services Box End--> 

</div>
<!--
<div class="row">
<div class="col-md-12">
<a href="#" class="cus"> View All </a>
</div>
</div>-->

</div>
</section>
<!--Services Slider End--> 





    
<!--Authors Section Start-->
<section class="wf100 p60 h3teams-section">
<div class="container">


<div class="row mb-2">
<div class="col-md-6">
<div class="section-title-2">
<h2 style="    color: #fff;"> Authors  </h2>
</div>
</div>
<div class="col-md-6"> <a href="#" class="view-more"> View All </a> </div>
</div>
    
<div class="row">

<!--Team Box Start-->
<c:forEach items="${authorList }" var="authorList">
	<div class="col-md-3 col-sm-4">
		<div class="team-box">
			<img src="${authorList.image }" alt="">
			<div class="team-info">
				<h3> ${authorList.authorName } </h3>
				<p> ${authorList.description } </p>
			</div>
		</div>
	</div>
</c:forEach>
<!--Team Box Start--> 
</div>
</div>
</section>
<!--Authors Section End--> 
 
<div style="margin-bottom: 350px;">
&nbsp;  
</div>

  

<!--Why Ecova + Facts Start-->
<section class="why-ecova wf100">
<div class="container">
<div class="row">
<div class="col-md-12">
<h1> Shipped to </h1>
<p> We Will Shipped Books to Ghana Only </p>
<!-- <a href="#" class="cus"> Signup to Join us</a> -->
</div>
</div>
</div>
</section>
<!--Why Ecova + Facts End--> 



<!--/#footer START-->
<%@include file="includes/footer.jsp" %>
<!--/#footer END-->
 
</div>


<!-- includes function START-->
<script>
w3IncludeHTML();
</script>
<!-- includes function END-->   
    

<!--   JS   --> 
<script src="resources/js/jquery-3.3.1.min.js"></script> 
<script src="resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="resources/js/popper.min.js"></script> 
<script src="resources/js/bootstrap.min.js"></script> 
<script src="resources/js/owl.carousel.min.js"></script> 
<script src="resources/js/jquery.prettyPhoto.js"></script> 
<script src="resources/js/isotope.min.js"></script> 
<script src="resources/js/custom.js"></script>
<%-- <script src="<%=request.getContextPath() %>/resources/js/common.js"></script> --%>
 

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