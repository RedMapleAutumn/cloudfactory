<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/29
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<form action="/admin/modified" method="post" >
    <table>
        <tr>
            <td>账号:</td>
            <td><input value="${user.account}" name="account" readonly></td>
        </tr>
        <tr>
            <td>真实姓名:</td>
            <td><input value="${user.name}" name="name" ></td>
        </tr>
        <tr>
            <td>电话:</td>
            <td><input value="${user.contact}" name="contact"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

</body>
</html>
