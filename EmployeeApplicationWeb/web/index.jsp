<%@ page import="model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="static sun.misc.Version.print" %><%--
  Created by IntelliJ IDEA.
  User: Kristina Baleva
  Date: 6/18/2020
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Employees with the longest internship in project </title>
  </head>
  <body>
  <h1>Welcome in my Application</h1>
  <form action="uploadFile" method="post" enctype="multipart/form-data">
    Select File to Upload:
    <br>
    <input type="file" name="fileName">
    <br>
    <input type="submit" value="Upload">
  </form>
  </body>
</html>
