<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/5/21
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" class="account"/><span class="accountSpan"></span><br/>
</body>
</html>
<script>
    const accountInput=document.querySelector(".account");
    const xhr=new XMLHttpRequest();
    //注册失去焦点回调函数
    accountInput.onblur=function (){
        //模拟发送post请求
        xhr.open("POST","<%=request.getContextPath()%>/checkInput",true);//开启通道
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xhr.send("account="+this.value);//发送请求
    }
    //不在回调函数中注册可以
    xhr.onreadystatechange=function (){
        if (this.readyState===4)
        {
            if (this.status===200)
            {
                document.querySelector(".accountSpan").innerHTML=this.responseText;
            }
        }
    }
</script>