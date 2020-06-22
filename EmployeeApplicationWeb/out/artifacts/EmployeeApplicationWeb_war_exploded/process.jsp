<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Title</title>
</head>
<body>
<%
    String message =  (String)request.getAttribute("message");
    String filePath =(String)request.getAttribute("filePath");
    response.getWriter().println(String.format("<h1>" + message + "</h1>"));

%>

<form action = "getEmployee">
    Click button to see employees with the longest internship in a project
    <%session.setAttribute("filePath", filePath); %>
    <input type = "submit">
</form>
</body>
</html>