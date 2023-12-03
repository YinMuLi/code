<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2022/5/4
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang='en'>
<head>
    <title>addPage</title>
</head>
<body>
<center>
    <h1>添加数据</h1>
    <hr/>
    <form action="<%=request.getContextPath()%>/add" method='post'>
        <table>
            <tr>
                <td><input placeholder='ID' type='text' name='id' /></td>
            </tr>
            <tr>
                <td><input placeholder='RoleName' name='role' type='text'/></td>
            </tr>
            <tr>
                <td><input placeholder='Anime name' type='text' name='name'/></td>
            </tr>
            <tr align='center'>
                <td><input type='submit' value='submit'/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>