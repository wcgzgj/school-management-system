<%@ page import="top.faroz.dao.StuStaDAO" %>
<%@ page import="top.faroz.service.TeacherHolidayService" %>
<%@ page import="top.faroz.bean.Sta" %>
<%@ page import="top.faroz.bean.Holiday" %>
<%@ page import="java.util.List" %>
<%@ page import="top.faroz.domain.HolidayWithStuName" %>
<%@ page import="top.faroz.utils.TranslateUtil" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/14
  Time: 下午6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理请假</title>
    <%@include file="include/taglib.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

    <script>
        // $(document).ready(function () {
        //     $("#agree").click(function () {
        //         $.ajax({
        //             type:"post",//请求方式
        //             url:"/teacherholiday",//请求传输的位置
        //             data:{"stuID":  ,
        //                 "staID":  ,
        //             error:function () {
        //                 alert("操作错误");
        //             },
        //             success:function (data) {
        //                 if (data==-1) {
        //                     alert("请输入完整的信息");
        //                 } else if (data==-2) {
        //                     alert("账号必须是数字");
        //                 } else if (data==-3) {
        //                     alert("查无此人！");
        //                 } else if(data==-4) {
        //                     alert("密码输入错误！");
        //                 } else {
        //                     window.location.href="teacherholiday.jsp";
        //                 }
        //             }
        //         });
        //     });
        //     $("#reject").click(function () {
        //
        //     });
        // });
    </script>
</head>
<body>
<%@include file="include/teacherheader.jsp"%>

<%
    Sta sta = (Sta) request.getSession().getAttribute("user");
    TeacherHolidayService teacherHolidayService = new TeacherHolidayService();
    String str = teacherHolidayService.getStudentHoliday(sta.getId()).toString();
    // System.out.println(str);
    //获取的，该教师管辖的，待审核的，假期信息
    List<HolidayWithStuName> holidayWithStuName = teacherHolidayService.getHolidayWithStuName(sta.getId());

    for (HolidayWithStuName holiday : holidayWithStuName) {
        //翻译请假状态和请假类型
        holiday.getHoliday().setType(TranslateUtil.translateHolidayType(holiday.getHoliday().getType()));
    }
    request.setAttribute("holidayWithStuNames",holidayWithStuName);
%>

<div style="margin: auto;text-align: center" >
    <table  class="table table-striped" style="text-align: center;margin: auto;width: 80%">
        <tr>
            <td>序号</td>
            <td>请假类型</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td>请假学生</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${holidayWithStuNames}" var="holidayWithStuName" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td>${holidayWithStuName.holiday.type}</td>
                <td>${holidayWithStuName.holiday.start}</td>
                <td>${holidayWithStuName.holiday.end}</td>
                <td>${holidayWithStuName.stuName}</td>
                <td>
                    <button class="btn btn-success">
                        <a href="/teacherholiday?stuID=${holidayWithStuName.holiday.stu_id}&staID=${sessionScope.user.id}&status=<%="agree"%> ">同意</a>
                    </button>
                    <button class="btn btn-danger">
                        <a href="/teacherholiday?stuID=${holidayWithStuName.holiday.stu_id}&staID=${sessionScope.user.id}&status=<%="reject"%> ">拒绝</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>



<%@include file="include/footer.jsp"%>
</body>
</html>
