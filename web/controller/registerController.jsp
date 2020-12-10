<%@ page import="top.faroz.dao.StuDAO" %>
<%@ page import="top.faroz.bean.Stu" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/10
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册控制</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String userid = request.getParameter("userid");
    String password = request.getParameter("password");
    String identity = request.getParameter("identity");
    // System.out.println("注册"+username+"  "+password+"  "+identity);
    // if ("student".equals(identity)) {//如果是学生注册
    //     StuDAO stuDAO = new StuDAO();
    //     Stu stu = stuDAO.get(Integer.parseInt(userid));
    //     if (stu==null) out.print();
    // } else {
    //
    // }
%>
</body>
</html>
