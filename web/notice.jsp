<%@ page import="top.faroz.dao.HolidayDAO" %>
<%@ page import="top.faroz.bean.Holiday" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="top.faroz.bean.Stu" %>
<%@ page import="top.faroz.utils.TranslateUtil" %>
<%@ page import="top.faroz.dao.BillDAO" %>
<%@ page import="top.faroz.bean.Bill" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/11
  Time: 下午5:44
  显示当前学生的请假状态和报销申请状态
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通知</title>
    <%@include file="include/taglib.jsp"%>
    <style>
        .notice_head {
            text-align: center;
            font-size: 20px;
            color: blue;
            font-family: "Academy Engraved LET";
        }
    </style>
</head>
<body>
<%@include file="include/header.jsp"%>

<%
    Stu stu = (Stu) request.getSession().getAttribute("user");

    HolidayDAO holidayDAO = new HolidayDAO();
    List<Holiday> holidayList = holidayDAO.list();
    List<Holiday> holidays = new ArrayList<>();
    for (Holiday holiday : holidayList) {
        if (holiday.getStu_id()==stu.getId()) {
            holidays.add(holiday);
        }
    }
    for (Holiday holiday : holidays) {
        holiday.setType(TranslateUtil.translateHolidayType(holiday.getType()));
        holiday.setStatus(TranslateUtil.translateStatus(holiday.getStatus()));
    }
    request.setAttribute("holidays",holidays);

    BillDAO billDAO = new BillDAO();
    List<Bill> billList = billDAO.list();
    List<Bill> bills = new ArrayList<>();
    for (Bill bill : billList) {
        if (bill.getStu_id()==stu.getId()) {
            bill.setStatus(TranslateUtil.translateStatus(bill.getStatus()));
            bills.add(bill);
        }
    }
    request.setAttribute("bills",bills);
%>



<%--显示请假情况--%>
<div style="    margin: auto;text-align: center" >
    <p class="notice_head">请假状况</p>
    <table  class="table table-striped" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <th>序号</th>
            <th>请假类型</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>请假状态</th>
        </tr>
        <c:forEach items="${holidays}" var="holiday" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td>${holiday.type}</td>
                <td>${holiday.start}</td>
                <td>${holiday.end}</td>
                <td>${holiday.status}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--显示报销情况--%>
<div style="margin: auto;text-align: center;margin-top: 40px" >
    <p class="notice_head">报销状况</p>
    <table  class="table table-striped" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <th>序号</th>
            <th>报销原因</th>
            <th>报销钱数</th>
            <th>报销状态</th>
        </tr>
        <c:forEach items="${bills}" var="bill" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td>${bill.reason}</td>
                <td>${bill.money}</td>
                <td>${bill.status}</td>
            </tr>
        </c:forEach>
    </table>
</div>


<%@include file="include/footer.jsp"%>
</body>
</html>
