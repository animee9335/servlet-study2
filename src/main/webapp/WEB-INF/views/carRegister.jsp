<%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 28.
  Time: 오전 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="text" name="carNumber" placeholder="차량번호 입력"  onkeyup="handleOnChange(event)"/>
    <input type="text" name="time" placeholder="입차시간 입력" onkeyup="handleOnChange(event)"/>
    <button onclick="handleRegisterButtonOnClick(event)">등록</button>
</body>

    <script>
        let car = {
            carNumber: "",
            time: "",
        }

        function handleOnChange(e) {
            const name = e.target.name;
            const value = e.target.value;

            car = {
                ...car,
                [name]: value,
            }
        }

        async function handleRegisterButtonOnClick(e) {
            const response = await fetch("http://192.168.2.5:8080/api/cars", {
                method: "POST",
                body: JSON.stringify(car),
                headers: {
                    "Content-Type": "application/json",
                }
            });

            try {
                const responseBody = await response.json();
                console.log(responseBody);
            } catch (err) {
                console.log("실패", err);
            }
        }


    </script>

</html>
