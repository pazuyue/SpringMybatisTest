<%--
  Created by IntelliJ IDEA.
  User: yueguang
  Date: 2021-06-01
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form:form modelAttribute="user2" action="register" method="post">
    <table>
        <tr>
            <td><label><spring:message code="loginname"/></label></td>
            <td><form:input path="loginname"/></td>
            <td><form:errors path="loginname" cssStyle="color: red  "/></td>
        </tr>
        <tr>
            <td><label><spring:message code="birthday"/> </label></td>
            <td><form:input path="birthday"/></td>
            <td><form:errors path="birthday" cssStyle="color: red  "/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit"/>"> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
