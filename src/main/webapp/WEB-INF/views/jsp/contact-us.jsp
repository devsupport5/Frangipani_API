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
<li>  Contact Us </li>
</ul>
</div>
</section>
<!--Inner Header End--> 


<!--Contact Start-->
<section class="contact-page wf100 ">


<div class="google-map">
<div class="contact-map-info">
<address>
<ul>
<li>
<strong class="add-title">Address:</strong>
Osu- Accra P.O. Box 0259 00000 Osu, Accra
</li>
<li>
<strong class="add-title">Contact:</strong>
<p><strong>Call:</strong> 050 938 7987 </p>
</li>
<li>
<strong class="add-title"> For More Information: </strong>
<p><strong>Email:</strong> <a href="mailto:info@frangipanibooks.com.gh"> info@frangipanibooks.com.gh </a>  </p>

</li>
</ul>
</address>
</div>

<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4046761.1894375!2d-3.274912194902756!3d7.903925348220846!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xfd75acda8dad6c7%3A0x54d7f230d093d236!2sGhana!5e0!3m2!1sen!2sin!4v1595226007800!5m2!1sen!2sin" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
    

</div>


<div class="container">
<div style="padding-top: 4em; padding-bottom: 5em"  class="row">
<div class="col-md-1"></div>
<div class="col-md-10">
<div class="contact-form mb60">
<h3> Feel Free To Send Any Message For Any Enquiry </h3>
<ul class="cform">
<li class="half pr-15">
<input type="text" class="form-control" placeholder="Full Name">
</li>
<li class="half pl-15">
<input type="text" class="form-control" placeholder="Email">
</li>
<li class="half pr-15">
<input type="text" class="form-control" placeholder="Contact">
</li>
<li class="half pl-15">
<input type="text" class="form-control" placeholder="Subject">
</li>
<li class="full">
<textarea class="textarea-control" placeholder="Message"></textarea>
</li>
<li class="full">
<input type="submit" value="Contact us" class="fsubmit">
</li>
</ul>
</div>
</div>
</div>
</div>

</section>
<!--Contact End--> 

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

<script type="text/javascript"> 

$( document ).ready(function() {
	getCart(); 
});


 

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