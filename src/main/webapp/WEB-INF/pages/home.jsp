<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
            defer></script>
</head>
<body>
<h1>Welcome</h1>
<c:if test="${Students.size() eq 0}">
    <p>No Items to display</p>
</c:if>

<c:if test="${Students.size() gt 0}">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Country</th>
            <th>Language</th>
            <th>OS</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stud" items="${Students}">
            <tr>
                <td>
                    ${stud.getId()}
                </td>
                <td>
                    ${stud.getFirstName()}
                </td><td>
                    ${stud.getLastName()}
                </td>
                <td>
                    ${stud.getCountry()}
                </td><td>
                    ${stud.getLanguage()}
                </td><td>
                    ${stud.getOS()}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>