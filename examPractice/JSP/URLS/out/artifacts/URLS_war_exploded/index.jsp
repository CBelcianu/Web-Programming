<%--
  Created by IntelliJ IDEA.
  User: Catalin
  Date: 12/06/2019
  Time: 11:27
  To change this template use File | Settings | File Templates.

  Solve the following problem using the JSP/Servlet technology.
  State information (between web requests) is always stored in a database;
  you may store some state information in cookies/session objects.
  Write a web application for maintaining a collection of URLs for a list of users.
  Each user can add or delete URLs from his/her collection.
  The user must authenticate prior to using the application.
  A guest user can still see a list with the top 10 most popular URLs, but an authenticated user
  can see a list with the top N most popular URLs, where N is configurable by the user.
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
<form action="UnauthorizedController" method="post">
  <input type="submit" value="View top 10 URLs"/>
</form>
</body>
</html>
