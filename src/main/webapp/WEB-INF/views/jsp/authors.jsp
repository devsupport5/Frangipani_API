<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Authors | Frangipani Books </title>

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
<li><a href="<%=request.getContextPath()%>/">Home</a></li>
<li> Authors </li>
</ul>
</div>
</section>
<!--Inner Header End--> 




<!--Authors Section Start-->
<section class="wf100 p60 authors-list">
<div class="container">

<div class="row">


<!--Team Box Start-->
<c:forEach items="${authors }" var="authors">
	<div class="col-md-3 col-sm-4">
		<div class="team-box">
			<a href="<%=request.getContextPath()%>/author/${authors.id}"><img src="${authors.image }" alt=""></a>
			<div class="team-info"> 
				<h3><a href="<%=request.getContextPath()%>/author/${authors.id}"> ${authors.authorName } </a></h3>
				<p> ${authors.description } </p> 
			</div>
		</div>
	</div>
	<br /> 
</c:forEach>

<!--Team Box Start--> 
 


</div>

</div>
</section>
<!--Authors Section End--> 



    
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
</body>


</html>