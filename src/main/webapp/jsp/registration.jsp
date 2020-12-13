<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Please register/login!
    </div>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <label for="name">First Name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="password_signUp">Password
            <input class="input-field" type="password" id="password_signUp" name="password_signUp">
        </label>
        <input type="submit" value="Sign Up">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please add user
    </div>
    <form method="post" action="${pageContext.request.contextPath}/addUser">
        <label for="first-name">First Name
            <input class="input-field" type="text" id="first-name" name="first-name">
        </label>
        <label for="last-name">Last Name
            <input class="input-field" type="text" id="last-name" name="last-name">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <input type="submit" value="Add user">
    </form>
</div>
<div class="form-style-2">
    <form action="${pageContext.request.contextPath}/start">
        <input type="submit" value="Home" name="conf"/>
    </form>
</div>
</body>
</html>
