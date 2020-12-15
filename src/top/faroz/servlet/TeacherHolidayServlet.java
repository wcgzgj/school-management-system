package top.faroz.servlet;

import top.faroz.service.TeacherHolidayService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TeacherHolidayServlet")
public class TeacherHolidayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String stuID = request.getParameter("stuID");
        String staID = request.getParameter("staID");
        TeacherHolidayService service = new TeacherHolidayService();
        //修改对应假期的状态
        service.changeHolidayStatus(Integer.parseInt(stuID),status);
        //删除stu_sta表中的对应数据
        service.deleteFromStuSta(Integer.parseInt(stuID),Integer.parseInt(staID));
        //使用定位，是因为还有session中的值要传递
        request.getRequestDispatcher("/teacherholiday.jsp").forward(request,response);
    }
}
