<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<%
    //取得cookie对象
    Cookie[] cookies = request.getCookies();
    //把cookies存储到域中
    request.setAttribute("cookies", cookies);
    //整个页面的基础路径
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    request.setAttribute("path", path);
%>
<%--
    如果之前浏览器本地存储有cookie就进行免登陆
--%>
<c:if test="${not empty cookies}">
    <%
        //取得cookie中存储的账号和密码
        String account = null;
        String password = null;
        for (Cookie item : cookies) {
            if (item.getName().equals("account")) {
                account = item.getValue();
            } else if (item.getName().equals("password")) {
                password = item.getValue();
            }
        }
        request.setAttribute("account", account);
        request.setAttribute("password", password);
    %>
    <%--在js代码中实现页面的跳转--%>
</c:if>
<script>
    window.onload = () => {
        if (${not empty account}) {
            window.location = "${path}/login?account=${account}&password=${password}";
        }
    }
</script>
<base href="${path}/">
<body>
<center>
    <h1>Welcome to use this simple system</h1>
    <hr/>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <input type="text" name="account" placeholder="用户名"/><br/><br/>
        <input type="text" name="password" placeholder="密码"/><br/><br/>
        <input type="checkbox" name="freeLogin" value="true"/>十分钟免登陆<br/><br/>
        <input type="submit">
    </form>
</center>
</body>
</html>