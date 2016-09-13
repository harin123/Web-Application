<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>ONLINE BOOK STORE</title>
<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="<c:url value="/resources/styles/style.css"/>" />

<script type="text/javascript"
	src="<c:url value="/resources/scripts/jquery-1.8.3.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/jquery.validate.min.js"/>"></script>

<%-- <script type="text/javascript"
	src="<c:url value="/resources/scripts/jquery-1.4.2.min.js"/>"></script> --%>

<script type="text/javascript"
	src="<c:url value="/resources/scripts/jquery.gallerax-0.2.js"/>"></script>
<style type="text/css">
@import "gallery.css";
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#spanuser").hide();
				$("#spanpassword").hide();
				<c:if test="${loginForm.errorMsg eq null}">
				$("#loginerrormsg").hide();
				

				</c:if>
				$("#txtusername").focus();
				$("#loginbut").bind(
						'click',
						function() {
							var retFlag = true;

							if (($("#txtusername").val() == null)
									|| ($("#txtusername").val() == "")) {
								retFlag = false;

								$("#spanuser").show();
								$("#txtusername").focus();
								return false;
							}
							$("#spanuser").hide();

							if (($("#txtpassword").val() == null)
									|| ($("#txtpassword").val() == "")) {
								retFlag = false;

								$("#spanpassword").show();
								$("#txtpassword").focus();
								return false;
							}
							$("#spanpassword").hide();

							if (retFlag == true) {
								doSubmit();
							}
						});
				$('input').keypress(function(e) {
					if (e.which == 13) {
						doSubmit();
					}
				});

			});

	function doSubmit() {
		$("#springloginform").submit();
	}
</script>
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
				<li class="current_page_item"><a href="index">Home</a></li>
				<li><a href="booksearch">Book Search</a></li>
				<li><a href="#">GiftCards</a></li>
				<li><a href="login">Login</a></li>
				<li class="last"><a href="signup">Sign Up</a></li>
			</ul>
		</div>
		<span id="loginerrormsg" class="loginerrormsg"><c:if
				test="${loginForm.errorMsg ne null}">${loginForm.errorMsg}</c:if> <c:if
				test="${loginForm.errorMsg eq null}">Javascript is not enabled</c:if></span>
		<div id="loginform">

			<div id="two-columns">
				<div id="col1">
					<h2>Login:</h2>
					<form:form action="authenticate" commandName="loginForm" method='post'
						accept-charset='UTF-8' id="springloginform">
						<label for="Username">Username</label>
						<form:input path="username" type="text" value="" id="txtusername"
							maxlength="40" />
						<span id="spanuser" class="errorMessage"> please enter user
							name</span>
						<br>
						<label for="Password">Password</label>
						<form:password path="password" value="" id="txtpassword" maxlength="15" />
						<span id="spanpassword" class="errorMessage"> please enter
							password</span>

						<br>
						<br>
						<br>
						<input type="button" value="Login" name="loginbut" id="loginbut" />
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
	</div>
</body>
</html>