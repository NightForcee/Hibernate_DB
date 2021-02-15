<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
Hi ${sessionScope.name} It's Admins page.
<br>
<jsp:include page="util.jsp"/>
</body>
</html>
