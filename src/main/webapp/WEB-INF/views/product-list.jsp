<%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 27.
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            width: 200px;
            /*height: 40px;*/
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>상품명</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>

</table>

<script>

    async function getProductList() {
        const response = await fetch("http://localhost:8080/api/products", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        });
        // const repsonseText = await response.text(); //json 문자열로 반환
        const responseJson = await response.json(); // json을 object로 변환해서 반환
        console.log(response);
        // console.log(repsonseText);
        console.log(responseJson);
        const tbody = document.querySelector("tbody");
        tbody.innerHTML = responseJson.map((product, index) => (
            `
                <tr>
                   <td>\${index + 1}</td>
                   <td>\${product.productName}</td>
                   <td>\${product.price}</td>
                </tr>
            `
        )).join("");
    }

    getProductList();

</script>
</body>
</html>
