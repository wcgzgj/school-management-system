<%@ page import="top.faroz.dao.StaDAO" %>
<%@ page import="top.faroz.bean.Sta" %>
<%@ page import="java.util.List" %><%--
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
                var confirmDelete = confirm("确认要提交请假单");
                if(!confirmDelete) return;

                let type = $("#cb_type").val(); //请假类型
                let start = $("#start_date").val(); //开始日期
                let end = $("#end_date").val(); //结束日期
                let sta = $("#sta_list").val(); //教师id

                $.ajax({
                    type:"post",//请求方式
                    url:"/askholiday",//请求传输的位置
                    data:{"type":type,
                        "start":start,
                        "end":end,
                        "sta":sta},
                    error:function () {
                        alert("提交错误");
                    },
                    success:function (data) {
                        if (data==-1) {
                            alert("请输入完整信息！")
                        } else if (data==-2) {
                            alert("日期选择错误，起始日期应该小于终止日期!");
                        } else if (data==-3) {
                            alert("当前学生有休假正在进行!");
                        } else {
                            alert("提交成功！")
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<%@include file="./include/header.jsp"%>
<%--private int id; 请假单编号--%>
<%--private String type;  请假单类型--%>
<%--private Date start;  假期开始时间--%>
<%--private Date end; 假期结束时间--%>
<%--private String status; 状态 "审核中  假期中  已销假" 这一项应该在通知中显示--%>
<%--private int stu_id; 申请假期的学生的id  这一项自动填写--%>
<%
    // 这里调用StaDAO，获取所有老师的信息
    // 方便学生选择对应的要汇报的老师
    StaDAO staDAO = new StaDAO();
    List<Sta> list = staDAO.list();
    request.setAttribute("staList",list);
%>

<div style="margin: auto" >
    <table  class="table table-bordered" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <td><label class="label label-info">请选择请假类型：</label></td>
<%--            下面是下拉框--%>
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
<%--        所以演示的时候，务必使用chrome浏览器--%>
        <tr>
            <td><label class="label label-info">请选择开始时间：</label></td>
            <td><input type="date" id="start_date"></td>
        </tr>
        <tr>
            <td><label class="label label-info">请选择结束时间：</label></td>
            <td><input type="date" id="end_date"></td>
        </tr>
        <tr>
            <td><label class="label label-info">请选择汇报老师：</label></td>
            <td>
                <select class="combobox" id="sta_list">
                    <c:forEach items="${staList}" var="sta" varStatus="st">
                        <option value="${sta.id}">${sta.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><button class="btn btn-primary" id="btn_submit">提交请假单</button></td>
        </tr>
    </table>
</div>

<%@include file="./include/footer.jsp"%>
</body>
</html>
