<%@ page import="model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kristina Baleva
  Date: 6/18/2020
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Title</title>
</head>
<body>
<h1>Result from calculation</h1>
    <table border="1">
        <tr>
            <td>Employee Id</td>
            <td>Project Id</td>
            <td>Start date</td>
            <td>End Date</td>
        </tr>
<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>

  <%  for (Employee employee : employees) {
      out.println(
          String.format("<tr>"
                  + "<td>"  + employee.getEmpId() + "</td>"
                  + "<td>"  + employee.getProjectId() + "</td>"
                  + "<td>"  + employee.getDateFrom() + "</td>"
                  + "<td>"  + employee.getDateTo() + "</td>"
                  + "</tr>"
          ));
    }
%>
</table>
</body>
</html>
