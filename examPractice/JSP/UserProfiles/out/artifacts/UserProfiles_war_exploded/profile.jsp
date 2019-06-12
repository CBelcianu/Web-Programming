<%@ page import="ro.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Catalin
  Date: 11/06/2019
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-3.3.1.js"></script>
    <script src="script.js"></script>
</head>
<body>
<%
    User user = (User) request.getAttribute("user1");
    out.println("Welcome "+user.getUsername()+" from "+user.getTown());
%>
<br>
<img src="<%=user.getPhoto()%>" width="200px" height="170px">
<br>
<label>username:</label><input id="inputUsername" value="<%=user.getUsername()%>"><br>
<label>password:</label><input id="inputPassword" value="<%=user.getPassword()%>"><br>
<label>email:</label><input id="inputEmail" value="<%=user.getEmail()%>"><br>
<label>town:</label><input id="inputTown" value="<%=user.getTown()%>"><br>

<form action="ProfileController" method="get">
    <input type="hidden" name="username" value="${user.getUsername()}">
    <input type="hidden" name="password" value="${user.getPassword()}">
    <input type="hidden" name="email" value="${user.getEmail()}">
    <input type="hidden" name="town" value="${user.getTown()}">
    <input type="submit" value="Update">
</form>

<button onclick="updProf()">Update Profile</button>

</body>
</html>
