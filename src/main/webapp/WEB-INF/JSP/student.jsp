<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生查询</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/findStudentWithBanji" method="post">
    学生编号：<input type="text" name="stu_id"/><br>
    所属班级：<input type="text" name="banji.banji_name"><br>
    <input type="submit" value="查询">
</form>
</body>
</html>