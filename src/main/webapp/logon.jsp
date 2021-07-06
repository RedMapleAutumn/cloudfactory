<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/28
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#agency").click(function (){
                $("#fname").attr("disabled",true);//文本框设置为不可编辑
                $("input[name=factoryname]").val("")//将输入框置空
                $("#fintro").attr("disabled",true);
                $("input[name=factoryintro]").val("")
            })
            $("#factory").click(function (){
                $("#fname").attr("disabled",false);//文本框设置为可编辑
             //   $("input[name=factoryname]").val("")//将输入框置空
                $("#fintro").attr("disabled",false);
            //    $("input[name=factoryintro]").val("")
            });
        })

        // $(document).ready(function (){
        //     $("input:radio[name='type']").click(function (){
        //         var type = $('input[name="type"]:checked').val();
        //         document.getElementById("value").innerHTML = "123";
        //         if(type==='cloudfactory'){
        //             document.getElementById("value").innerHTML = type;
        //            // alert("选择云工厂")
        //         }else {
        //             document.getElementById("value").innerHTML = type;
        //             //alert("选择经销商")
        //         }
        //     })
        // })


    </script>
</head>
<body>
<h3>注册账号</h3>
<div id="logon">
    <%
        String method = request.getParameter("method");
        if(method.equals("add")){
    %>
        <form action="/logon/add" method="post">
    <%
        }else{
    %>
        <form action="/logon/new" method="post">
    <%
        }
    %>
<%--    <form action="/logon" method="post">--%>
        <table>
            <tr>
                <td>账号:</td>
                <td>
                    <label>
                        <input type="text" name="account" required="required">
                    </label>
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                    <label>
                        <input type="password" name="password" required="required">
                    </label>
                </td>
            </tr>
            <tr>
                <td>真实姓名:</td>
                <td>
                    <label>
                        <input type="text" name="name" required="required">
                    </label>
                </td>
            </tr>
            <tr>
                <td>联系方式:</td>
                <td>
                    <label>
                        <input type="text" name="contact" required="required">
                    </label>
                </td>
            </tr>
            <tr>
                <td>注册类型:</td>
                <td>
                    <label><input type="radio" value="云工厂管理员" id="factory" name="role" checked="checked">云工厂</label>
                    <label><input type="radio" value="经销商" id="agency" name="role" >经销商</label>
                </td>
            </tr>
            <tr>
                <td>工厂名称:</td>
                <td>
                    <label for="fname"></label><input type="text" id="fname" name="factoryName">
                </td>
            </tr>
            <tr>
                <td>工厂简介:</td>
                <td>
                    <label for="fintro"></label><input type="text" id="fintro" name="factoryIntro">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
