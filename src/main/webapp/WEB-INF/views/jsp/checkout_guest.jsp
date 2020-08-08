<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Check Out | Frangipani Books </title>

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
<link rel="stylesheet" href="resources/font-awesome-4.7.0/css/font-awesome.min.css">                

<!-- CSS  -->
<link href="resources/css/custom.css" rel="stylesheet">
<link href="resources/css/color.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<link href="resources/css/owl.carousel.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/all.min.css" rel="stylesheet">
<link href="resources/css/checkout.css" rel="stylesheet">
<!-- CSS  -->


<!-- includes js File START-->
<script src="resources/js/w3data.js"></script>
<!-- includes js File END-->

<script type="text/javascript">
 
function registration(){
	 
	if($("#yourName").val()==""){
		$("#errorCheckName").html("Please enter user name");
		$("#yourName").focus();
	}else if($("#contact").val()==""){
		$("#errorContact").html("Please enter contact number");
		$("#contact").focus();
		$("#errorCheckName").html("");
	}else if($("#userEmail").val()==""){
		$("#errorUserEmail").html("Please enter email");
		$("#userEmail").focus();
		$("#errorCheckName").html("");
		$("#errorContact").html(""); 
	}else if($("#userName").val()==""){
		$("#errorUserName").html("Please enter user name");
		$("#userName").focus(); 
		$("#errorCheckName").html("");
		$("#errorContact").html(""); 
		$("#errorUserName").html(""); 
	}else if($("#password").val()==""){
		$("#errorPassword").html("Please enter password");
		$("#password").focus();  
	}else if($("#repassword").val()==""){
		$("#errorRePassword").html("Please enter re-password");
		$("#repassword").focus();   
	}else if($("#termsConditionChk").is(":checked")==false){
		$("#errortermsConditionChk").html("Please check terms and condition");
	}else{  
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
			window.location.reload(); 
		},error : function(e){
			console.log("Error :::"+e)
		}
	}); 
  }	 
 	 return false; 
}
</script>

    

</head>
<body class="cnt-home">





<div class="wrapper">

<!--/header START-->
<%@include file="includes/header.jsp" %> 
<!--/header END-->



<!--Inner Header Start-->
<section class="wf100 inner-header">
<div class="container">
<ul>
<li><a href="<%=request.getContextPath()%>/">Home</a></li>
<li> Check Out </li>
</ul>
</div>
</section>
<!--Inner Header End--> 




<div class="body-content">
<div class="container">
<div class="checkout-box ">
<div class="row">

<div class="col-xs-12 col-sm-9 col-md-9 rht-col">
<div class="panel-group checkout-steps" id="accordion">

<!--Login or Signup checkout-step-01  -->
<div class="panel panel-default checkout-step-01">

<!-- panel-heading -->
<div class="panel-heading">
<h4 class="unicase-checkout-title">
<a data-toggle="collapse" class="" data-parent="#accordion" href="#collapseOne" > 
<span>1</span> Login or Signup
</a>
</h4>
</div>
<!-- panel-heading -->

<c:if test="${fn:length(guestMobileNumber) == 0  }">
<div id="collapseOne" class="panel-collapse collapse in" >

<!-- panel-body  -->
<div class="panel-body">

<div class="row">	




<!-- already-registered-login -->
<div class="col-md-6 col-sm-6 already-registered-login">
<div class="login-box-chec">
<h3>Login Account</h3> 
<form action="#" method="post">
<div class="input-group">
<input type="text" class="form-control" name="userEmailId" id="userEmailId" placeholder="Username/Email" required  >
</div>
<div class="input-group">
<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Password" required>
</div>  
<div class="input-group form-check">
<input type="checkbox" class="form-check-input" id="exampleCheck2">
<label class="form-check-label" for="exampleCheck2">Remember Me</label>


  
<a data-toggle="modal" data-target="#FPasswordModal" href="#" class="fp">Forgot Password</a>
 
</div> 
<div class="input-group">
<button class="login-btn" onclick="return checkLogin();">Login Account</button>  
  <center style="margin-top: 10px;" ><span><font color="white" size="3" id="errorLoginMessage"></font></center></span>
</div>   
</form> 
</div>
</div>	
<!-- already-registered-login -->		




<!-- guest-login -->			
<div class="col-md-6 col-sm-6 guest-login">


<!-- Default box -->
<div class="box register">
<div class="box-header with-border">
<h3 class="box-title"> Register and save time </h3>
</div>
<div class="box-body">
<p> Register with us for future convenience: </p>
<ul style="margin: 0; padding: 0px 0px 16px 20px;" class="text instruction inner-bottom-30">
<li class="save-time-reg">- Fast and easy check out</li>
<li>- Easy access to your order history and status</li>
</ul>
<button data-toggle="modal" data-target="#RegisterModal" type="submit" class="btn-upper wf100 btn btn-primary checkout-page-button checkout-continue "> Register Now </button>
</div><!-- /.box-body -->
</div><!-- /.box -->





<!-- Default box -->
<div class="box guest">
<div class="box-header with-border">
<h3 class="box-title"> Continue as a guest user  </h3>
</div>
<div class="box-body">
<button data-toggle="modal" data-target="#GuestUserModal" type="submit" class="btn-upper wf100 btn btn-primary checkout-page-button checkout-continue"> Checkout as Guest </button>
</div><!-- /.box-body -->
</div><!-- /.box -->




</div>
<!-- guest-login -->


</div>			

</div>
<!-- panel-body  -->

</div><!-- row -->
</c:if>
</div>
<!-- checkout-step-01  -->




<!-- Delivery Address checkout-step-02  -->
<div class="panel panel-default checkout-step-02">
<div class="panel-heading">
<h4 class="unicase-checkout-title">
<a data-toggle="collapse" class="collapsed" data-parent="#accordion" href="#collapseTwo">
<span>2</span> Delivery Address
</a>
</h4>
</div>
<div id="collapseTwo" class="panel-collapse collapse">
<div class="panel-body">

<div class="row">
<div class="col-lg-12">

<!-- Default box -->
<div id="addreesList"> </div>
<!-- End Default box -->

<!-- Default box -->

</div>
</div>



    
<div class="row">
<div class="col-lg-12 text-center">
<a  data-toggle="modal" data-target="#AddNewAddressModal" href="#" class="lm wf100"> Add a new address </a>
</div>
</div>

</div>
</div>
</div>
<!-- Delivery Address checkout-step-02  -->




<!-- Order Summary checkout-step-03  -->
<div class="panel panel-default checkout-step-03">
<div class="panel-heading">
<h4 class="unicase-checkout-title">
<a data-toggle="collapse" class="collapsed" data-parent="#accordion" href="#collapseThree">
<span>3</span> Order Summary 
</a>
</h4>
</div>
<div id="collapseThree" class="panel-collapse collapse">
<div class="panel-body">
<div class="row">


<div class="box box-default" id="cartMessage">
<div style="text-align: center;padding: 15px;" id="deleteMessage"> ${error }</div> 
<div class="box-header with-border">   
<h3 class="box-title"> My Cart (<span id="myCart"></span>) </h3>
</div>

<div class="box-body">
<div class="table-responsive">
<table class="table table-bordered">
	<thead>
		<tr>
			<th> Product </th>
			<th  class="text-right"> Price </th>
			<th class="text-center" style="width: 17%;"> Quantity </th>
			<th  class="text-right"> Total </th>
			<th  class="text-right">  </th>
		</tr>
	</thead>
<tbody id="cartList">
 
	
<!-- <tr>

<td>
<div class="widget-thumb">
<a href="#"><img src="images/books/1.jpg" alt=""></a>
</div>
<div class="widget-content">
<h5><a href="#"> Things Every Child Show Know About J.B .Danquah </a></h5>
<span> <strong>Author:</strong> Abyna-Ansaa Adjei </span> <br>
<span> <strong>Book Category:</strong> Drama, Romance </span>
</div>
<div class="clearfix"></div>
</td>

<td class="text-right"> ₵40.00 </td>

<td>
<div class="input-group">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-minus"></i>
</button>
</span>

<input style="    height: auto; padding: 0px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="1" min="1" max="10">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-plus"></i>
</button>
</span>

</div>
</td>

<td class="text-right"> ₵40.00 </td>

<td class="text-right remove"> 
<a href="#">
<i class="fa fa-trash"></i> 
</a>
</td>

</tr>
 -->
<!-- <tr>

<td>
<div class="widget-thumb">
<a href="#"><img src="images/books/1.jpg" alt=""></a>
</div>
<div class="widget-content">
<h5><a href="#"> Things Every Child Show Know About J.B .Danquah </a></h5>
<span> <strong>Author:</strong> Abyna-Ansaa Adjei </span> <br>
<span> <strong>Book Category:</strong> Drama, Romance </span>
</div>
<div class="clearfix"></div>
</td>

<td class="text-right"> �40.00 </td>

<td>
<div class="input-group">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-minus"></i>
</button>
</span>

<input style="    height: auto; padding: 0px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="1" min="1" max="10">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-plus"></i>
</button>
</span>

</div>
</td>

<td class="text-right"> �40.00 </td>

<td class="text-right remove"> 
<a href="#">
<i class="fa fa-trash"></i> 
</a>
</td>

</tr>


<tr>

<td>
<div class="widget-thumb">
<a href="#"><img src="images/books/1.jpg" alt=""></a>
</div>
<div class="widget-content">
<h5><a href="#"> Things Every Child Show Know About J.B .Danquah </a></h5>
<span> <strong>Author:</strong> Abyna-Ansaa Adjei </span> <br>
<span> <strong>Book Category:</strong> Drama, Romance </span>
</div>
<div class="clearfix"></div>
</td>

<td class="text-right"> ₵40.00 </td>

<td>
<div class="input-group">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-minus"></i>
</button>
</span>

<input style="    height: auto; padding: 0px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="1" min="1" max="10">

<span class="input-group-btn">
<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" data-field="quant[1]">
<i style="font-size: 11px;" class="fa fa-plus"></i>
</button>
</span>

</div>
</td>

<td class="text-right"> ₵40.00 </td>

<td class="text-right remove"> 
<a href="#">
<i class="fa fa-trash"></i> 
</a>
</td>

</tr> --> 

</tbody>

<tfoot>
<tr>

<td colspan="3" class="text-right"><strong> Subtotal:  </strong> </td>
<td class="text-right"><strong id="subTotal">  </strong></td>
<td>  </td>  

</tr>

<tr>

<td colspan="3" class="text-right"><strong> Total: </strong> </td>
<td class="text-right"><strong id="finalTotal">  </strong></td>
<td>  </td>

</tr>

</tfoot>


</table>
</div>
</div><!-- /.box-body -->

<div class="box-footer" id="pleaceOrderButton">  
<a class="checkout-btn" href="#">  Make Payment  </a>
</div>

</div><!-- /.box -->
</div>
</div>
</div>
</div>
<!-- Order Summary checkout-step-03  -->



</div><!-- /.checkout-steps -->
</div>





<!--Price details Start-->
<div class="col-xs-12 col-sm-3 col-md-3 sidebar">
<div class="box box-primary">
<div class="box-header with-border">
<h3 class="box-title"> Order Summary </h3>
</div>


<div class="box-body">
<div class="order-summary">
<ul class="list-group">
 
<li class="list-group-item">  
Quantity <!-- (<span id="orderCartItem"></span>) -->
<span class="pull-right"> <span id="orderCartItem"></span> <!-- <span id="orderCartTotal"></span> --> </span> 
</li>

<li class="list-group-item">  
Price <!-- (<span id="orderCartItem"></span>) -->
<span class="pull-right"> <span id="orderCartTotal"></span> </span> 
</li>

<!-- <li class="list-group-item">
Delivery Charges
<span class="pull-right"> 00.00 </span>
</li> 
 --> 
<li class="list-group-item">
<strong>Amount Payable
<span class="pull-right"> <span id="orderCartFinalTotal"></span> </span>
</strong>
</li> 

</ul></div>
  
</div><!-- /.box-body -->

</div>		 	
</div>

</div><!-- /.row -->
</div><!-- /.checkout-box -->



</div><!-- /.container -->
</div><!-- /.body-content -->



<!--/#footer START-->
<div w3-include-html="includes/footer.html"></div> 
<!--/#footer END-->

</div>






<!-- includes function START-->
<script>
w3IncludeHTML();
</script>
<!-- includes function END-->   







<!-- Get New register with as new user. Modal Start-->
<div class="checkout-process-modal modal fade" id="RegisterModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true"></span>X<span class="sr-only">Close</span></button>
<h3 class="modal-title" id="lineModalLabel">
Register Your Account
</h3>
</div>
<form method="post" id="loginForm" name="loginForm">
<div class="modal-body">

<!-- content goes here -->


<span><font size="errorCheckName" id="errorCheckName" color="red"></font> </span> 
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-user-circle"></i></span>
<input type="text" class="form-control" name="yourName" id="yourName" placeholder="Your Name" required>
</div> 

<span><font size="errorContact" id="errorContact" color="red"></font> </span> 
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-mobile"></i></span>
<input type="text" class="form-control" name="contact" id="contact" placeholder="Contact #" required>
</div>

<span><font size="errorUserEmail" id="errorUserEmail" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
<input type="text" class="form-control" placeholder="Email Address" name="userEmail" id="userEmail" required>
</div>

<span><font size="errorUserName" id="errorUserName" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
<input type="text" class="form-control" placeholder="User Name" id="userName" name="userName" id="userName">
</div>



<span><font size="errorPassword" id="errorPassword" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span>
<input type="password" class="form-control" placeholder="Password" name="password" id="password">
</div>

<span><font size="errorRePassword" id="errorRePassword" color="red"></font> </span>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span> 
<input type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="Re-enter Password">
</div>

<span><font size="errortermsConditionChk" id="errortermsConditionChk" color="red"></font> </span>
<div class="input-group form-check">
<input type="checkbox" class="form-check-input" id="termsConditionChk" >
<label class="form-check-label" for="exampleCheck1">I agree to the Terms of <a href="#">Services & Privacy Plicy</a></label>
</div>



</div>

<div class="modal-footer">
<div class="row">   
<div class="col-lg-12">  <!-- //validatePassword(); -->
<button type="button" class="btn-upper wf100 btn btn-primary checkout-page-button checkout-continue " onclick="return registration();" > Register Your Account </button>
</div> 
</div>
</div> 
</form>
</div>
</div>
</div>
<!-- Get New Registered with as new user. Modal End-->








<!-- CONTINUE AS A GUEST USER. Modal Start-->
<div class="checkout-process-modal modal fade" id="GuestUserModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">X</span><span class="sr-only">Close</span></button>
<h3 class="modal-title" id="lineModalLabel">
Continue as a guest user. 
</h3>
</div>
<form method="post" action="checkoutGuest" >
<div class="modal-body">

<!-- content goes here -->


<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
<input type="text" class="form-control" placeholder="Email address *" id="guestEmailAddress" name="guestEmailAddress">
</div>

<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-mobile"></i></span>
<input type="text" class="form-control" placeholder="Mobile Number *" name="guestMobileNumber" id="guestMobileNumber">
</div>

 

<div class="alert alert-info mb-0">
<strong>Note:</strong> Your order details will be sent to this email address & Mobile Number.
</div>



</div>

<div class="modal-footer">
<div class="row">
<div class="col-lg-12"> 
<button type="submit"   class="btn-upper wf100 btn btn-primary checkout-page-button checkout-continue "> CONTINUE </button>
</div>
</div> 	
</div>  
</form>
</div>
</div>
</div>
<!-- CONTINUE AS A GUEST USER. Modal End-->





<!-- Forgot Password? Modal Start-->
<div class="checkout-process-modal modal fade" id="FPasswordModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">X</span><span class="sr-only">Close</span></button>
<h3 class="modal-title" id="lineModalLabel">
Forgot Password?
</h3>
</div>
<div class="modal-body">

<!-- content goes here -->
<form>

<div class="row">
<div class="col-lg-12">
<label for="exampleInputEmail1"> Email address *</label>
<div class="form-group input-group">
<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
<input type="text" class="form-control" placeholder="Enter your Email">
</div>
</div>
</div>

 
<div class="alert alert-info mb-0">
<strong>Note:</strong> 
You have received Email from us
</div>

</form>

</div>

<div class="modal-footer">
<div class="row">
<div class="col-lg-12">
<button type="submit" class="btn-upper wf100 btn btn-primary checkout-page-button checkout-continue ">Submit </button>
</div>
</div>
</div>

</div>
</div>
</div>
<!-- Forgot Password? Modal End-->






<!-- Add a new address Modal Start-->
<div class="checkout-process-modal modal fade" id="AddNewAddressModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">X</span><span class="sr-only">Close</span></button>
<h3 class="modal-title" id="lineModalLabel">
Add a new address
</h3>
</div>
<div class="modal-body">
<form class="">

<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<input class="form-control" name="fullName" id="fullName" placeholder="Full Name" type="text" />
</div>
</div>

<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
<input class="form-control" placeholder="E-mail" name="newUserEmail" id="newUserEmail" type="text"  value="${guestEmailAddress }" disabled="disabled" />
</div>
</div>

<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
<input class="form-control" placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" type="text" value="${guestMobileNumber }" disabled="disabled"   />
</div>
</div>


<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
<input class="form-control" placeholder="Address line 1" name="add1" id="add1" type="text" />
</div>
</div>



<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
<input class="form-control" placeholder="Address line 2" id="add2" name="add2" type="text" />
</div>
</div>



<div class="form-group row">
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
		<select class="form-control" name="country" id="country">
			<option>Select Country</option>
			<option value="Ghana">Ghana </option>
		</select>
	</div>
	
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
		<select class="form-control"id="state" name="state">
			<option value="State">State </option>
			<option value="Ashanti">Ashanti</option>
			<option value="Bono Region">Bono Region</option>
			<option value="Bono East Region">Bono East Region</option>
			<option value="Ahafo Region">Ahafo Region</option>
			<option value="Central">Central</option>
			<option value="Central">Central</option>
			<option value="Greater Accra">Greater Accra</option>
			<option value="Northern">Northern</option>
			<option value="Savannah">Savannah</option>
			<option value="North East">North East</option>
			<option value="Upper East">Upper East</option>
			<option value="Upper West">Upper West</option>
			<option value="Volta Region">Volta Region</option>
			<option value="Oti">Oti</option>
			<option value="Western Region">Western Region</option>
			<option value="Western North">Western North</option>
		</select>  
	</div>
</div>


<div class="form-group row">
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
		<input class="form-control" placeholder="City" name="city" id="city" type="text" />
	</div>

<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
<input class="form-control" placeholder="PIN" name="pinCode" id="pinCode" type="text" />
</div>
</div>


<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
<textarea class="form-control" name="specialInstruction" id="specialInstruction" placeholder="Special Instructions: (Max Length: 100 Characters)" rows="3"></textarea>
</div>
</div>

</form>


</div>

<div class="modal-footer">
<div class="row">
<div class="col-lg-12">
<button type="button" onclick="return addNewAddress();" class="btn-upper wf100 btn btn-primary checkout-page-button checkout-continue "> Add </button>
</div>
</div>
</div>

</div>
</div>
</div>
<!-- Add a new address Modal End-->

 


<script src="<%=request.getContextPath() %>/resources/checkout/jquery-1.11.1.min.js"></script> 

<script type="text/javascript">
$( document ).ready(function() {
	cartList(); 
	getAddAddress();
	
	  
});  	

function addNewAddress(){
	$.ajax({
		type : "POST",
		url : "addNewAddress",
		data : { 
			fullName : $("#fullName").val(),
			userEmail : $("#newUserEmail").val(),
			mobileNumber : $("#mobileNumber").val(),
			add1 : $("#add1").val(),
			add2 : $("#add2").val(),
			country : $("#country").val(),
			state : $("#state").val(),
			city : $("#city").val(),
			pinCode : $("#pinCode").val(),
			specialInstruction : $("#specialInstruction").val(),
			
		},success:function(data){
			getAddAddress();  
			$('#AddNewAddressModal').modal('hide');
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
					'<strong class="price"> '+data[i].qty+' x '+data[i].currencySymbol +data[i].price+' </strong> '+
					'</div>'+
					'</li> <br /> '; 
					  
					cartTotal = data[i].qty * data[i].price; 
					cartFinalTotal = parseInt(cartTotal) + parseInt(cartFinalTotal);					   
				}  
			}else{
				cartData = "Cart is empty";
			}
			 
			 
			$("#cartData").html(cartData); 
			$("#cartTotal").html($("#currencySymbol").val()+""+cartFinalTotal.toFixed(2));
			$("#cateItemTotal").html(data.length);
			$("#orderCartItem").html(data.length);
			$("#orderCartTotal").html($("#currencySymbol").val()+""+cartFinalTotal.toFixed(2)); 
			$("#orderCartFinalTotal").html($("#currencySymbol").val()+""+cartFinalTotal.toFixed(2));
		},error : function(e){ 
			console.log("Error :::"+e)
		}
	});

}  


</script>


<script src="<%=request.getContextPath() %>/resources/checkout/bootstrap.min.js"></script> 

<!--   JS Files Start  --> 
<!--<script src="js/jquery-3.3.1.min.js"></script> -->
<script src="<%=request.getContextPath() %>/resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script> 
<!--<script src="js/bootstrap.min.js"></script> -->
<script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery.prettyPhoto.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/isotope.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/custom.js"></script>

<script>



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
			}else{ 
				$("#errorLoginMessage").html("Username and password incorrect.");
				setTimeout(function(){ $("#errorLoginMessage").html(""); }, 7000);
				return false;   
			}
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
	return false;
}
//setTimeout(function(){ alert("Hello"); }, 3000);

function getAddAddress(){
	$.ajax({  
		type : "POST", 
		url : "<%=request.getContextPath()%>/getGuestUserAddress",
		data : { 
			guestEmailAddress : $("#newUserEmail").val()
		},success:function(data){
			
			var getAddressList = "";
			for (var i = 0; i < data.length; i++) {
				var cssStyle = ""; 
				var backStyle = "";
				var isActive = "";
				
				if(data[i].defaultAddress=="0"){
					cssStyle = "box-success";
					backStyle = "aliceblue";
					isActive =""; 
				}else{
					cssStyle = "box-default";
					backStyle = "#fff";
					isActive ="checked";
				}  					
					 
getAddressList += '<div style="background-color:'+backStyle+' ; padding: 0px 10px 0px 10px;" class="box  '+cssStyle+'">'+
					'<div class="box-headerwith-border">'+ 
					'<h3 style="font-size: 17px;padding: 15px 0px 15px 0px;border-bottom: 1px solid #ccc;" class="box-title">'+ data[i].fullName
						+'<span class="label label-default">Home</span>'+
					'</h3>'+
					'<div class="box-tools pull-right">'+
						'<div  class="input-group form-check">'+
							'<input type="checkbox" '+isActive+' class="form-check-input" id="exampleCheck2">'+
							'<label class="form-check-label" for="exampleCheck2"> Deliver Here </label>'+
						'</div>'+ 
					'</div>'+
				'</div>'+
 
				'<div class="box-body">'+
				'<p> '+data[i].add1  +', '+data[i].add2  +'</p>'+
				'<p> '+data[i].city+' '+data[i].state +' </p>'+
				'<p> '+data[i].country+' '+data[i].pinCode+'  </p>'+
				'<p>Mobile: '+data[i].mobileNumber+' </p>'+
			   '</div>'+ 
				'</div>';
			}
				$("#addreesList").html(getAddressList);
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
} 

 
function cartList(){
	$.ajax({  
		type : "POST",
		url : "<%=request.getContextPath()%>/getCart",
		data : {
		},success:function(data){

			$('#cartList').empty();
			var cartList = ""; 
			var subTotal = 0; 
			var cartFinalTotal = 0; 
			for (var i = 0; i < data.length; i++) {
				
				var minusButtonStatus = "";
				if(data[i].qty==1){
					minusButtonStatus =	'<button type="button" class="btn btn-default btn-sm btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">'; 
				}else{
					minusButtonStatus =	'<button type="button" class="btn btn-default btn-sm btn-number" onclick="removeToCartButton('+data[i].orderId+')"  data-type="minus" data-field="quant[1]">';
				}
				
				
				cartList = '<tr><td>'+  
								'<div class="widget-thumb">'+
									'<a href="#"><img src="images/books/1.jpg" alt=""></a>'+
								'</div>'+
								'<div class="widget-content">'+
									'<h5><a href="#"> '+data[i].bookTitle+' </a></h5>'+
									'<span> <strong>Author:</strong> '+data[i].authorName+' </span> <br>'+
									'<span> <strong>Book Category:</strong> '+data[i].categoryName+' </span>'+
								'</div>'+ 
								'<div class="clearfix"></div>'+	
							'</td>'+
 
	'<td class="text-right"> '+$("#currencySymbol").val()+""+data[i].price.toFixed(2)+'</td>'+
	'<td>'+
	'<div class="input-group">'+
'	<span class="input-group-btn">'+
minusButtonStatus  +
	'<i style="font-size: 11px;" class="fa fa-minus"></i>'+
	'</button>'+
	'</span>'+  
	'<input style="    height: auto; padding: 5px 0px 0px 10px;" type="text" name="quant[1]" class="form-control input-sm input-number" value="'+data[i].qty+'" min="1" max="10">'+
	'<span class="input-group-btn">'+
	'<button type="button" class="btn btn-default btn-sm btn-number" data-type="plus" onclick="addToCart('+data[i].orderId+')"  data-field="quant[1]">'+
	'<i style="font-size: 11px;" class="fa fa-plus"></i>'+
	'</button>'+
	'</span>'+
	'</div>'+
	'</td>'+
	'<td class="text-right"> '+$("#currencySymbol").val()+""+(data[i].qty * data[i].price).toFixed(2)+' </td>'+
	'<td class="text-right remove"> '+ 
	'<a href="#" onclick="return removeToCart('+data[i].orderId+');">'+
	'<i class="fa fa-trash"></i> '+
	'</a>'+
	'</td>'+
	'</tr>';
	
	$('#cartList').append(cartList);
	
	subTotal = data[i].qty * data[i].price; 
	cartFinalTotal = parseInt(subTotal) + parseInt(cartFinalTotal);
	 
	
			}    
			 
			 $("#subTotal").html($("#currencySymbol").val()+""+cartFinalTotal.toFixed(2));
			 $("#finalTotal").html($("#currencySymbol").val()+""+cartFinalTotal.toFixed(2));
			 $("#myCart").html(data.length); 
			 
			 if(data.length==0){
				 $("#pleaceOrder").hide();  
				 $("#makePaymentButton").hide();  
				 $("#cartMessage").html("<div style='text-align:center;padding: 15px;'> Cart is empty <div>"); 
			 }
			 
			 
			/* var subTotal = 0; 
			 subTotal =  data[i].qty * data[i].price;
			 $("#subTotal").html(subTotal.toFixed(2));
			 $("#finalTotal").html(subTotal.toFixed(2));
			 $("#myCart").html(data.length); 
			  */
			//$("#cartList").html(cartList);

	
		},error : function(e){
			//console.log("Error :::"+e)
		}
	
}); 
}
   
  
function removeToCart(orderId){
	$.ajax({
		type : "POST", 
		url : "<%=request.getContextPath()%>/removeToCart",
		data : {
			orderId : orderId
		},success:function(data){
			getCart();		
			cartList(); 
			$("#deleteMessage").html("Book deleted successfully");
			setTimeout(function(){ $("#deleteMessage").html(""); }, 7000); 
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
} 


</script>    
<!-- <script src="resources/js/jquery-3.3.1.min.js"></script> -->
<!-- <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script> -->
 
<script type="text/javascript" src="https://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
    <script type="text/javascript" src="https://www.technicalkeeda.com/js/javascripts/plugin/jquery.validate.js"></script>
<script>
    function validatePassword() {
        var validator = $("#loginForm").validate({
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
        }
    }
 function checkoutGuest(){
	 $.ajax({
			type : "POST", 
			url : "<%=request.getContextPath()%>/checkoutGuest",
			data : {
				guestMobileNumber : $("#guestMobileNumber").val(),
				guestEmailAddress : $("#guestEmailAddress").val() 
			},success:function(data){ 
				 
			},error : function(e){
				console.log("Error :::"+e)
			}
		});
 }
 
 function addToCart(orderId){
	 	$.ajax({
	 		type : "POST", 
	 		url : "<%=request.getContextPath()%>/addToCart",
	 		data : {
	 			orderId : orderId,
	 			qty : 1, 
	 		},success:function(data){
	 			cartList();  
	 			getCart();
	 		},error : function(e){
	 			console.log("Error :::"+e)
	 		}
	 	}); 
	 }    

	 function removeToCartButton(orderId){
	 	$.ajax({
	 		type : "POST",  
	 		url : "<%=request.getContextPath()%>/removeToCartButton",
	 		data : {
	 			orderId : orderId,
	 			qty : -1, 
	 		},success:function(data){
	 			cartList();  
	 			getCart();
	 		},error : function(e){
	 			console.log("Error :::"+e)
	 		}
	 	}); 
	 }
    
    </script> 
    
    <input type="hidden" name="currencySymbol" id="currencySymbol" value="<%=session.getAttribute("currencySymbol")%>">
</body>


</html>