<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/5/21
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text"/>
<button>submit by Ajax</button>
</body>
</html>
<script>
    let btn=document.querySelector("button");
    btn.onclick =function (){
        const xhr=new  XMLHttpRequest();
        xhr.open("POST","<%=request.getContextPath()%>/post",true);
        //设置响应请求头类型（这行代码非常重要，是模拟form表单提交的关键）
        // <form enctype="application/x-www-form-urlencoded"></form>
        //get请求的参数必须放在请求头中url后
        //post可以放在请求头或者请求体中
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        let input=document.querySelector("input");
        xhr.send("userInput="+input.value);

    }
</script>