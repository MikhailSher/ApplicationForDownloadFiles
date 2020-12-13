<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
<h1>Download File</h1>
<h3>Please, select file to upload!</h3> <br/>
<form action="${pageContext.request.contextPath}/downloadOnlyTxt" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="100"/>
    <br>

    <br/>
    <input type="submit" value="Upload File"/>
</form>
    <form action="${pageContext.request.contextPath}/start">
        <input type="submit" value="Home" name="conf"/>
    </form>
</div>
</body>
</html>