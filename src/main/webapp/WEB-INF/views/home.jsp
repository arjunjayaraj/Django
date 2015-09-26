<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
	<link type="text/css" rel="stylesheet" href="resources/css/minified/style.min.css"  media="screen,projection"/> 
<head>
	<title>Home</title>
</head>
<body>
<div><h1>
	Hello world! ${message}  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</div>
<div><a href="login" class="link">SIGN IN</a></div>
</body>
</html>
