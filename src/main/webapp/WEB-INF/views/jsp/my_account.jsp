<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Login | Signup | Frangipani Books </title>

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

<script type="text/javascript">
function registration(){
	
	$.ajax({
		type : "POST",
		url : "registration",
		data : {
			
			yourName : $("#yourName").val(),
			contact : $("#contact").val(), 
			userEmail : $("#userEmail").val(),
			userName : $("#userName").val(),
			password : $("#password").val(),
			
		},success:function(data){
			
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
}


function checkLogin(){
	$.ajax({
		type : "POST",
		url : "checkValidUser",
		data : {
			"userEmailId" : $("#userEmailId").val(),
			"userPassword" : $("#userPassword").val(), 
		},success:function(data){
			if(data==true){ 
				window.location.reload();
			}
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
}
</script>


</head>
<body>
    
<div class="wrapper">


 <div>  <%@include file="includes/header.jsp" %></div> 



<!--/header END-->



<!--Inner Header Start-->
<section class="wf100 inner-header">
<div class="container">
<ul>
<li><a href="<%=request.getContextPath() %>/">Home</a></li>
<li><a href="#"> Login / Signup </a></li>
</ul>
</div>
</section>
<!--Inner Header End--> 


<!--Causes Start-->
<section class="wf100  login-signup">
<div class="container">
<div class="row">


<div class="col-lg-4">
<div class="login-box">
<h3>Login Account</h3>
<div class="input-group">
<input type="text" class="form-control" name="userEmailId" id="userEmailId" placeholder="Username/Email" required>
</div>
<div class="input-group">
<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Password" required>
</div>
<div class="input-group form-check">
<input type="checkbox" class="form-check-input" id="exampleCheck2">
<label class="form-check-label" for="exampleCheck2">Remember Me</label>
<a href="#" class="fp">Forgot Password</a> 
</div>
<div class="input-group">
<button class="login-btn" onclick="return checkLogin();">Login Account</button>
</div>
</div>
</div>

<div class="col-lg-8">
<div class="myaccount-form">
<h3>Register Your Account</h3>
<form action="#" >
<ul class="row">
<li class="col-md-6">
<div class="input-group">
<input type="text" class="form-control" name="yourName" id="yourName" placeholder="Your Name" required>
</div>
</li>
<li class="col-md-6">
<div class="input-group">
<input type="text" class="form-control" name="contact" id="contact" placeholder="Contact #" required>
</div>
</li>
<li class="col-md-6">
<div class="input-group">
<input type="text" class="form-control" name="userEmail" id="userEmail" placeholder="Email Address" required>
</div>
</li>
<li class="col-md-6">
<div class="input-group">
<input type="text" class="form-control" placeholder="User Name" name="userName" id="userName">
</div>
</li>
<li class="col-md-6">
<div class="input-group">
<input type="text" class="form-control" placeholder="Password" name="password" id="password">
</div>
</li>
<li class="col-md-6">
<div class="input-group">
<input type="text" class="form-control" placeholder="Re-enter Password" name="repassword" id="repassword">
</div>
</li>

<li class="col-md-12">
<div class="input-group form-check">
<input type="checkbox" class="form-check-input" id="exampleCheck1">
<label class="form-check-label" for="exampleCheck1">I agree to the Terms of <a href="#">Services & Privacy Plicy</a></label>
</div>
</li>

			<li class="col-md-12"> 
				<button class="register" onclick="registration()">Register Your Account</button>
			</li>

</ul>
</form>
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



<!-- includes function START-->

<!-- includes function END-->   
    
    
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