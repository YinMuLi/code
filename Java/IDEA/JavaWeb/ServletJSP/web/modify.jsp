<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/5/4
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModifyPage</title>
</head>
<body>
<center>
    <h1>修改数据</h1>
</center>
<hr/>
<center>
    <form action="${pageContext.request.contextPath}/modify" method="post">
        <table>
            <tr>
                <td><input type="text" name="id" value="${param.id}" readonly/></td>
            </tr>
            <tr>
                <td><input type="text" name="role" value="${param.role}"/></td>
            </tr>
            <tr>
                <td><input type="text" name="name" value="${param.name}"/></td>
            </tr>
            <tr>
                <td align="center"><input type="submit"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
