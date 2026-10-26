<%--
  Created by IntelliJ IDEA.
  User: JangSeoHyun
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form method="post" onsubmit="handleOnSubmit(event)">
        <div>
            <input type="text" name="username" placeholder="사용자이름" onkeyup="handleOnChange(event)">
        </div>
        <div>
            <input type="password" name="password" placeholder="비밀번호" onkeyup="handleOnChange(event)">
        </div>
        <div>
            <input type="text" name="name" placeholder="이름" onkeyup="handleOnChange(event)">
        </div>
        <button type="submit">등록하기</button> <%-- submit, Button의 기본형이다. --%>
    </form>

    <script>
        let user = {
            username: "",
            password: "",
            name: "",
        }

        function handleOnChange(event) {
            const name = event.target.name;
            const value = event.target.value;
            user = {
                ...user,
                [name]: value,
            }

            console.log(user);
        }

        async function registerApi(data) {
            const jsonData = JSON.stringify(data); // 데이터를 JSON 자료형으로 변환
            const response = await fetch("http://localhost:8080/api/users", {
                method: "post", // post는 create라는 뜻을 가지고 있다.
                headers: {
                    "Content-Type": "application/json",
                },
                body: jsonData,
            });

            console.log(response);
            const responseBody = await response.json();
            console.log(responseBody);

            alert(responseBody.message);

            if (response.status !== 200) {
                return;
            }

            location.replace("/user/list"); // 페이지 이동, history를 남기지 않는다.(뒤로가기 안됨) href는 남는다.

        }

        function handleOnSubmit(event) {
            event.preventDefault();
            registerApi(user);
        }
    </script>
</body>
</html>
