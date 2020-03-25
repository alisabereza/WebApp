<%@ page import="java.util.List" %>
<%@ page import="com.berezovska.User" %><%--
  Created by IntelliJ IDEA.
  User: oleksandraberezovska
  Date: 25.03.2020
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td style="text-align: center">username</td>
        <td style="text-align: center">email</td>

    </tr>
    </thead>
    <tbody>
    <% for (User user: (List<User>)request.getAttribute("users")) {%>
    <tr>
        <td>
            <%=user.getName()%>
        </td>
        <td>
            <%=user.getEmail()%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
