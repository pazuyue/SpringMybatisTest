<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/20
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSON交互</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
        function testJson() {
            var loginname = $("#loginname").val();
            var password = $("#password").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/testJson",
                type:"post",
                data:JSON.stringify({loginname:loginname,password:password}),
                contentType:"application/json;charset=UTF-8",
                dataType:"json",
                success:function (data) {
                    if (data != null){
                        alert("您输入的登录名为："+data.loginname+"密码为："+data.password);
                    }
                }
            });
        }
    </script>
</head>
<body>
<form>
    登录名：<input type="text" name="loginname" id="loginname"><br>
    密码：<input type="password" name="password" id="password"><br>
    <input type="button" value="JSON交互" onclick="testJson()" />
</form>
</body>
</html>
