<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<button id="btn">dopost</button>
</body>
</html>
<script>
    let btn = document.querySelector("#btn")
    btn.addEventListener("click", function () {
        axios({
            method: 'post',
            url: 'http://localhost:8080/demo/test',
            headers: {
                token: '123456'
            },
            params: {
                name: 'zhangsan',
                age: 18
            }
        })
    })
</script>