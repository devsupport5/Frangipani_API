<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<link rel="apple-touch-icon" sizes="152x152" href="resources/images/favicon/apple-touch-icon.png">
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

</head>
<body>

<div class="wrapper home2">

<!--/header START-->
<%@include file="includes/header.jsp" %>
<!--/header END-->



<!--Slider Start-->
<section id="home-slider" class="owl-carousel owl-theme wf100">

<div class="item">
<div class="slider-caption h2slider">
<div class="container">
<h1> Demystifying  Science </h1>
<p> for Basic Schools Ghana </p>
<a href="resources/#"> Details </a> 
<a href="resources/#"  class="active"> Buy Now </a> 
</div>
</div>
<img src="resources/images/h2-slide1.jpg" alt=""> 
</div>

<div class="item">
<div class="slider-caption h2slider">
<div class="container">
<h1>Demystifying  Science </h1>
<p> for Basic Schools Ghana </p>
<a href="resources/#" > Details </a> <a class="active" href="resources/#"> Buy Now </a> 
</div>
</div>
<img src="resources/images/h2-slide2.jpg" alt=""> 
</div>

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
<div class="col-md-6"> <a href="resources/books.html" class="view-more"> View All </a> </div>
</div>

<div class="row">
<!--Pro Box Start-->
<div class="col-md-3 col-sm-6">
<div class="product-box">
<div class="pro-thumb"> <a href="resources/#">Add To Cart</a> <img src="resources/images/pro1.jpg" alt=""></div>
<div class="pro-txt">
<h6><a href="resources/#"> Book Name </a></h6>
<p class="pro-price"><del>$25.00</del> $19.00</p>
</div>
</div>
</div>
<!--Pro Box End--> 
<!--Pro Box Start-->
<div class="col-md-3 col-sm-6">
<div class="product-box">
<div class="pro-thumb"> <a href="resources/#">Add To Cart</a> <img src="resources/images/pro2.jpg" alt=""></div>
<div class="pro-txt">
<h6><a href="resources/#"> Book Name </a></h6>
<p class="pro-price"><del>$25.00</del> $19.00</p>
</div>
</div>
</div>
<!--Pro Box End--> 
<!--Pro Box Start-->
<div class="col-md-3 col-sm-6">
<div class="product-box">
<div class="pro-thumb"> <a href="resources/#">Add To Cart</a> <img src="resources/images/pro3.jpg" alt=""></div>
<div class="pro-txt">
<h6><a href="resources/#"> Book Name </a></h6>
<p class="pro-price"><del>$25.00</del> $19.00</p>
</div>
</div>
</div>
<!--Pro Box End--> 
<!--Pro Box Start-->
<div class="col-md-3 col-sm-6">
<div class="product-box">
<div class="pro-thumb"> <a href="resources/#">Add To Cart</a> <img src="resources/images/pro4.jpg" alt=""></div>
<div class="pro-txt">
<h6><a href="resources/#"> Book Name </a></h6>
<p class="pro-price"><del>$25.00</del> $19.00</p>
</div>
</div>
</div>
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
<div class="col-md-6"> <a href="resources/books-by-category.html" class="view-more"> View All </a> </div>
</div>



<div class="row">


<!--Services Box Start-->

<c:forEach items="${categories }" var="categories">
	<div class="ser-col col-md-3">
		<div class="ser-box">
			<div class="ser-thumb"><a href="resources/#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg2.jpg" alt=""></div>
			<div class="ser-txt"> 
				<h4> <a href="<%=request.getContextPath() %>/productList/${categories.id }"> ${categories.categoryName } </a></h4>
			<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
			</div>
		</div>
	</div>
</c:forEach>


<!--Services Box End--> 


<!--Services Box Start-->
<!-- <div class="ser-col col-md-3">
<div class="ser-box">
<div class="ser-thumb"><a href="resources/#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg3.jpg" alt=""></div>
<div class="ser-txt">
<h4> <a href="resources/#"> Comic Book  </a> 
</h4>
<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
</div>
</div>
</div> -->
<!--Services Box End--> 

<!--Services Box Start-->
<!-- <div class="ser-col col-md-3">
<div class="ser-box">
<div class="ser-thumb"> <a href="resources/#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg4.jpg" alt=""></div>
<div class="ser-txt">
<h4> <a href="resources/#"> Historical </a> 
</h4>
<span class="aicon"><i class="fas fa-arrow-right"></i></span> 
</div>
</div>
</div> -->
<!--Services Box End--> 


<!--Services Box Start-->
<!-- <div class="ser-col col-md-3">
<div class="ser-box">
<div class="ser-thumb"><a href="resources/#"><i class="fas fa-link"></i></a> <img src="resources/images/serimg5.jpg" alt=""></div>
<div class="ser-txt">
<h4> <a href="resources/#"> Historical Fiction </a> 
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
<a href="resources/#" class="cus"> View All </a>
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
<!--<div class="col-md-6"> <a href="resources/#" class="view-more"> View All </a> </div>-->
</div>
    
<div class="team-details">
<div class="container">
<div class="row">
<div class="col-md-3">
<div class="team-large-img"> <img src="resources/images/Authors-photo.jpg" alt=""> </div>
</div>
<div class="col-md-9">
<div class="team-details-txt">
<h2> ABYNA-ANSAA ADJEI </h2>
<strong class="trank"> 1879 </strong>
<p> Abyna-Ansaa Adjei is the author of eleven books. Ghana: The Story So Far is
her most recent book. Published in March 2017, to celebrate Ghana’s 60 th
anniversary of independence, this coffee table book brings Ghana’s history
alive with its captivating images. </p>
<p> Her first book was a biography of the Ashanti King – Otumfuo Osei Tutu II:
King of Gold. Originally her undergraduate thesis, this book is found on the
shelves of Yale, Harvard, Stanford and many other great institutions
worldwide. </p>
<div class="share-post wf100"> 
<a href="resources/#" class="fb"><i class="fab fa-facebook-f"></i></a> 
<a href="resources/#" class="tw"><i class="fab fa-twitter"></i></a> 
<a href="resources/#" class="link"><i class="fab fa-linkedin-in"></i></a> 
<a href="resources/#" class="insta"><i class="fab fa-instagram"></i></a> 
</div>

</div>
</div>
</div>
</div>
</div>
    
    
</div>
</section>
<!--Authors Section End--> 



<!--Testimonials Start-->
<div class="testimonials-section bg-white wf100 p80">
<div class="container">

<div class="row mb-2">
<div class="col-md-6">
<div class="section-title-2">
<h2> Testimonials  </h2>
</div>
</div>
<div class="col-md-6"> <a href="resources/#" class="view-more"> View All </a> </div>
</div>
    

<div class="row">
<div class="col-md-12">
<div id="testimonials" class="owl-carousel owl-theme">
<!--testimonials box start-->
<div class="item">
<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using lorem sum is that it has a more or less normal distribution.</p>
<div class="tuser"> <img src="resources/images/tuser1.jpg" alt=""> <strong>Danny Scotten</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>As opposed to using 'Content here, content here', making it look like readable English. Many Desktop and Web Pages are using lorem ipsum.</p>
<div class="tuser"> <img src="resources/images/tuser2.jpg" alt=""> <strong>Richardson</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.</p>
<div class="tuser"> <img src="resources/images/tuser3.jpg" alt=""> <strong>Anna Lillian</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>Those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain.</p>
<div class="tuser"> <img src="resources/images/tuser1.jpg" alt=""> <strong>Danny Scotten</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using lorem sum is that it has a more or less normal distribution.</p>
<div class="tuser"> <img src="resources/images/tuser1.jpg" alt=""> <strong>Danny Scotten</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>As opposed to using 'Content here, content here', making it look like readable English. Many Desktop and Web Pages are using lorem ipsum.</p>
<div class="tuser"> <img src="resources/images/tuser2.jpg" alt=""> <strong>Richardson</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.</p>
<div class="tuser"> <img src="resources/images/tuser3.jpg" alt=""> <strong>Anna Lillian</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>Those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain.</p>
<div class="tuser"> <img src="resources/images/tuser1.jpg" alt=""> <strong>Danny Scotten</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using lorem sum is that it has a more or less normal distribution.</p>
<div class="tuser"> <img src="resources/images/tuser1.jpg" alt=""> <strong>Danny Scotten</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>As opposed to using 'Content here, content here', making it look like readable English. Many Desktop and Web Pages are using lorem ipsum.</p>
<div class="tuser"> <img src="resources/images/tuser2.jpg" alt=""> <strong>Richardson</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.</p>
<div class="tuser"> <img src="resources/images/tuser3.jpg" alt=""> <strong>Anna Lillian</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
<!--testimonials box start-->
<div class="item">
<p>Those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain.</p>
<div class="tuser"> <img src="resources/images/tuser1.jpg" alt=""> <strong>Danny Scotten</strong> Florida Partner </div>
</div>
<!--testimonials box End--> 
</div>
</div>
</div>
</div>
</div>
<!--Testimonials End--> 




<!--Why Ecova + Facts Start-->
<section class="why-ecova wf100">
<div class="container">
<div class="row">
<div class="col-md-12">
<h1> Shipped to </h1>
<p> We Will Shipped Books to Ghana Only </p>
<!-- <a href="resources/#" class="cus"> Signup to Join us</a> -->
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

</body>

</html>