<%@ page import="java.util.List" %>
<%@ page import="utility.FormInformation" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF - 8">
    <title>DisplayPage</title>
    <script>
        <!--使用delete不允许-->
        function del(id) {
            window.location = "<%=request.getContextPath()%>/delete?id=" + id;
        }

        function modify(id, name, role) {
            window.location = "<%=request.getContextPath()%>/modify.jsp?id=" + id + "&name=" + name + "&role=" + role;
        }
    </script>
</head>
<body>
<center><h1>乱七八糟的表</h1></center>
<hr/>
<table align="center" border="1px">
    <tr>
        <th>ID</th>
        <th>角色</th>
        <th>动漫名</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}
            </td>
            <td>${item.role}
            </td>
            <td>${item.name}
            </td>
            <td><input type='button' value='修改' onclick="modify('${item.id}','${item.name}','${item.role}')"/><input
                    type='button' value='删除' onclick="del(${item.id})"/></td>
        </tr>
    </c:forEach>
</table>
<hr/>
<center>
    <input onclick='window.location="<%=request.getContextPath()%>/add.jsp"' type='button' value='添加数据'/>
    <a href="<%=request.getContextPath()%>/logout">[退出登录]</a>
</center>
</body>
</html>