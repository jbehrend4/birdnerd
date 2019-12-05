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
            <form:hidden path="speciesID" value="${species.speciesID}"></form:hidden>

            <table>
                <tr>
                    <td><label>Species Name</label></td>
                    <td><form:input path="speciesName"/></td>
                </tr>
                <tr>
                    <td><label>Animal Type</label></td>
                    <td><form:select items="${animalType}" path="animalTypeID"
                                     itemLabel="animalTypeName" itemValue="animalTypeID">
                    </form:select></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>
    </div>
</body>
</html>
