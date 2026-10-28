<%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 28.
  Time: 오전 9:19
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
            height: 40px;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>차량번호</th>
                <th>입차시간</th>
            </tr>
        </thead>
        <tbody id="car">
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>

    <script>

        async function getCarList() {
            const response = await fetch("http://192.168.2.5:8080/api/cars");

            const responseJson = await response.json(); // json을 object로 변환
            console.log(responseJson);
            const tbody = document.querySelector('#car');
            tbody.innerHTML = responseJson.map((car, index) => (
                `
                <tr>
                    <td>\${index + 1}</td>
                    <td>\${car.carNumber}</td>
                    <td>\${car.time}</td>
                </tr>
                `
            )).join("");
        }

        getCarList();
    </script>

</body>
</html>
