<%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/11
  Time: 下午5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假</title>
    <%@include file="include/taglib.jsp"%>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="./include/header.jsp"%>
<%--private int id; 请假单编号--%>
<%--private String type;  请假单类型--%>
<%--private Date start;  假期开始时间--%>
<%--private Date end; 假期结束时间--%>
<%--private String status; 状态 "审核中  假期中  已销假" 这一项应该在通知中显示--%>
<%--private int stu_id; 申请假期的学生的id  这一项自动填写--%>
<div style="margin: auto">
    <table style="text-align: center;margin: auto">
        <tr>
            <td><label>请选择请假类型：</label></td>
            <td><input type="text" placeholder="应该是下拉框，只是我还不知道怎么做"></td>
        </tr>
        <tr>
            <td><label>请选择开始时间：</label></td>
            <td><input type="text" placeholder="应该是下拉框，只是我还不知道怎么做"></td>
        </tr>
        <tr>
            <td><label>请选择结束时间：</label></td>
            <td><input type="text" placeholder="应该是下拉框，只是我还不知道怎么做"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="success">提交请假单</button></td>
        </tr>
    </table>
</div>

<%@include file="./include/footer.jsp"%>
</body>
</html>
