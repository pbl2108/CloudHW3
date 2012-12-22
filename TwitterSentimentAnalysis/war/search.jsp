<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Twitter Sentiment Analysis</title>
		<link type="text/css" rel="stylesheet" href="/css/styles.css" />
	</head>
	
	<body>
		<h1>Enter keyword to search Twitter.</h1>
		<form action="/search" method="post">
		    <div>
		    	<input type="text" name="keywords" class="searchTxt" />
		    	<input type="submit" value="Search Tweets" class="searchButton" />
		    </div>
  		</form>
	</body>
</html>