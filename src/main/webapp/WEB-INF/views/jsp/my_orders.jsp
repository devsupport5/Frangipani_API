<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> My Orders | Frangipani Books </title>

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
<script src="js/w3data.js"></script>
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
<li> My Orders </li>
</ul>
</div>
</section>
<!--Inner Header End--> 

<!--Causes Start-->
<section class="wf100 p80 events">
<div class="event-list-two">
<div class="container">
<div class="row">
<div class="col-lg-12 col-md-12">


<!--Order Box Start-->
<c:forEach items="${orderList }" var="orderList">
<div class="event-list-box">

<div class="event-thumb"> 
<a href="#"><i class="fas fa-link"></i></a> <img src="images/books/1.jpg" alt=""> 
</div>

<div class="event-txt">
<h4> <a href="#">  ${orderList.bankName }  </a> </h4>
<p> ${orderList.otherInformation }  </p>

<a href="books-details.html" class="attbtn">by: ABYNA-ANSAA ADJEI</a> 

<p style="    font-size: 13px;
    padding-top: 7px;     color: #878787;" class="product-category"> DRAMA, ROMANCE </p>
    
</div>

<ul class="event-meta">
<li> <div class="_30ud5x _3ELbo9"></div> ${orderList.createdDate } </li> 
<li>   <fmt:formatNumber type = "number"  minFractionDigits="2" value ="${orderList.amount }"></fmt:formatNumber></li>
</ul>
</div>
</c:forEach>
<!--Order Box Start-->

<!--Order Box Start-->
<!-- <div class="event-list-box">

<div class="event-thumb"> 
<a href="#"><i class="fas fa-link"></i></a> <img src="images/books/1.jpg" alt=""> 
</div>

<div class="event-txt">
<h4> <a href="books-details.html">  Things Every Child Show Know About J.B .Danquah  </a> </h4>
<p> Things Every Child Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam,  </p>

<a href="books-details.html" class="attbtn">by: ABYNA-ANSAA ADJEI</a> 

<p style="    font-size: 13px;
    padding-top: 7px;     color: #878787;" class="product-category"> DRAMA, ROMANCE </p>
    
</div>

<ul class="event-meta">
<li> <div class="_30ud5x _3ELbo9"></div> Delivered on Jun 24 </li>
<li>  ₵40.00 </li>
</ul>
    
</div> -->
<!--Order Box Start-->

</div>

</div>
<div class="row">
<div class="col-md-12">
<div class="gt-pagination mt20">
<!-- <nav>
<ul class="pagination">
<li class="page-item"> <a class="page-link" href="#" aria-label="Previous"> <i class="fas fa-angle-left"></i> </a> </li>
<li class="page-item"><a class="page-link" href="#">1</a></li>
<li class="page-item active"><a class="page-link" href="#">2</a></li>
<li class="page-item"><a class="page-link" href="#">3</a></li>
<li class="page-item"> <a class="page-link" href="#" aria-label="Next"> <i class="fas fa-angle-right"></i> </a> </li>
</ul> 
</nav> -->
</div>
</div>
</div>
</div>
</div>
</section>
<!--Causes End--> 

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
</body>


</html>