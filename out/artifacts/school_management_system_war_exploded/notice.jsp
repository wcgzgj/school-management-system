<%@ page import="top.faroz.dao.HolidayDAO" %>
<%@ page import="top.faroz.bean.Holiday" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="top.faroz.bean.Stu" %>
<%@ page import="top.faroz.utils.TranslateUtil" %><%--
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
</head>
<body>
<%@include file="include/header.jsp"%>

<%
    Stu stu = (Stu) request.getSession().getAttribute("user");
    HolidayDAO holidayDAO = new HolidayDAO();
    List<Holiday> list = holidayDAO.list();
    List<Holiday> holidays = new ArrayList<>();
    for (Holiday holiday : list) {
        if (holiday.getStu_id()==stu.getId()) {
            holidays.add(holiday);
        }
    }
    for (Holiday holiday : holidays) {
        holiday.setType(TranslateUtil.translateHolidayType(holiday.getType()));
        holiday.setStatus(TranslateUtil.translateHolidayStatus(holiday.getStatus()));
    }
    request.setAttribute("holidays",holidays);
%>



<%--显示请假情况--%>
<div style="margin: auto;text-align: center" >
    <table  class="table table-striped" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <td style="collapse: 5">请假状况</td>
        </tr>
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


<%@include file="include/footer.jsp"%>
</body>
</html>
