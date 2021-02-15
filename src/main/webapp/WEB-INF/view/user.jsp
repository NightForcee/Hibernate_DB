<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
Hi ${sessionScope.name} It's User's page.
<jsp:include page="util.jsp"/>
</body>
</html>
