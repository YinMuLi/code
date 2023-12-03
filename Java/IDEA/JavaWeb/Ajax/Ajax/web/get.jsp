<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/5/20
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<button class="btn">emit ajax</button>
</body>
</html>
<script>
    let button = document.querySelector(".btn");//获取按钮对象
    const xhr = new XMLHttpRequest();//创建Ajax核心对象XMLHttpRequest
    //注册回调函数
    button.onclick = function () {
        xhr.onreadystatechange = function () {
            // 0->1调用一次
            // 1->2调用一次
            // 2->3调用一次
            // 3->4调用一次
            //console.log(xhr.readyState);//输出XMLHttpRequest的状态
            // if (this.readyState == 4) {
            //     console.log("响应资源完毕");
            // }
            if (this.status==200&&this.readyState==4)
            {
                //200表示响应数据成功
                console.log(this.responseText);
            }
        }
        //开启通道（浏览器只是和服务器建立连接，连接打开，并不会发送请求）
        xhr.open("GET", "<%=request.getContextPath()%>/welcome", true);//true表示异步
        //发送请求
        xhr.send();
    }
</script>

