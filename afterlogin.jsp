<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.apache.shiro.session.Session"%>
<%@page import="com.bookstore.infra.misc.wrapper.ResponseMessageWrapper"%>
<%@page	import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.bookstore.web.util.RESTUtil"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	ApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
	Subject curruser=SecurityUtils.getSubject();
	Session userSession=curruser.getSession();
	String username =(String)userSession.getAttribute("username");
	RESTUtil restUtil = (RESTUtil) context.getBean("restUtil");
	pageContext.setAttribute("username", username);

%>
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
			<li><a href="#">GiftCards</a></li>
                        <li><a href="cart.html">My Cart</a></li>
                        <li><a href="#">Purchase History</a></li>
			
		</ul>
	</div>
	<div align="right"><h3>Welcome ${username}</h3></div>
	<div id="two-columns">
		<div id="col1">
			<h2>About us:</h2>
			<p>Online Book Store can be used to buy books relates various fields like Computer Science, Electronics,Mechanical and many others. </p>
			<p>Online Book Store also offers various Gift Cards.<br />
			</p>
					</div>
		<div id="col2"><img src="<c:url value="/resources/images/books.jpg"/>" alt="" width="260" height="240" class="image-style" />
			<div class="text-style">BOOKS</div>
		</div>
	</div>
	</div>
