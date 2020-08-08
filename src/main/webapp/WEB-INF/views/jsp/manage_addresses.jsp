<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title> Manage Addresses | Frangipani Books </title>

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
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/font-awesome-4.7.0/css/font-awesome.min.css">                


<!-- CSS  -->
<link href="<%=request.getContextPath() %>/resources/css/custom.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/color.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/responsive.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/owl.carousel.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/prettyPhoto.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/all.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/checkout.css" rel="stylesheet">
<!-- CSS  --> 


<!-- includes js File START--> 
<script src="<%=request.getContextPath() %>/resources/js/w3data.js"></script>
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
<li><a href="index.html">Home</a></li>
<li> Manage Addresses </li>
</ul>
</div>
</section>
<!--Inner Header End--> 

<!--Causes Start-->
<section class="wf100 p80 events">
<div class="event-list-two">
<div class="container">

<div style="padding-bottom: 2em" class="row">
<div class="col-lg-12 text-right">
<button style="color: #fff;
    background-color: #ed008c;
    border-color: #ed008c;" data-toggle="modal" data-target="#AddNewAddressModal"  type="submit" class="btn-upper  btn btn-primary checkout-page-button checkout-continue "> ADD A NEW ADDRESS </button>
</div>
</div>

    

<div class="row">
<div class="col-lg-12">
<!-- Default box --> 
<div id="addreesList"></div>

 



<!-- Default box -->
<!-- <div style="padding: 0px 10px 0px 10px;     background: #f8f9fa;
    border: 1px solid #eeeeee;" class="box  box-default">
<div class="box-headerwith-border">

<h3 style="font-size: 17px;
padding: 15px 0px 15px 0px;
border-bottom: 1px solid #ccc;" class="box-title"> Bargav N. Bhatt 
    <span class="label label-default">office</span>
</h3>

<div class="box-tools pull-right">
<button style="margin-top: -97px;  padding: 5px 15px 5px 15px;" class="btn bg-teal btn-sm" data-widget="remove"><i class="fa fa-ellipsis-v"></i></button>

</div>

</div>

<div class="box-body">
<p> 507 Sears Gotri Road, Sevasi, Vadodara, Gujarat 391101 </p>
<p>Mobile: 9427611304 </p>
</div>/.box-body
  
</div>/.box -->


</div>
</div>


<!-- <div class="row">
<div class="col-md-12">
<div class="gt-pagination mt20">
<nav>
<ul class="pagination">
<li class="page-item"> <a class="page-link" href="#" aria-label="Previous"> <i class="fas fa-angle-left"></i> </a> </li>
<li class="page-item"><a class="page-link" href="#">1</a></li>
<li class="page-item active"><a class="page-link" href="#">2</a></li>
<li class="page-item"><a class="page-link" href="#">3</a></li>
<li class="page-item"> <a class="page-link" href="#" aria-label="Next"> <i class="fas fa-angle-right"></i> </a> </li>
</ul>
</nav>
</div>
</div>
</div>
 --> 
</div>
</div>
</section>
<!--Causes End--> 

<!--/#footer START-->
<%@include file="includes/footer.jsp" %>
<!--/#footer END-->

</div>



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
<input class="form-control" placeholder="E-mail" name="newUserEmail" id="newUserEmail" type="text"  />
</div>
</div>
 
<div class="form-group row">
<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
<input class="form-control" placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" type="text" />
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
<textarea class="form-control" name="specialInstruction" id="specialInstruction" placeholder="Special Instructions: (Max Length: 500 Characters)" rows="3"></textarea>
<input type="hidden" name="addressId" id="addressId">

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
			id : $("#addressId").val()   
		},success:function(data){
			getAddAddress();  
			$('#AddNewAddressModal').modal('hide');
		},error : function(e){
			console.log("Error :::"+e)
		} 
	});
}

function updateNewAddress(){
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


function getAddAddress(){
	$.ajax({  
		type : "POST",
		url : "<%=request.getContextPath()%>/getUserAddress",
		data : {
		},success:function(data){
			
			var getAddressList = "";
			for (var i = 0; i < data.length; i++) {
				getAddressList +=	'<div style="padding: 0px 10px 0px 10px;     background: #f8f9fa;border: 1px solid #eeeeee;" class="box  box-default">'+
				'<div class="box-headerwith-border">'+
				 
				'<h3 style="font-size: 17px;padding: 15px 0px 15px 0px;border-bottom: 1px solid #ccc;" class="box-title">'+data[i].fullName +  
				    /* '<span class="label label-default">Home</span>'+ */ 
				'</h3>'+
				
					'<div class="box-tools pull-right">'+ 
					'<button data-toggle="modal" data-target="#AddNewAddressModal"  style="margin-top: -97px;  padding: 5px 15px 5px 15px;" onclick="getAddressById('+data[i].id+')"  class="btn bg-teal btn-sm"><i class="fa fa-ellipsis-v"></i></button>'+
					'</div>'+				
				'</div>'+
				
				'<div class="box-body">'+
				'<p> '+data[i].add1  +' '+data[i].add2  +'</p>'+
				'<p> '+data[i].country+' '+data[i].state +' </p>'+
				'<p> '+data[i].city+' '+data[i].pinCode+'  </p>'+
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

function getAddressById(addressId){
	
	$.ajax({  
		type : "POST",
		url : "<%=request.getContextPath()%>/getAddressById",
		data : {
			addressId : addressId,
		},success:function(data){	
			$("#fullName").val(data.fullName);
			  $("#newUserEmail").val(data.userEmail);
			  $("#mobileNumber").val(data.mobileNumber);
			  $("#add1").val(data.add1);
			  $("#add2").val(data.add2);
			  $("#country").val(data.country);
			  $("#state").val(data.state);
			  $("#city").val(data.city);
			  $("#pinCode").val(data.pinCode);
			  $("#specialInstruction").val(data.specialInstruction); 
			  $("#addressId").val(addressId);
			 
		},error : function(e){
			console.log("Error :::"+e)
		}
	});
}

</script>

<script src="<%=request.getContextPath() %>/resources/checkout/bootstrap.min.js"></script> 

<!--   JS Files Start  --> 
<%-- <script src="<%=request.getContextPath() %>/resources/js/jquery-3.3.1.min.js"></script> --%> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/popper.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-migrate-1.4.1.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/owl.carousel.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/jquery.prettyPhoto.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/isotope.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/js/custom.js"></script>

</body>


</html>