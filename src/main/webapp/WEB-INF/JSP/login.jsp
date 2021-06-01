<%--
  Created by IntelliJ IDEA.
  User: yueguang
  Date: 2021-05-29
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><spring:message code="title"/></h3>
<form action="login2" method="post">
    <table>
        <tr>
            <td><label><spring:message code="loginname"/></label></td>
            <td><input type="text" id="loginname" name="loginname"></td>
        </tr>
        <tr>
            <td><label><spring:message code="password"/> </label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit"/>"> </td>
        </tr>
    </table>
</form>
</body>
</html>
