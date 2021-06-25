<%--
  Created by IntelliJ IDEA.
  Date: 2019/7/15
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>超级管理员主页</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<%--<script type="text/javascript" src="js/jquery/jquery-1.11.1.min.js"></script>--%>
<%--<script src="js/jquery-3.3.1.min.js"></script>--%>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">云制造平台</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    管理员
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">Your Profile</a></dd>
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="">Sign out</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll ">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">系统设置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"><font color="#1E9FFF">用户管理</font></a></dd>
    <%--                    <dd><a href="javascript:;">menu 2</a></dd>--%>
    <%--                    <dd><a href="javascript:;">menu 3</a></dd>--%>
    <%--                    <dd><a href="">the links</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">云工厂</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"><font color="#1E9FFF">云工厂信息</font></a></dd>
    <%--                    <dd><a href="javascript:;">list 2</a></dd>--%>
    <%--                    <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">产品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"><font color="#1E9FFF">产品类别管理</font></a></dd>
                        <dd><a href="javascript:;"><font color="#1E9FFF">产品信息管理</font></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">产能中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"><font color="#1E9FFF">设备类型管理</font></a></dd>
                        <dd><a href="javascript:;"><font color="#1E9FFF">设备管理</font></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" >
                    <a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child" >
                        <dd ><a  href="javascript:;" ><font color="#1E9FFF">订单基本信息</font></a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form action="/superAdmin?method=search" method="post">
                <a href="logon.jsp?method=add" class="layui-btn layui-btn-normal" >新建</a>
                <input type="text" name="search" size="15" style="width:100px;height:36px;">
<%--                <a href="/superAdmin?method=search&name=${search}" class="layui-btn">搜索</a>--%>
                <input type="submit" value="搜索">
            </form>

<%--            <i class="layui-icon layui-icon-search"></i>--%>
            <table class="layui-table" border="3" lay-filter="demo" cellpadding="100" width="1000" >
                <thead>
                <tr>
                    <td>序号</td>
                    <td>账号</td>
                    <td>姓名</td>
                    <td>联系方式</td>
                    <td>角色名称</td>
                    <td>操作</td>
                </tr>
                </thead>
                <c:forEach items="${list}" var="user">
                    <tbody>
                    <tr>
                        <td>${num = num+1}</td>
                        <td>${user.account}</td>
                        <td>${user.name}</td>
                        <td>${user.contact}</td>
                        <td>${user.role}</td>
                        <td>
                            <a href="/superAdmin?method=modify&account=${user.account}">修改</a>
                            <a href="/superAdmin?method=delete&account=${user.account}">删除</a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="./layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>

</body>
</html>