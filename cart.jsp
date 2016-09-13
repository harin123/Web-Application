<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>ONLINE BOOK STORE</title>
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>" />

<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.gallerax-0.2.js"></script>
<style type="text/css">
@import "gallery.css";

</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">ONLINE BOOK STORE</a></h1>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="index.html">Home</a></li>
			<li><a href="booksearch.html">Book Search</a></li>
			<li><a href="giftcard.html">GiftCards</a></li>
                       <li><a href="#">Purchase History</a></li><br>
			
		</ul>
	</div>
<div id="two-columns">
		<div id="col1">
			
	
	<ul class="products">
		<li>
			<a href="#" class="item">
				<img src="<c:url value="/resources/images/cbook2.jpg"/>"/>
				<div>
					<p>Invitation to Computer Science</p>
					<p>Price:$25</p>
				</div>
			</a>
		</li>
		<li>
			<a href="#" class="item">
				<img src="images/ebook1.png"/>
				<div>
					<p>Digital Electronics</p>
					<p>Price:$25</p>
				</div>
			</a>
		</li>
		
	</ul>
	<div class="cart">
		<h1>Shopping Cart</h1>
		<div style="background:#fff">
		<table id="cartcontent" fitColumns="true" style="width:300px;height:auto;">
			<thead>
				<tr>
					<th field="name" width=140>Name</th>
					<th field="quantity" width=60 align="right">Quantity</th>
					<th field="price" width=60 align="right">Unit Price</th>
				</tr>
			</thead>
		</table>
		</div>
		<br />
		<button id="Rem" onClick=removeProduct()>Remove Item</button>
		<p class="total">Total: $0</p>
		<h2>Drop here to add to cart</h2>
	</div>

</div>
		<div id="col2"><img src="<c:url value="/resources/images/books.jpg"/>" alt="" width="260" height="240" class="image-style" />
			<div class="text-style">BOOKS</div>
		</div>
	</div>	
	</div>
</body>


</html>