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
			<li><a href="giftcard">GiftCards</a></li>
                        <li><a href="login.html">Login</a></li>
			<li class="last"><a href="signup">Sign Up</a></li>
		</ul>
	</div>
	<div id="two-columns">
		<div id="col1">
			<h2>About us:</h2>
			<p>Online Book Store can be used to buy books relates various fields like Computer Science, Electronics,Mechanical and many others. </p>
			<p>Online Book Store also offers various Gift Cards.<br />
			</p>
			<p><a href="#" class="link-style2">Etiam posuere augue</a></p>
		</div>
		<div id="col2"><img src="<c:url value="/resources/images/books.jpg"/>" alt="" width="260" height="240" class="image-style" />
			<div class="text-style">BOOKS</div>
		</div>
	</div>
	
	<div id="welcome">
		<h2 class="title"><a href="#">Welcome to Online Book Store</a></h2>
		<div class="entry">
			<p>This is <strong>Online Book Store </strong>, a website where you can find a wide variety of books related to your respective fields. 
In addition to these you can also check our website for Journals, Magazines and other interesting stuff like giftcards.</p>
		</div>
	</div>
	<!-- end #page --> 
</div>
<div id="footer">
	<p>Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>
