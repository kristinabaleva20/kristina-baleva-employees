<%--
  Created by IntelliJ IDEA.
  User: Kristina Baleva
  Date: 6/19/2020
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error page. Please contact with support.</h1>
<% out.println(request.getAttribute("error"));%>
</body>
</html>
