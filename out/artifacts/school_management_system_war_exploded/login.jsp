<%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/9
  Time: 上午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/taglib.jsp"%>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/login.js"></script>
    <style>
        html,body{
            background-image:url("./img/bkground.jpg");
            background-size: 100% 100%;
            height: 100%;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("#btn_login").click(function () {

                $.ajax({//ajax传输json数据
                    type:"post",//请求方式
                    url:"/login",//请求传输的位置
                    data:{"userid":$("#userid").val(),
                        "password":$("#password").val(),
                        "identity":$("input[name=identity]:checked").val()},
                    error:function () {
                        alert("登录错误");
                    },
                    success:function (data) {

                    }
                });
            });
            // 点击注册按钮
            $("#btn_register").click(function () {
               window.location.href="./register.jsp"
            });
        });

    </script>
</head>

<body>
<%--<%@include file="include/header.jsp"%>--%>

<body>
<div id="login_frame">

<%--    <p id="image_logo"><img src="./img/logo.jpg"></p>--%>
    <p><label class="label_input">账号</label><input type="text" id="userid" class="text_field" placeholder="请输入账号"/></p>
    <p><label class="label_input">密码</label><input type="text" id="password" class="text_field" placeholder="请输入密码"/></p>
    <div>
        <input type="radio" name="identity" value="student" style="margin-left: 2px" checked="true">学生
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="identity" value="teacher" style="margin-right: 2px">老师
    </div>
    <br/>
    <br/>
    <br/>
    <div id="login_control">
        <input type="button" id="btn_login" value="登录"/>
        <input type="button" id="btn_register"  value="注册"/>
    </div>
</div>


</body>
</html>
