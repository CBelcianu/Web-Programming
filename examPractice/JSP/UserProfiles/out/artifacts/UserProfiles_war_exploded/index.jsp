<%--
  Created by IntelliJ IDEA.
  User: Catalin
  Date: 11/06/2019
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Here</title>
  <script src="script.js"></script>
</head>
<body>
<form action="LoginController" method="post">
  Enter username : <input type="text" name="username"> <BR>
  Enter password : <input type="password" name="password"> <BR>
  <input type="submit" value="Login"/>
</form>
<button onclick="toRegister()">Register</button>
</body></html>
