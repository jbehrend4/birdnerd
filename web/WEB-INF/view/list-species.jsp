<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Species</title>
    <link href="resources/css/birds.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrapper">
        <button onclick="window.location.href='addSpecies'; return false;">Add Species</button>

        <form:form action="search" method="get">
            <input type="search" name="searchTerm">
            <input type="submit" value="Search">
        </form:form>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Animal Type</th>
            </tr>
            <c:forEach var="species" items="${species}">
                <c:url var="edit" value="/updateSpecies">
                    <c:param name="id" value="${species.speciesID}"/>
                </c:url>
                <tr>
                    <td>${species.speciesID}</td>
                    <td>${species.speciesName}</td>
                    <td>${species.animalTypeID}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
