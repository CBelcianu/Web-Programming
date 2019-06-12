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


<form action="TopicsController" method="post">
    <input type="hidden" name="user" value="<%=user.getUsername()%>"/>
    <input type="submit" value="View Topics"/>
</form>

<form action="TopicsController" method="get">
    <input type="hidden" name="user" value="<%=user.getUsername()%>"/>
    topic name : <input type="text" name="topic"> <BR>
    description : <input type="text" name="description"> <BR>
    <input type="submit" value="Add Topic"/>
</form>


</body>
</html>
