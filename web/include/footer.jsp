<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/9
  Time: 上午8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<html>
<head>
    <title>尾栏</title>
    <script>
        $(document).ready(function () {
            $("#test").click(function () {
                alert("jquery导入成功")
            });
        });
    </script>
</head>
<body>
<%--btn-danger是使用了bootstrap库--%>
<button id="test" class="btn-danger">测试jquery</button>
</body>
</html>
