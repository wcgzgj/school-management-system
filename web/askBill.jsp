<%@ page import="top.faroz.dao.StaDAO" %>
<%@ page import="top.faroz.bean.Sta" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/11
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报销单</title>
    <%@include file="include/taglib.jsp"%>
    <script>
        $(document).ready(function () {
            $("#btn_submit").click(function () {
                let reason = $("#reason").val(); //报销原因
                let money = $("#money").val(); //报销金额
                let sta_id = $("#sta_list").val(); //报告教师的id
                // alert(type+" "+sta);
                $.ajax({
                    type:"post",//请求方式
                    url:"/askbill",//请求传输的位置
                    data:{"reason":reason,
                        "money":money,
                        "sta_id":sta_id,
                    },
                    error:function () {
                        alert("提交错误");
                    },
                    success:function (data) {
                        if (data==-1) {
                            alert("请输入完整信息！")
                        } else if (data==-2) {
                            alert("输入的钱数有误！");
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
            <td><label class="label label-info">请输入申报原因：</label></td>
            <td>
                <input type="text" id="reason" placeholder="请输入原因">
            </td>
        </tr>
        <tr>
            <td><label class="label label-info">请输入申报钱数：</label></td>
            <td><input type="text" id="money" placeholder="请输入钱数"></td>
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
            <td colspan="2"><button class="btn btn-primary" id="btn_submit">提交报销单</button></td>
        </tr>
    </table>
</div>

<%@include file="./include/footer.jsp"%>
</body>
</html>
