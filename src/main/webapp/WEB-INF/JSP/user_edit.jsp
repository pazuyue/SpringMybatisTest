<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/20
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/editUsers" method="post">
    <table>
        <tr>
            <td>选择</td>
            <td>用户名</td>
        </tr>
        <tr>
            <td><input name="userList[0].id" value="1" type="checkbox"></td>
            <td><input name="userList[0].nickname" value="zhangsan" type="text"></td>
        </tr>
        <tr>
            <td><input name="userList[1].id" value="2" type="checkbox"></td>
            <td><input name="userList[1].nickname" value="lisi1" type="text"></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
