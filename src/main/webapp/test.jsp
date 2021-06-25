<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/30
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <div class="site-text" style="margin: 5%; display: none" id="window"  target="test123">
    <form class="layui-form" id="book" method="post" lay-filter="example">
      <div class="layui-form-item">
        <label class="layui-form-label">书本编号</label>
        <div class="layui-input-block">
          <input type="text" id="bid" name="bid" lay-verify="title" autocomplete="off" placeholder="请输入编号" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">书本名称</label>
        <div class="layui-input-block">
          <input type="text" id="bname" name="bname" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">书本价格</label>
        <div class="layui-input-block">
          <input type="text" id="price" name="price" lay-verify="title" autocomplete="off" placeholder="请输入价格" class="layui-input">
        </div>
      </div>


      <!--  <div class="layui-form-item">
         <div class="layui-input-block">
           <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
         </div>
       </div> -->
    </form>
  </div>
</head>
<body>
<button id="add">提交</button>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="./layui/layui.js"></script>
<script>
  $("#add").on("click",function (){
    layer.open({
      type: 1,
      area:['500px','600px'],
      title:"新增",
      btn: ['确定', '取消'],
      content: $("#window"),
      yes:function(index,layero){

      }
    });

  })

</script>
</body>
</html>
