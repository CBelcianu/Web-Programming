<%@ page import="ro.model.PartialUser" %>
<%@ page import="ro.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Catalin
  Date: 11/06/2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gj</title>
</head>
<body>
<%
    PartialUser user = (PartialUser) request.getAttribute("user");
    out.println("Welcome "+user.getUsername());
%>
<form action="ProfileController" method="post">
    <input type="hidden" name="username" value="${user.getUsername()}">
    <input type="hidden" name="password" value="${user.getPassword()}">
    <input type="submit" value="View Profile"/>
</form>

<form action="ProfilesController" method="post">
    <input type="hidden" name="username" value="${user.getUsername()}">
    <input type="submit" value="View Profiles"/>
</form>

</body>
</html>
