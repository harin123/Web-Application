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
			<li class="current_page_item"><a href="#">Home</a></li>
			<li><a href="#">Blog</a></li>
			<li><a href="#">Photos</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Links</a></li>
			<li class="last"><a href="Sign Up.html">Sign Up</a></li>
		</ul>
	</div>
	<div id="two-columns">
<h2> SIGN UP </h2>
<div id="col1">


 
<form:form action="signupsubmit" commandName="user"
				method='post' accept-charset='UTF-8' id="springloginform"><br>
				<div align="center">
<p id="focus">(please enter all details)</p>
<label for="First Name">First Name</label>
<input type="text" class="color" name="fname">
<br><br><br>
<label for="Last Name">Last Name</label>
<input type="text" name="lname"><br><br><br>
<label for="phone">Phone</label> 
<p  id="press">XXX-XXX-XXXX</p>
<input type="text" name="phone"><br><br><br>
<label for="Username">Username</label>
<input type="text" name="username" maxlength="10" required>       Max length is 10<br><br><br>
<label for="Password">Password</label>
<input type="password" name="password" maxlength="6">              Max length is 6<br><br><br>
<label for="Address">Address</label>
<input type="text" name="address">
<br><br>
<input type="submit" value="Submit" />
<input type="reset" value="Reset" />
</div>
</form:form>
 

<p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>

			
		</div>
		<div id="col2"><img src="<c:url value="/resources/images/books.jpg"/>" alt="" width="260" height="240" class="image-style" />
			<div class="text-style">BOOKS</div>
		</div>
	</div>

 
 

</body>
</html>