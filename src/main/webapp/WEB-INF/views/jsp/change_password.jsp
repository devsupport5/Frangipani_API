<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Change Password | Frangipani Books </title>

<meta http-equiv="ScreenOrientation" content="autoRotate:disabled">
<meta name="theme-color" content="#ED008C">

<link rel="apple-touch-icon" sizes="152x152" href="images/favicon/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
<link rel="manifest" href="images/favicon/site.webmanifest">
<link rel="mask-icon" href="images/favicon/safari-pinned-tab.svg" color="#5bbad5">
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

 
<!-- Font Awesome -->
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">                

  
<link href="css/custom.css" rel="stylesheet">
<link href="css/color.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="css/owl.carousel.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/all.min.css" rel="stylesheet">
<link href="resources/css/checkout.css" rel="stylesheet">
 

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
<li> Change Password </li>
</ul>
</div>
</section>
<!--Inner Header End--> 

<!--Causes Start-->
<section class="wf100 p80 events">
<div class="event-list-two">
<div class="container">



<div class="row">

<div class="col-md-3"></div>

<div class="col-lg-6">
<!-- Default box -->
<div style="padding: 0px 10px 0px 10px;" class="box  box-default call-action-style1 call-action-boxed">
<div class="box-headerwith-border">

<h3 style="font-size: 17px;
padding: 15px 0px 15px 0px;
border-bottom: 1px solid #ccc;" class="box-title"> Change Password 
</h3>


</div>

<div class="box-body">
<!-- content goes here -->
<form>
<span><font size="3" id="errorCurrentPassword" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span>
<input type="password" class="form-control" placeholder="Current Password" id="currentPassword" onchange="checkUserPassword();">
</div>

<span><font size="3" id="errorNewPassword" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span>
<input type="password" class="form-control" placeholder="New Password" id="newPassword">
</div>
 
<span><font size="3" id="errorConfirmPassword" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span>
<input type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword">
</div>

</form>

</div><!-- /.box-body -->
<center><span><font size="3" id="successCurrentPassword" color="red"></font> </span></center> 
<div class="box-footer"> 
<a class="checkout-btn1" href="#" onclick="return checkValidation();"> SAVE </a>
</div>
    
</div><!-- /.box -->


</div>

<div class="col-md-3"></div>
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
<script>
w3IncludeHTML();
</script>
<!-- includes function END-->   



<script src="<%=request.getContextPath() %>/resources/checkout/jquery-1.11.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/checkout/bootstrap.min.js"></script> 


<script src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery.prettyPhoto.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/isotope.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/custom.js"></script>

<!--   JS Files Start  --> 
<!--<script src="js/jquery-3.3.1.min.js"></script> -->
<script src="js/jquery-migrate-1.4.1.min.js"></script> 
<script src="js/popper.min.js"></script> 
<!--<script src="js/bootstrap.min.js"></script> -->
<script src="js/owl.carousel.min.js"></script> 
<script src="js/jquery.prettyPhoto.js"></script> 
<script src="js/isotope.min.js"></script> 
<script src="js/custom.js"></script>


<script type="text/javascript">

function checkValidation(){
	var status = true;
	if($("#currentPassword").val()==""){ 
		$("#errorCurrentPassword").html("Please enter current password");
		setTimeout(function(){ $("#errorCurrentPassword").html(""); }, 7000);
		$("#currentPassword").focus();
		status = false;
	}  
	if($("#newPassword").val()==""){
		$("#errorNewPassword").html("Please enter new password");
		setTimeout(function(){ $("#errorNewPassword").html(""); }, 7000);
		$("#newPassword").focus();
		status = false;
	}   
	
	var pass = true;
	if($("#confirmPassword").val()==""){
		$("#errorConfirmPassword").html("Please retype password");
		setTimeout(function(){ $("#errorConfirmPassword").html(""); }, 7000);
		$("#confirmPassword").focus();
		status = false;
		pass = false;
	}  
	  
	if($("#confirmPassword").val()!=$("#newPassword").val() && pass){  
		$("#errorConfirmPassword").html("Password and retyped password did not match");
		setTimeout(function(){ $("#errorConfirmPassword").html(""); }, 7000);
		$("#confirmPassword").focus();
		status = false; 
	}
	
	
  if(status){
	  
	  $.ajax({
			type : "POST", 
			url : "<%=request.getContextPath()%>/updatePassword",
			data : {
				updatePassword : $("#newPassword").val(),
				
			},success:function(data){
				     
				if(data==true){ 
					$("#successCurrentPassword").html("Password changed successfully.");
					setTimeout(function(){ $("#successCurrentPassword").html(""); }, 7000);
					$("#currentPassword").val("");
					$("#newPassword").val("");
					$("#confirmPassword").val(""); 
					window.location = "<%=request.getContextPath()%>/logout";
				}
				
				 
				
			},error : function(e){ 
				console.log("Error :::"+e)
			}
		});
	  
  }
}

function checkUserPassword(){
	$.ajax({
		type : "POST", 
		url : "<%=request.getContextPath()%>/checkUserPassword",
		data : {
			currentPassword : $("#currentPassword").val(),
			
		},success:function(data){
			   
			if(data==false){ 
				$("#errorCurrentPassword").html("Please enter correct password");
				setTimeout(function(){ $("#errorCurrentPassword").html(""); }, 7000);
				$("#currentPassword").val("");
				$("#currentPassword").focus();	
			}
			
			 
			
		},error : function(e){ 
			console.log("Error :::"+e)
		}
	});
  	
}

</script>




</body>


</html>