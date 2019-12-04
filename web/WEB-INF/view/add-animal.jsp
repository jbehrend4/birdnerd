<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Animal</title>
    <link href="resources/css/birds.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrapper">
        <h3>Add an Animal</h3>
        <form:form action="save" modelAttribute="species" enctype="multipart/form-data">
            <form:hidden path="id" value="${species.speciesID}"></form:hidden>

            <table>
                <tr>
                    <td><label>Species Name</label></td>
                    <td><form:input path="speciesID"/></td>
                </tr>
                <tr>
                    <td><label>Animal Type</label></td>
                    <td><form:select items="${animalType}" path="animalTypeID"
                                     itemLabel="animalTypeName" itemValue="animaltypeid">
                    </form:select></td>
                </tr>
            </table>

        </form:form>
    </div>
</body>
</html>
