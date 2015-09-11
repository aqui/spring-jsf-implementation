<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>akif batur - blog</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/images/terminal.ico" rel="icon">
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</head>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" var="userName" />
	</sec:authorize>
	
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">aqui@aqui~$</a>
				</div>
				<div class="collapse navbar-collapse" id="mainNavBar">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="">home</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${empty userName}">
							<li>
								<a href="${pageContext.request.contextPath}/signup">signup</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/login">login</a>
							</li>
						</c:if>
						<c:if test="${not empty userName}">
							<li>
								<a href="${pageContext.request.contextPath}/author">${userName}</a>
							</li>
							<li>
								<c:url var="logoutUrl" value="/logout" />
								<form action="${logoutUrl}" method="post" name="logoutForm">
									<sec:csrfInput />
								</form> 
								<a href="#" onclick='document.logoutForm.submit();'>logout</a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</body>
</html>