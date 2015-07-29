<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<link type="text/css" rel="stylesheet" href="resources/css/minified/style.min.css"  media="screen,projection"/>
</head>
<body>
<h3><spring:message code="${message}.label"  /> <spring:message code="login.label"  /></h3>
<div>
<form action='j_spring_security_check' method='POST'>
<input type="text" name="username"  placeholder="<spring:message code="userName.label"  />">
<input type="password" name="password" placeholder="<spring:message code="password.label"  />">
<input type="submit" value="<spring:message code="submit.label"  />">
</form>
<a href="?language=ar">Arabic</a>
<a href="?language=en">English</a>
<a href="?language=zh_CN">Chinese</a>
<a href="?language=fr">French</a>
<a href="?language=de">German</a>
<a href="?language=it">Italian</a>
<a href="?language=ja">Japanese</a>
<a href="?language=es">Spanish</a>
<a href="?language=sv">Swedish</a>
<a href="?language=zh_CN"></a>

</div>
<div>
<form action="adduser">
<input type="text" name="username"  placeholder="<spring:message code="userName.label"  />">
<input type="password" name="password" placeholder="<spring:message code="password.label"  />">
<input type="submit" value="<spring:message code="submit.label"  />">
</form>
</div>
<a href="home">Home</a>


</body>


</html>