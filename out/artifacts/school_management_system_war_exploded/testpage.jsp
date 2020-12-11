<%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/11
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
<%--    <%@include file="include/taglib.jsp"%>--%>
<%--    <link rel="stylesheet" href="css/style.css" type="text/css">--%>
    <link >
</head>
<body>
<div style="text-align: center;width: 200px;text-align: center;margin: auto">
    <%--    这里的表格不知道怎么居中，等到时候再说吧--%>
    <%--  <table class="table table-striped" style="text-align: center">--%>
    <table border="1" cellpadding="3" cellspacing="0" style="width: 60%;margin:auto">
        <tr>
            <td>序号</td>
            <td>随机数</td>
        </tr>
        <c:forEach items="${list}" var="elem" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td>${elem}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
