<%--
  Created by IntelliJ IDEA.
  User: xgl
  Date: 2020/2/24
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String error=(String) request.getSession().getAttribute("error");
    if (error!=null) {
%>
<script>
    alert ("登录失败");
</script>
<%
    }
%>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="请输入用户名"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
