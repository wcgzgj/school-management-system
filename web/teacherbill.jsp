<%@ page import="top.faroz.service.TeacherBillService" %>
<%@ page import="top.faroz.bean.Sta" %>
<%@ page import="top.faroz.bean.Bill" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/14
  Time: 下午6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理报销</title>
    <%@include file="include/taglib.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<%@include file="include/teacherheader.jsp"%>

<%
    Sta sta = (Sta) request.getSession().getAttribute("user");
    TeacherBillService teacherBillService = new TeacherBillService();
    List<Bill> stuBill = teacherBillService.getStuBill(sta.getId());
    Map<Integer, String> stuNameMap = teacherBillService.getStuNameMap();
    request.setAttribute("bills",stuBill);//待审核报销单
    request.setAttribute("nameMap",stuNameMap);//学生学号-姓名对照表
%>

<div style="margin: auto;text-align: center" >
    <table  class="table table-striped" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <td>序号</td>
            <td>报销钱数</td>
            <td>报销原因</td>
            <td>申请学生</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${bills}" var="bill" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td>${bill.money}</td>
                <td>${bill.reason}</td>
                <td>${nameMap.get(bill.stu_id)}</td>
                <td>
                    <button class="btn btn-success">
                        <a href="/teacherbill?stuID=${bill.stu_id}&staID=${sessionScope.user.id}&status=<%="agree"%>&billID=${bill.id}">同意</a>
                    </button>
                    <button class="btn btn-danger">
                        <a href="/teacherbill?stuID=${bill.stu_id}&staID=${sessionScope.user.id}&status=<%="reject"%>&billID=${bill.id}">拒绝</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="include/footer.jsp"%>
</body>
</html>
