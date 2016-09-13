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
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="index.html">Home</a></li>
			<li><a href="giftcard.html">GiftCards</a></li>
                        <li><a href="cart.html">My Cart</a></li>
                        <li><a href="booksearch.html">Book Search</a></li>
                        <li><a href="#">Purchase History</a></li><br>
			
	</div>


	<div id="img1">
          <img src="images/gift1.jpg" style="width:304px;height:228px">
           Price : 25$



           <input type="submit" value="Add to Cart"><br><br>

          </div>
	<div id="img2">
          <img src="images/gift card.jpg" style="width:304px;height:228px">
           Price : 35$



           <input type="submit" value="Add to Cart">
        </div>
</div>
</div>
</form>
</body>
</html>