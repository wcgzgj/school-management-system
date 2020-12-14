package top.faroz.servlet;

import top.faroz.dao.HolidayDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CancelHolidayServlet")
public class CancelHolidayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这里获取的id，是holiday表中自增的id
        int id = Integer.parseInt(request.getParameter("id"));
        // System.out.println(id);
        /**
         * 调用Dao层delete方法
         */
        HolidayDAO holidayDAO = new HolidayDAO();
        holidayDAO.delete(id);
        //这里必须要用转发，不能使用重定向
        //如果使用重定向，那么,session中存储的登录信息就没法使用了
        //就会爆出500的错误
        request.getRequestDispatcher("/cancelholiday.jsp").forward(request, response);
    }
}
