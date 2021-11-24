<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23-Nov-21
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="addProduct" modelAttribute="product">
    Name: <form:input path="name"/> <br>
    Description: <form:input path="description"/> <br/>
    Price: <form:input path="price"/> <br/>
    <input type="submit" value="Gửi"/>
</form:form>
</body>
</html>
