<%@ page import="top.faroz.dao.HolidayDAO" %>
<%@ page import="top.faroz.bean.Holiday" %>
<%@ page import="java.util.List" %>
<%@ page import="top.faroz.utils.TranslateUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="top.faroz.bean.Stu" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/11
  Time: 下午5:23
  销假，将当前学生申请的假期展示出来，然后增加一个销假超链
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销假</title>
    <%@include file="include/taglib.jsp"%>
</head>
<body>
<%@include file="./include/header.jsp"%>
<%
    Stu user = (Stu) request.getSession().getAttribute("user");
    int stuID = user.getId();
    HolidayDAO holidayDAO = new HolidayDAO();
    List<Holiday> list = holidayDAO.list();
    // 如果依照我的设计，应该只会出现一个假期的信息
    // （因为在有一个假期的情况下，其他假期只要申请，就会显示有假期正在进行）
    //但这样写体现严谨性
    for (Holiday holiday : list) {
        holiday.setType(TranslateUtil.translateHolidayType(holiday.getType()));
        holiday.setStatus(TranslateUtil.translateStatus(holiday.getStatus()));
    }
    //要显示的，只是当先学生的，在审核中或者进行中的假期
    List<Holiday> holidays = new ArrayList<>();
    for (Holiday holiday : list) {
        if ( (holiday.getStatus().equals("审核中") || holiday.getStatus().equals("进行中")) &&
            holiday.getStu_id()==stuID) {
            holidays.add(holiday);
        }
    }
    request.setAttribute("holidays",holidays);
%>
<div style="margin: auto;text-align: center" >
    <table  class="table table-striped" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <td>序号</td>
            <td>请假类型</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td>请假状态</td>
            <td>销假</td>
        </tr>
       <c:forEach items="${holidays}" var="holiday" varStatus="st">
           <tr>
               <td>${st.count}</td>
               <td>${holiday.type}</td>
               <td>${holiday.start}</td>
               <td>${holiday.end}</td>
               <td>${holiday.status}</td>
               <td><a href="/cancelholiday?id=${holiday.id}" id="cancel_holiday"><span class=" 	glyphicon glyphicon-trash"></span></a></td>
           </tr>
       </c:forEach>
    </table>
</div>

<%@include file="./include/footer.jsp"%>
</body>

</html>
