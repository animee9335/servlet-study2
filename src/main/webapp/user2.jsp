<%@ page import="com.korai.servletstudy2.model.User" %><%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 26.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User2</title>
</head>
<body>
    <%=request.getAttribute("id")%>
    <%=request.getAttribute("username")%>
    <%=request.getAttribute("password")%>
</body>
</html>
