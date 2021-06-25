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
    <title>产品管理</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="./layui/layui.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <style type="text/css">
        .div3{width:450px; height:600px}
    </style>
    <style>
        .layui-form-selectup dl {
            top: 42px;
            bottom: unset;
        }
    </style>
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
                        <dd><a href="/superAdmin"><font color="#1E9FFF">用户管理</font></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">云工厂</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<c:url value="/cloudFactory"/>"><font color="#1E9FFF">云工厂信息</font></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">产品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/productCategory"><font color="#1E9FFF">产品类别管理</font></a></dd>
                        <dd><a href="/product"><font color="#1E9FFF">产品信息管理</font></a></dd>
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
            <button id="add" class="layui-btn layui-btn-normal" >新建</button>
            <form action="/superAdmin?method=search" method="post">
<%--                <a href="/product?method=add" class="layui-btn layui-btn-normal" >新建</a>--%>
                <input type="text" name="search" size="15" style="width:100px;height:36px;">
            </form>

            <table class="layui-table" border="3" lay-filter="demo" cellpadding="100" width="1000" >
                <thead>
                <tr>
                    <td>序号</td>
                    <td>产品编号</td>
                    <td>产品名称</td>
                    <td>产品类别</td>
                    <td>产品规格</td>
                    <td>产品描述</td>
                    <td>操作</td>
                </tr>
                </thead>
                <c:forEach items="${list}" var="product">
                    <tbody>
                    <tr>
                        <td>${num = num+1}</td>
                        <td id="valuePNO">${product.PNO}</td>
                        <td id="valuename">${product.name}</td>
                        <td id="valuecategory">${product.category}</td>
                        <td id="valuesize">${product.size}</td>
                        <td id="valuedes">${product.description}</td>
                        <td>
<%--                            <button id="modify"  style="color: #00FF00">修改</button>--%>
                            <a><span style="color: green" onclick="modify('${product.PNO}','${product.name}','${product.size}','${product.description}','${product.category}')">修改</span></a>
                            <a href="/superAdmin?method=delete&account=${product.PNO}"><span style="color: red">删除</span></a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <div class="div3" id="div3" style="display: none" >
                <form action="/product" class="layui-form" id="addProduct" method="post" lay-filter="example">
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品名称:</label>
                        <div class="layui-input-block">
                            <input type="text" name="name" required  lay-verify="required" placeholder="请输入产品名称" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品类别:</label>
                        <div class="layui-input-block">
                            <select name="category" lay-verify="required">
                                <option value=""></option>
                                <c:forEach items="${categorylist}" var="category">
                                    <option value="${category.PCNO}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品规格:</label>
                        <div class="layui-input-block">
                            <input type="text" name="size" required  lay-verify="required" placeholder="请输入产品规格" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品描述:</label>
                        <div class="layui-input-block">
                            <input type="text" name="description" required  lay-verify="required" placeholder="请输入产品描述" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </form>
            </div>

            <div class="div3" id="div4" style="display: none" >
                <form action="/product?method=modify" class="layui-form" id="addProduct2" method="post" lay-filter="example">
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品名称:</label>
                        <div class="layui-input-block">
                            <input type="text" id="pname" name="name" required  lay-verify="required" placeholder="请输入产品名称" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品类别:</label>
                        <div class="layui-input-block">
                            <select id="pcategory" name="category" lay-verify="required">
                                <option value=""></option>
                                <c:forEach items="${categorylist}" var="category">
                                    <option value="${category.name}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品规格:</label>
                        <div class="layui-input-block">
                            <input id="psize" type="text" name="size" required  lay-verify="required" placeholder="请输入产品规格" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">产品描述:</label>
                        <div class="layui-input-block">
                            <input id="pdes" type="text" name="description" required  lay-verify="required" placeholder="请输入产品描述" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div style="display: none">
                        <input type="text" id="selectPNO" name="selectPNO">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<script src="./layui/layui.js"></script>
<script>

    //JS
    layui.use(['element', 'layer', 'util','form'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,form = layui.form
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

    $("#add").on("click",function (){
        layer.open({
            type:1,
            area:['500px','600px'],
            title: 'tianxie'
            ,content: $("#div3"),
            shade: 0,
            offset: '100px',
            move:false,
            btn: ['提交', '重置']
            ,yes: function(index, layero){
                document.getElementById("addProduct").submit()
            },
            btn2: function(index, layero){
                alert("2222");
                return false;
            },
            cancel: function(layero,index){
                layer.closeAll();
            }

        });
    })

<%--    &lt;%&ndash;$(function (){&ndash;%&gt;--%>
<%--        $("#modify").click(function (){--%>
<%--        })--%>
<%--    &lt;%&ndash;})&ndash;%&gt;--%>

    function modify(pno,name,size,des,pcno){
        // var PNO = $("#valuePNO").html();
        // var name = $("#valuename").html();
        // var size = $("#valuesize").html();
        // var des = $("#valuedes").html();
        $("#selectPNO").val(pno)
        $("#pname").val(name)
        $("#psize").val(size)
        $("#pdes").val(des)
        // $("#pcategory").val(pcno)

        var all_options = document.getElementById("pcategory").options;
        for (var i = 0; i < all_options.length; i++){
            if (all_options[i].value == pcno){
                all_options[i].selected = true;
                break;
            }
        }

        layer.open({
            type:1,
            area:['500px','600px'],
            title: '修改'
            ,content: $("#div4"),
            shade: 0,
            offset: '100px',
            move:false,
            btn: ['提交', '重置']
            ,yes: function(index, layero){
                document.getElementById("addProduct2").submit()
            },
            btn2: function(index, layero){
                alert("2222");
                return false;
            },
            cancel: function(layero,index){
                layer.closeAll();
            }

        });
    }

</script>

</body>
</html>