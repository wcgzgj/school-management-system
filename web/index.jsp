<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: faro_z
  Date: 2020/11/13
  Time: 3:32 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="include/taglib.jsp"%>--%>
<html>
  <head>
    <title>欢迎使用校园博客系统</title>
  </head>
  <body>
  <%@include file="include/header.jsp"%>

  <%
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      list.add(new Random().nextInt(100));
    }
    // 一定要setAttribute,不然java代码中的数据，无法与jsp交互
    request.setAttribute("list", list);

  %>
<%--  测试jstl标签库--%>
  <div style="text-align: center;width: 200px">
<%--    这里的表格不知道怎么居中，等到时候再说吧--%>
    <table class="table table-striped" style="text-align: center" align="center">
      <tr>
        <td>序号</td>
        <td>随机数</td>
      </tr>
      <c:forEach items="${list}" var="elem" varStatus="st">
        <tr>
          <td>${st.count}</td>
          <td>${elem}</td>
        </tr>
      </c:forEach>
    </table>
  </div>


  <%@include file="include/footer.jsp"%>
  </body>
</html>
