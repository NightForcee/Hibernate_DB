<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<jsp:useBean id="roles" scope="request" type="java.util.List"/>
<c:forEach var="r" items="${roles}">
    <a href="/${r.name}"> ${r} </a>
    <br>
</c:forEach>
<br>
<a href="<c:url value="/start"/>">HOME</a>
<a href="<c:url value="/"/>">Back to login form</a>
</body>
</html>