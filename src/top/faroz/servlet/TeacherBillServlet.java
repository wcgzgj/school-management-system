package top.faroz.servlet;

import top.faroz.bean.Bill;
import top.faroz.service.TeacherBillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherBillServlet")
public class TeacherBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuID = request.getParameter("stuID");
        String staID = request.getParameter("staID");
        String billID = request.getParameter("billID");//要修改的报销单ID
        String status = request.getParameter("status");
        TeacherBillService teacherBillService = new TeacherBillService();

        //修改状态
        teacherBillService.changeBillStatus(Integer.parseInt(billID),status);
        //删除stu_sta_bill中对应表()
        /**
         * 注意：！！！
         * 因为可能有多条数据相等，所以，一次只能删除一条数据！！！！！！
         */
        teacherBillService.deleteFromStuSta(Integer.parseInt(stuID),Integer.parseInt(staID));
        request.getRequestDispatcher("/teacherbill.jsp").forward(request,response);
    }
}
