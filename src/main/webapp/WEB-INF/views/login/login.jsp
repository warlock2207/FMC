<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/19 0019
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="/fmc/user/login" method="post" id="myform">
       <input type="text" id="username" name="username"/>
       <input type="password" id="password" name="password"/>
       <input type="submit" value="提交" id="login" />
   </form>
</body>
</html>
