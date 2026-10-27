<%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 27.
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form onsubmit="handleOnSubmit(event)">
        <input type="text" name="productName" placeholder="상품명" onkeyup="handleOnChange(event)">
        <button>등록</button>

    </form>

    <script>
        let product = {
            productName: "",
        }

        async function reqRegister(data) {
            const response = await fetch("http://192.168.2.7:8080/api/test", {
                body: JSON.stringify(data),
                headers: {
                    "Content-Type": "application/json"
                },
                method: "POST",
            });

            const responseBody = await response.json();
            console.log(responseBody);
        }

        function handleOnChange(e) {
            const name = e.target.name;
            const value = e.target.value;

            product = {
                ...product,
                [name]: value,
            }
        }

        function handleOnSubmit(e) {
            e.preventDefault();
            reqRegister(product);
        }

    </script>
</body>
</html>
