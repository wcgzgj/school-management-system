<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/11/13
  Time: 3:32 下午
  欢迎页面，不管是学生，还是老师，一登录，默认跳转的都是这个页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--此页面只是用来测试各个前端的功能的--%>
<%--所以在其他功能完成后，welcomelist不会包含--%>

<html>
  <head>
    <title>欢迎使用校园博客系统</title>
    <%@include file="include/taglib.jsp"%>
    <style>
      * {
        box-sizing: border-box;
      }

      /* body 样式 */
      body {
        font-family: Arial;
        margin: 0;
      }

      /* 列容器 */
      .row {
        display: -ms-flexbox; /* IE10 */
        display: flex;
        -ms-flex-wrap: wrap; /* IE10 */
        flex-wrap: wrap;
      }

      /* 创建两个列 */
      /* 边栏 */
      .side {
        -ms-flex: 30%; /* IE10 */
        flex: 30%;
        background-color: #f1f1f1;
        padding: 20px;
      }

      /* 主要的内容区域 */
      .main {
        -ms-flex: 70%; /* IE10 */
        flex: 70%;
        background-color: white;
        padding: 20px;
      }

      /* 测试图片 */
      .text_area {
        background-color: #aaa;
        width: 100%;
        padding: 20px;
      }

      /* 响应式布局 - 在屏幕设备宽度尺寸小于 700px 时, 让两栏上下堆叠显示 */
      @media screen and (max-width: 700px) {
        .row {
          flex-direction: column;
        }
      }

      /* 响应式布局 - 在屏幕设备宽度尺寸小于 400px 时, 让导航栏目上下堆叠显示 */
      @media screen and (max-width: 400px) {
        .navbar a {
          float: none;
          width: 100%;
        }
      }

      .welcome_head {
        color: blue;
        font: 0.875em/1.5em"微软雅黑", "PTSans", "Arial", sans-serif;
        font-size: 30px;
        text-align: center;
        /*background-color: #aaaaaa;*/
        width: 100%;
      }

      #links a:hover {
        cursor: pointer;
        text-decoration: none;
        background-color: #3BD9FF;
        color: #f1f1f1;
        font: 20px/1 Tahoma,Helvetica,Arial,"\5b8b\4f53",sans-serif;
        line-height: 30px;
      }
    </style>
  </head>
  <body>
  <%@include file="include/header.jsp"%>

  <h1 class="welcome_head">欢迎使用校园管理系统</h1>
  <div class="row">
    <div class="side">
      <h3>更多内容</h3>
      <div id="links">
        <a target="_blank" href="https://github.com/wcgzgj/FAROInterpreter.git">MyLisp解释器</a>
        <br/>
        <a target="_blank" href="https://github.com/wcgzgj/gobang-ver4.0-JavaSwing.git">人工智能五子棋</a>
        <br/>
        <a target="_blank" href="https://github.com/wcgzgj/school-qq.git">校园qq</a>
        <br/>
        <a target="_blank" href="https://github.com/wcgzgj/java-net-shell.git">远程控制程序</a>
        <br/>
      </div>
    </div>
    <div class="main">
      <h2>项目介绍</h2>
      <h5>校园管理系统</h5>
      <div class="text_area" style="height:200px;">

      </div>
      <p>一些文本..</p>
      <p>菜鸟教程，学的不仅是技术，更是梦想！！！菜鸟教程，学的不仅是技术，更是梦想！！！菜鸟教程，学的不仅是技术，更是梦想！！！</p>
      <br>
      <h2>标题</h2>
      <h5>副标题</h5>
      <div class="text_area" style="height:200px;">图像</div>
      <p>一些文本..</p>
      <p>菜鸟教程，学的不仅是技术，更是梦想！！！菜鸟教程，学的不仅是技术，更是梦想！！！菜鸟教程，学的不仅是技术，更是梦想！！！</p>
    </div>
  </div>


  <%@include file="include/footer.jsp"%>
  </body>
</html>
