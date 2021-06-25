<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="./layui/css/layui.css" media="all">
  <script src="./layui/layui.js"></script>
  <script src="js/jquery-3.3.1.min.js"></script>
    <style type="text/css">
      .div3{width:450px; height:300px}
    </style>
</head>
<body>
<%--<form class="layui-form" id="test" style="display:none">--%>
<form class="layui-form" id="test" style="display:none">>
  <div class="layui-form-item">
    <label class="layui-form-label">输入框</label>
    <div class="layui-input-block">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="on" class="layui-input" id="username" style="width:100px">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码框</label>
    <div class="layui-input-inline">
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="on" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">辅助文字</div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">选择框</label>
    <div class="layui-input-block">
      <select name="quiz" lay-search>
        <option value="">请选择</option>
        <optgroup label="城市记忆">
          <option value="你工作的第一个城市">你工作的第一个城市？</option>
        </optgroup>
        <optgroup label="学生时代">
          <option value="你的工号">你的工号？</option>
          <option value="你最喜欢的老师">你最喜欢的老师？</option>
        </optgroup>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">复选框</label>
    <div class="layui-input-block">
      <input type="checkbox" name="like[write]" title="写作" lay-skin="primary">
      <input type="checkbox" name="like[read]" title="阅读" checked lay-skin="primary">
      <input type="checkbox" name="like[dai]" title="发呆" lay-skin="primary">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">开关</label>
    <div class="layui-input-block">
      <input type="checkbox" name="switch" lay-skin="switch" lay-text="开启|关闭">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">单选框</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男">
      <input type="radio" name="sex" value="女" title="女" checked>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label" >文本域</label>
    <div class="layui-input-block">
      <textarea lay-verify="required" name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
</form>
<button id="div">提交1</button>
<div class="div3" id="div3">
  <form action="/productCategory" class="layui-form" id="book" method="post" lay-filter="example">
    <div class="layui-form-item">
      <label class="layui-form-label">输入框</label>
      <div class="layui-input-block">
        <input type="text" name="name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">密码框</label>
      <div class="layui-input-inline">
        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
      </div>
    </div>
  </form>
</div>

<script src="./layui/layui.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
  layui.use('form', function(){
    var form = layui.form;

    //监听提交
    form.on('submit(formDemo)', function(data){
      layer.msg(JSON.stringify(data.field));
      return false;
    });
  });

  $("#div").on("click",function (){
    layer.open({
      type:1,
      area:['500px','600px'],
      title: 'tianxie'
      ,content: $("#div3"),
      shade: 0,
      btn: ['提交', '重置']
      ,yes: function(index, layero){
        document.getElementById("book").submit()
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

</script>
</body>
</html>



