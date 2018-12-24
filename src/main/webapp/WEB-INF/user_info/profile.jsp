<%@ taglib prefix="cd" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
    <h2>Profile information</h2>
    <div>
        Name: <cd:out value="${username}"></cd:out>
    </div>
    <div>
        Email: <cd:out value="${email}"></cd:out>
    </div>
</div>
</body>
</html>
