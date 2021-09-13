

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>入门程序</title>
</head>
<body>
<form:form modelAttribute="user" mothod="post" action="">
<table>
    <tr>
        <td>日期类型:</td>
        <td><form:input path="birthday"/></td>
    </tr>
</table>
</form:form>
</body>
</html>