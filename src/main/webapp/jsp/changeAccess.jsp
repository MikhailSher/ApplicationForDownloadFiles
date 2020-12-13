<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please select a user and change access parameters!
    </div>
    <form method="post" action="${pageContext.request.contextPath}/changeAccess">
        <label for="name">First Name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="access">
            <select name="access" id="access">
                <option value="allowed">allowed</option>
                <option value="prohibited">prohibited </option>
            </select>
        </label>
        <input type="submit" value="Change">
    </form>
</div>
<div class="form-style-2">
<form action="${pageContext.request.contextPath}/start">
    <input type="submit" value="Home" name="conf"/>
</form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered!
    </div>
    <table>
        <tr>
            <th>First Name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.access}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
