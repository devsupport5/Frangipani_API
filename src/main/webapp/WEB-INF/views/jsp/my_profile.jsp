<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Profile | Frangipani Books </title>

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
<li><a href="#"> Profile </a></li>
</ul>
</div>
</section>
<!--Inner Header End--> 


<!--Causes Start-->
<section class="wf100  login-signup">
<div class="container">
<div class="row">


<div class="col-lg-4">
<%-- <div class="login-box">
<h3>Login Account</h3> 
<span><font size="errorValidUser" id="errorValidUser" color="white"></font> </span> 
<span><font size="erroruserEmailId" id="erroruserEmailId" color="white"></font> </span>
<div class="input-group">

<input type="text" class="form-control" name="userEmailId" id="userEmailId" placeholder="Username/Email" required>
</div>
<span><font size="erroruserPassword" id="erroruserPassword" color="white"></font> </span>
<div class="input-group">
<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Password" required>
</div>
<div class="input-group form-check">
<input type="checkbox" class="form-check-input" id="exampleCheck2">
<label class="form-check-label" for="exampleCheck2">Remember Me</label>
<a href="<%=request.getContextPath()%>/forgotPasswprd" class="fp">Forgot Password</a> 
</div> 

<div class="input-group">
<button class="login-btn" onclick="return checkLogin();">Login Account</button>
</div>
</div> --%>
</div>
<div class="col-lg-2">
</div>
<div class="col-lg-8">
<div class="myaccount-form">
<h3>Edit Profile</h3>
<form >
<ul class="row">

<li class="col-md-6">
<span><font size="errorCheckName" id="errorCheckName" color="red"></font> </span>
<div class="input-group">   
<input type="text" class="form-control"   name="yourName" id="yourName" value="${userRegister.yourName }" placeholder="Your Name*" required>
</div>
</li>

<li class="col-md-6"></li>
<li class="col-md-6">
<span><font size="errorContact" id="errorContact" color="red"></font> </span>
<div class="input-group">
<input type="text" class="form-control" name="contact" id="contact" value="${userRegister.contact }" placeholder="Contact*" required>
</div>
</li>

<li class="col-md-6"></li>
<li class="col-md-6">
<span><font size="errorUserEmail" id="errorUserEmail" color="red"></font> </span>
<div class="input-group">
<input type="email" class="form-control" name="userEmail" id="userEmail" value="${userRegister.userEmail}" onchange="checkUserName(this,'userEmail')" placeholder="Email Address*" required>
</div> 
</li>



<li class="col-md-6"></li>    
<li class="col-md-6">
	<center><span><font size="4" id="successMessage" color="green"></font> </span></center>    
	<button class="register" onclick="return registration();">Update</button>
</li>

 <li class="col-md-6">
<span><font size="errorUserName" id="errorUserName" color="red"></font> </span>
<div class="input-group">
<input type="hidden" class="form-control" placeholder="User Name*" name="userName" value="${userRegister.userName}" id="userName" onchange="checkUserName(this,'userName')" required>
</div> 
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


<script type="text/javascript">
function registration(){
	 
	var status = true;
	if($("#yourName").val()==""){ 
		$("#errorCheckName").html("Please enter your name");
		setTimeout(function(){ $("#errorCheckName").html(""); }, 7000);
		$("#yourName").focus();
		status = false;
	}  
	if($("#contact").val()==""){
		$("#errorContact").html("Please enter contact number");
		setTimeout(function(){ $("#errorContact").html(""); }, 7000);
		$("#contact").focus();
		status = false;
	}   
	
	if($("#userEmail").val()==""){
		$("#errorUserEmail").html("Please enter email address");
		$("#userEmail").focus();
		setTimeout(function(){ $("#errorUserEmail").html(""); }, 7000);
		status = false;
	}
	
	if($("#userName").val()==""){
		$("#errorUserName").html("Please enter username");
		$("#userName").focus();
		setTimeout(function(){ $("#errorUserName").html(""); }, 7000);
		status = false;
	}
	   
  
	if(status){  
 	 $.ajax({
		type : "POST",
		url : "updateRegistration",
		data : { 
			
			yourName : $("#yourName").val(),
			contact : $("#contact").val(), 
			userEmail : $("#userEmail").val(),
			userName : $("#userName").val(),
			
			
		},success:function(data){
			//window.location.reload();
			 
		    $("#successMessage").html("Profile updated successfully");
			setTimeout(function(){ $("#successMessage").html(""); }, 7000);
			
		},error : function(e){
			console.log("Error :::"+e)
		}
	}); 
  }	  
 	 return false; 
}/* 
function registration(){
	     
	  
	/*   var validator = $("#registrationForm").validate({
          rules: {
              password: "required",
              confirmpassword: {
                  equalTo: "#password"
              }
          },
          messages: {
              password: " Enter Password",
              confirmpassword: " Enter Confirm Password Same as Password"
          }
      });
	  
      if (validator.form()) {
          alert('Sucess'); 
           
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
          
     /*  } 
	//return false;
	
} */


function checkLogin(){
	
	
	var status = true;
	if($("#userEmailId").val()==""){ 
		$("#erroruserEmailId").html("Please enter username");
		setTimeout(function(){ $("#erroruserEmailId").html(""); }, 7000);
		$("#userEmailId").focus();
		status = false;
	}  
	if($("#userPassword").val()==""){
		$("#erroruserPassword").html("Please enter password");
		setTimeout(function(){ $("#erroruserPassword").html(""); }, 7000);
		$("#userPassword").focus(); 
		status = false;
	}  
if(status){	
	$.ajax({
		type : "POST",
		url : "checkValidUser",
		data : {
			"userEmailId" : $("#userEmailId").val(),
			"userPassword" : $("#userPassword").val(), 
		},success:function(data){
			if(data==true){ 
				window.location.reload();
			}else{ 
				$("#errorValidUser").html("Please enter valid username & password");
				setTimeout(function(){ $("#errorValidUser").html(""); }, 7000);
			}
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
}
}  

function checkUserName(type,action){
	 $.ajax({
		type : "POST",
		url : "checkUserStatus",
		data : {  
			"value" : type.value,
			"action" : action, 
		},success:function(data){
			if(data==true){  
				if(action=="userEmail"){
					$("#userEmail").focus();
					$("#userEmail").val("");
					
					$("#errorUserEmail").html("Email address already registered.");
					setTimeout(function(){ $("#errorUserEmail").html(""); }, 7000);
					
				}else if(action=="userName"){
					$("#userName").focus();
					$("#userName").val("");
					 
					$("#errorUserName").html("Username already registered.");
					setTimeout(function(){ $("#errorUserName").html(""); }, 7000);
				}
			}
		},error : function(e){
			console.log("Error :::"+e)
		}
	});   
}

</script>
 

</body>


</html>