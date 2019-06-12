<%@ page import="model.User" %><%--
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
    User user = (User) request.getAttribute("user");
    out.println("Welcome "+user.getUsername());
%>

<form action="AuthorizedController" method="post">
    N : <input type="text" name="N"> <BR>
    <input type="hidden" name="user" value="<%=user.getUsername()%>">
    <input type="submit" value="View top N URLs"/>
</form>

<form action="AuthorizedController" method="get">
    URL : <input type="text" name="url"> <BR>
    <input type="hidden" name="user" value="<%=user.getUsername()%>">
    <input type="submit" value="Add URL"/>
</form>


</body>
</html>
