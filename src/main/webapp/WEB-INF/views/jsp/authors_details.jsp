<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Author Details | Frangipani Books </title>

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
<link href="<%=request.getContextPath() %>/resources/css/prettyPhoto.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/all.min.css" rel="stylesheet">
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
<li><a href="<%=request.getContextPath()%>/">Home</a></li> 
<li><a href="<%=request.getContextPath()%>/authors">Authors</a></li>
<li> Author Detail </li>
</ul>
</div>
</section>
<!--Inner Header End--> 


<!--Blog Start-->
<section class="wf100 p80 team">

<%-- <c:forEach items="${author }" var="author"> --%>
<div class="team-details">
<div class="container">
<div class="row">

<div class="col-md-3">
<div class="team-large-img"> <img src="${authors.image }" alt=""> </div>
</div>
<div class="col-md-9">
<div class="team-details-txt">
<h2> ${authors.authorName } </h2>

 <p style="color: #222;"> ${authors.description } </p>

 
	<!-- <div class="share-post wf100"> 
		<a href="#" class="fb"><i class="fab fa-facebook-f"></i></a> 
		<a href="#" class="tw"><i class="fab fa-twitter"></i></a> 
		<a href="#" class="link"><i class="fab fa-linkedin-in"></i></a> 
		<a href="#" class="insta"><i class="fab fa-instagram"></i></a> 
	</div> --> 

</div>
</div>
</div>
</div>
</div>
<%-- </c:forEach> --%>
</section>
<!--Blog End--> 

    
   
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