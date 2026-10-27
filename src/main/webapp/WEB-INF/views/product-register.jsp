<%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 27.
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" name="productName" placeholder="상품명" onkeyup="handleOnChange(event)"/>
<input type="number" name="price" placeholder="가격" min="0" onkeyup="handleOnChange(event)"/>
<button onclick="handleRegisterButtonOnClick(event)">등록</button>

<script>

    let product = {
        productName: "",
        price: 0,
    }

    function handleProductNameInputOnKeyUp(e) {
        console.log(e.target.value);
        product = {
            ...product,
            productName: e.target.value,
        }
    }

    function handlePriceInputOnKeyUp(e) {
        console.log(e.target.value);
        product = {
            ...product,
            price: e.target.value,
        }
    }

    function handleRegisterButtonOnClick(e) {
        console.log(JSON.stringify(product));

        // 요청 보내기
        fetch("http://localhost:8080/api/products",{
            method: "POST", // 어떤 타입으로 보낼건가
            body: JSON.stringify(product), // json타입으로 변환
            headers: {
                "Content-Type": "application/json",
            }
        });
    }

    function handleOnChange(e) {
        const name = e.target.name;
        const price = e.target.value;

        product = {
            ...product,
            [name]: price,
       }
    }

</script>
</body>
</html>
