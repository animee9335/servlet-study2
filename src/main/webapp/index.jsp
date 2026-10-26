<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String[] names = {"일일일", "이이이"};
%>

<!DOCTYPE html>
<html>
<head>                               <%-- head, 브라우저의 정보영역 --%>
  <title>JSP - Hello World</title>
</head>
<body>                               <%-- body, 눈에 보이는 영역 --%>

    <div>                            <%-- div 내부는 블록영역 --%>
        <b>Hello World!</b>
        <h1><%=names[0]%></h1>
    </div>

    <%-- 따로 영역이 없으면 inline (글자 취급으로 된다) --%>
    <a href="hello">Hello Servlet</a>
    <button>확인</button>
    <button>취소</button>
</body>
</html>