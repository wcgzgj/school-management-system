<%@ page import="top.faroz.test.JSPUseFileTest" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/12/10
  Time: 上午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录控制</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String identity = request.getParameter("identity");
    // System.out.println("登录"+username+"  "+password+"  "+identity);
    // if ("student".equals(identity)) {//如果是学生注册
    //     StuDAO stuDAO = new StuDAO();
    //     Stu stu = stuDAO.get(Integer.parseInt(username));
    //     if (stu==null) out.print();
    // } else {
    //
    // }
%>
</body>
</html>
