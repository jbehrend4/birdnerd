<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<html>
<head>
    <title>Error Page</title>
    <link href="resources/css/birds.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrapper">
        <h2>An error has occurred.</h2>
        <br>
        <h4>${errorMessage}</h4>
    </div>
</body>
</html>
