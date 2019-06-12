<%--
  Created by IntelliJ IDEA.
  User: Catalin
  Date: 12/06/2019
  Time: 07:47
  To change this template use File | Settings | File Templates.

  Solve the following problem using the JSP/Servlet technology.
  State information (between web requests) is always stored in a database; you may store some state information in cookies/session objects.
  Write a web application for a forum. Users must identify themselfs prior to entering the forum.
  Each user can start a new topic or can comment (post) on an existing topic. Each user must be able to delete its own posts (comments).
  The posts of a topic should be displayed in a single web page.

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
</body>
</html>
