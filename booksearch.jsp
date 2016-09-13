<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.bookstore.infra.misc.wrapper.ResponseMessageWrapper"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.bookstore.web.util.RESTUtil"%>

<%@page import="org.apache.shiro.session.mgt.SessionContext"%>
<%@page import="org.apache.shiro.session.*" %>

<%


	Subject currentUser = SecurityUtils.getSubject();
	ApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
	Session userSession=currentUser.getSession();
	RESTUtil restUtil = (RESTUtil) context.getBean("restUtil");
	

	int start=0;
	int maxconstant=10;
	int pagestart=0;
			
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>ONLINE BOOK STORE</title>
<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="<c:url value="/resources/styles/style.css"/>" />

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
				<h1>
					<a href="#">ONLINE BOOK STORE</a>
				</h1>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="index.html">Home</a></li>
				<li><a href="giftcard">GiftCards</a></li>
				<li><a href="cart">My Cart</a></li>
				<li><a href="#">Purchase History</a></li>
				<br>
		</div>
		<div id="two-columns">
			<div id="col1">
				<form:form action="searchsubmit" commandName="book" method='get'
					accept-charset='UTF-8' id="springloginform">
					<label for="Search">Search</label>
					<input type="text" name="search">

					<input type="submit" align="center" value="Search" />
					<br>
					<br>
					<br>
Advanced Search:<br>
					<br>
					<label for="Title">Title</label>
					<input type="text" name="title">
					<br>
					<br>
					<br>
					<label for="Author">Author</label>
					<input type="text" name="author">
					<br>
					<br>
					<input type="submit" value="Search" />

					<br>
					<br>
					<br>

				</form:form>

			</div>
			<div id="col2">
				<img src="<c:url value="/resources/images/books.jpg"/>" alt=""
					width="260" height="240" class="image-style" />
				<div class="text-style">BOOKS</div>
			</div>
		</div>
		</div>
</body>
</html>