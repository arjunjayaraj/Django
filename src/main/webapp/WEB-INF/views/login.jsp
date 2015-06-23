<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
</head>
<body>
<h3>${message}</h3>
<div>
<form action="adduser">
<input type="text" name="username">
<input type="password" name="password">
<input type="submit">
</form>
</div>
</body>

</html>