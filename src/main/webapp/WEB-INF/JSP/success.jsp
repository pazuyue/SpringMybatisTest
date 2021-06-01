<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>入门程序</title>
</head>
<body>
成功了，叼毛
<spring:message code="loginname"/> ${user.loginname}
<spring:message code="birthday"/> ${user.birthday}
</body>
</html>