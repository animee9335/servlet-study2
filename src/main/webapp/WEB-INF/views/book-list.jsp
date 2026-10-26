<%@ page import="com.korai.servletstudy2.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 26.
  Time: 오후 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>

<html>
<head>
    <title>BookList</title>
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
    <button onclick="location.href='/book/register'">등록</button>
    <div>
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
                for(Book book : bookList){
            %>
            <tr>
                <td><%=book.getId()%></td>
                <td><%=book.getBookName()%></td>
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
