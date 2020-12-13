<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please register/login or you will only be able to download TXT files!
    </div>
    <div class="form-style-2">
        <form action="${pageContext.request.contextPath}/addUser">
            <input type="submit" value="Register/Login" name="conf"/>
        </form>
        <form action="${pageContext.request.contextPath}/jsp/download.jsp">
            <input type="submit" value="Download file" name="conf"/>
        </form>
        <form action="${pageContext.request.contextPath}/changeAccess">
            <input type="submit" value="Admin(Limited access)" name="conf"/>
        </form>
        <form action="${pageContext.request.contextPath}/exit">
            <input type="submit" value="Exit" name="conf"/>
        </form>
    </div>
</div>
</body>
</html>