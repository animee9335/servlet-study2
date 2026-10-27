    <%@ page import="practice.pr01.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 27.
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Book> bookList = (List<Book>) request.getAttribute("book-list");
%>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #222;
            border-collapse: collapse;
        }

        th, td{
            border: 1px solid #222;
            width: 300px;
            height: 40px;
        }
    </style>
</head>
<body>
<div>
    <button onclick="location.href='/book/register'">등록</button>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>도서명</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>
        <%
            // 스크립틀릿
            for (Book book : bookList) {
        %>
            <tr>
                <td><%=book.getId()%></td>
                <td><%=book.getTitle()%></td>
                <td><%=book.getPrice()%></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
