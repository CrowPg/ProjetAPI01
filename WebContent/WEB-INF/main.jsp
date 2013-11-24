<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String name_page = (String) request.getAttribute("page"); %>
<% String css = (String) request.getAttribute("css"); %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Projet API01 - J2EE</title>
		<style type="text/css">
			<%= css %>
		</style>
	</head>
	<body>
		<div id="page">
			<div id="header">
				<div id="banner">
					<span>Projet API01 - J2EE</span>
				</div>
				<div id="menu">
					<span>
						<a href="?page=index">Index</a>
					</span>
					
					<span>
						<a href="?page=test">Test</a>
					</span>
					
					<span>
						<a href="?page=error">Erreur</a>
					</span>
				</div>
			</div>
			
			<div id='content'>
				<jsp:include page="<%= name_page %>" />
			</div>
			
			<div id='footer'>
				<p>Projet réalisé par Yoann CHAUMIN, Johan MEDIONI et Emilien NOTARIANI | Tous droits réservés</p>
			</div>
		</div>
	</body>
</html>