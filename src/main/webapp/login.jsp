<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/28
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div id="login">
    <form action="/login" method="post">
        <table>
            <tr>
                <td>账号:</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="确认">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
