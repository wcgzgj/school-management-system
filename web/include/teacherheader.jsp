<%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/13
  Time: 下午3:41
  教师端的导航栏
  因为所要实现的功能和学生端不一样
  所以只能另外新写一个导航栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--这里不包含taglib，因为重复包含，会导致500的错误--%>
<html>
<head>
    <title>首栏</title>
    <script>
        $(document).ready(function () {
            $("#resign_link").click(function () {
                ${sessionScope.clear()}
                window.location.href="./login.jsp";
            });
        });
    </script>
    <style>
        #resign_link:hover {
            cursor: pointer;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">校园管理</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse header" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="./teacherindex.jsp">首页 <span class="sr-only">(current)</span></a></li>
                <li><a href="./teacherholiday.jsp">审批假条</a></li>
                <li><a href="./teacherbill.jsp">审批报销</a></li>
<%--                <li><a href="./teachernotice.jsp">通知</a></li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎 ${sessionScope.username}</a></li>
                <li><a id="resign_link">注销</a></li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>
