<%@ page import="cn.com.guilongkeji.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: xgl
  Date: 2020/2/24
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户页面</title>
  </head>
  <body>
  <%
    User user = (User) session.getAttribute("user");
  if (user!=null){
  %>
  编号：<%=user.getId()%>
  用户名：<%=user.getUsername()%>
  密码：<%=user.getPassword()%>
  性别：<%=user.getSex()%>
  学号：<%=user.getSno()%>
  工作:<%=user.getWork()%>
  兴趣爱好：<%=user.getFavorite()%>
  个人说明：<%=user.getNote()%>
  <%
  } else{
    %>
  <input type="button" value="登录" onclick="location.href='jsp/login.jsp'">
  <%
  }
  %>
  </body>
</html>
