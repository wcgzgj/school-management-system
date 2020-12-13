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
<%--    header中已经应用了taglib，这里再次引用的话，会出现500的报错--%>
    <%@include file="include/taglib.jsp"%>
    <link rel="stylesheet" href="css/style.css">
    <script>
        $(document).ready(function () {
            $("#btn_submit").click(function () {
                // 请假类型
                let type = $("#cb_type").val();
                let start = $("#start_date").val();
                let end = $("#end_date").val();

                $.ajax({
                    type:"post",//请求方式
                    url:"/askholiday",//请求传输的位置
                    data:{"type":type,
                        "start":start,
                        "end":end},
                    error:function () {
                        alert("提交错误");
                    },
                    success:function (data) {

                    }
                });
            });
        });
    </script>
    <style>
        /*html,body {*/
        /*    background-color: cornsilk;*/
        /*}*/
        #center_div {
            position: absolute;
            margin-top: 50%;
        }
    </style>
</head>
<body>
<%@include file="./include/header.jsp"%>
<%--private int id; 请假单编号--%>
<%--private String type;  请假单类型--%>
<%--private Date start;  假期开始时间--%>
<%--private Date end; 假期结束时间--%>
<%--private String status; 状态 "审核中  假期中  已销假" 这一项应该在通知中显示--%>
<%--private int stu_id; 申请假期的学生的id  这一项自动填写--%>
<div style="margin: auto" >
    <table  class="table table-bordered" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <td><label class="label label-info">请选择请假类型：</label></td>
<%--            <td><input type="text" placeholder="应该是下拉框，只是我还不知道怎么做"></td>--%>
            <td>
                <select class="combobox" id="cb_type">
                    <option value="practice">实习</option>
                    <option value="family">探亲</option>
                    <option value="temp">临时</option>
                    <option value="holiday">假期</option>
                </select>
            </td>
        </tr>
<%--        type="date"只有chrome才支持调用日历，其他浏览器好像不支持...--%>
        <tr>
            <td><label class="label label-info">请选择开始时间：</label></td>
            <td><input type="date" id="start_date"></td>
        </tr>
        <tr>
            <td><label class="label label-info">请选择结束时间：</label></td>
            <td><input type="date" id="end_date"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="btn btn-primary" id="btn_submit">提交请假单</button></td>
        </tr>
    </table>
</div>

<%@include file="./include/footer.jsp"%>
</body>
</html>
