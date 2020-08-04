<div class="_1QQpsu _3bWLGx">
<div class="mvW8vq">
<div class="_1U-Jli"></div>
<div class="FqIVIZ"> Please Potate your Device for Best Resolution </div>
</div>
</div>

<!--Header Start-->
<header class="header-style-2">
<nav class="navbar navbar-expand-lg">
<a class="navbar-brand" href="<%=request.getContextPath() %>/">
<img src="<%=request.getContextPath() %>/resources/images/Logo-FrangipaniBooks.png" alt="">
</a> 
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <i class="fas fa-bars"></i> </button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">

<ul class="navbar-nav">

<li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath() %>/book"> Books </a> </li>
<li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath() %>/category"> Category  </a> </li>
<li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath() %>/authors"> Authors </a> </li>
<li class="nav-item"> <a class="nav-link" href="#"> Authors </a> </li>
<!-- <li class="nav-item"> <a class="nav-link" href="#"> Testimonials </a> </li> -->
<li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath() %>/contact"> Contact </a> </li>

 
</ul>

<ul class="topnav-right">

<!--
<li class="login-reg"> 
<a href="#"> Sign up </a> | <a href="#">Sign In</a> 
</li>
-->



<!--<li class="dropdown">
<a class="cart-icon" href="my-account.html"> 
<i class="fa fa-user-circle"></i>
</a>
</li>-->



<li class="dropdown">
<a class="cart-icon" href="#" role="button" id="cartdropdown" data-toggle="dropdown"> 
<i class="fa fa-user-circle"></i>
</a>
<div style="width: 210px; padding: 10px 10px 20px 10px;" class="dropdown-menu cart-box" aria-labelledby="cartdropdown">


<% if(session.getAttribute("userName")!=null) {%>
	<a href="<%=request.getContextPath() %>/my_order"> My Orders </a>
	<a href="<%=request.getContextPath() %>/manage_address"> Manage Addresses  </a>
	<a href="#"> Change Password </a>
	<div class="logout-btn">
	  	<a href="<%=request.getContextPath() %>/logout"> Logout </a> 
	</div>
<% }else{ %> 
	<a href="<%=request.getContextPath() %>/my_account"> Login </a>	
<% } %> 


</li>



<li class="dropdown">
<a class="cart-icon" href="#" role="button" id="cartdropdown" data-toggle="dropdown"> <i class="fas fa-shopping-cart"></i> <span class="badge">02</span> </a>
<div class="dropdown-menu cart-box" aria-labelledby="cartdropdown">
Recently added item(s)
<ul class="list">

<div id="cartData"></div>

<%-- <li class="item">
<a href="#" class="preview-image">
<img class="preview" src="<%=request.getContextPath() %>/resources/images/books/1.jpg" alt="">
</a>
<div class="description"> 
<a href="#"> Things Every Child Show Know About J.B .Danquah </a> 
<strong class="price"> 1 x µ40.00 </strong> 
</div>
</li> --%>

<%-- <li class="item">
<a href="#" class="preview-image">
<img class="preview" src="<%=request.getContextPath() %>/resources/images/books/2.jpg" alt="">
</a>
<div class="description"> 
<a href="#"> Things Every Child Show Know About J.B .Danquah </a> 
<strong class="price"> 1 x â40.00 </strong> 
</div>
</li> --%>

</ul>
<div class="total">Total: <strong>80.00</strong></div>
<div class="view-link"> 
<a href="<%=request.getContextPath() %>/checkout">Proceed to Checkout</a> 
<a href="<%=request.getContextPath() %>/viewCart">View cart </a></div>
</div>   
</li>


</ul>

</div>
</nav>
</header>

<!--Header End--> 


