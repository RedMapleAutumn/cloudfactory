<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>用户管理</title>

  <link rel="stylesheet" href="../layui/css/layui.css" media="all">

  <!-- Custom fonts for this template-->
  <link href="../admin2/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../admin2/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar  侧边栏-->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
      </div>
      <div class="sidebar-brand-text mx-3">云制造平台</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
<%--    <li class="nav-item">--%>
<%--      <a class="nav-link" href="">--%>
<%--        <i class="fas fa-fw fa-tachometer-alt"></i>--%>
<%--        <span>Dashboard</span></a>--%>
<%--    </li>--%>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
<%--    <div class="sidebar-heading">--%>
<%--      Interface--%>
<%--    </div>--%>

    <!-- Nav Item - 系统设置 -->
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
         aria-expanded="true" aria-controls="collapseTwo">
        <i class="fas fa-fw fa-cog"></i>
        <span>系统设置</span>
      </a>
      <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Setting</h6>
          <a class="collapse-item" href="/admin/find">用户管理</a>
<%--          <a class="collapse-item" href="">Cards</a>--%>
        </div>
      </div>
    </li>

    <!-- Nav Item - 云工厂 -->
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
         aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fas fa-fw fa-wrench"></i>
        <span>云工厂</span>
      </a>
      <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
           data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Factory:</h6>
          <a class="collapse-item" href="/factory/find">工厂管理</a>
<%--          <a class="collapse-item" href="utilities-animation.html">Animations</a>--%>
<%--          <a class="collapse-item" href="utilities-other.html">Other</a>--%>
        </div>
      </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

<%--    <!-- Heading -->--%>
<%--    <div class="sidebar-heading">--%>
<%--      Addons--%>
<%--    </div>--%>

    <!-- Nav Item - Pages 产品管理 -->
    <li class="nav-item ">
      <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
         aria-controls="collapsePages">
        <i class="fas fa-fw fa-folder"></i>
        <span>产品管理</span>
      </a>
      <div id="collapsePages" class="collapse" aria-labelledby="headingPages"
           data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Managemnet:</h6>
          <a class="collapse-item" href="/pcate/find">产品类别管理</a>
          <a class="collapse-item" href="/product/find">产品信息管理</a>
        </div>
      </div>
    </li>

    <!-- Nav Item - Pages 产能中心 -->
    <li class="nav-item ">
      <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages2" aria-expanded="true"
         aria-controls="collapsePages2">
        <i class="fas fa-fw fa-chart-area"></i>
        <span>产能中心</span>
      </a>
      <div id="collapsePages2" class="collapse" aria-labelledby="headingPages"
           data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Managemnet:</h6>
          <a class="collapse-item" href="">设备类型管理</a>
          <a class="collapse-item" href="/superEquip/find">设备管理</a>
        </div>
      </div>
    </li>

    <!-- Nav Item - Pages 订单管理 -->
    <li class="nav-item">
      <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages3" aria-expanded="true"
         aria-controls="collapsePages3">
        <i class="fas fa-fw fa-table"></i>
        <span>订单管理</span>
      </a>
      <div id="collapsePages3" class="collapse" aria-labelledby="headingPages"
           data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Order:</h6>
          <a class="collapse-item" href="">订单基本信息</a>
        </div>
      </div>
    </li>


    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
          <div class="input-group">
            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                   aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
              <button class="btn btn-primary" type="button">
                <i class="fas fa-search fa-sm"></i>
              </button>
            </div>
          </div>
        </form>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">



          <div class="topbar-divider d-none d-sm-block"></div>

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">用户</span>
              <img class="img-profile rounded-circle"
                   src="../admin2/img/undraw_profile.svg">
            </a>
            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                 aria-labelledby="userDropdown">
              <a class="dropdown-item" href="#">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Profile
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                Settings
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                Activity Log
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="/relogin">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
              </a>
            </div>
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">


          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                action="/admin/search" method="post">
            <div class="input-group">
              <input type="text" name="search" class="form-control bg-light border-0 small" placeholder="Search for..."
                     aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <a href="/logon/re" class="layui-btn layui-btn-normal" >新建</a>
              </div>
            </div>
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
                  <a href="/admin/modify/${user.account}"><span style="color: green">修改</span></a>
                  <a href="/admin/delete/${user.account}"><span style="color: red">删除</span></a>
                </td>
              </tr>
              </tbody>
            </c:forEach>
          </table>
        </div>

      </div>
      <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Copyright &copy; Your Website 2020</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="login.html">Logout</a>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="../admin2/vendor/jquery/jquery.min.js"></script>
<script src="../admin2/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../admin2/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../admin2/js/sb-admin-2.min.js"></script>

</body>

</html>