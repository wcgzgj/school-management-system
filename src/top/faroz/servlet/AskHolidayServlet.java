package top.faroz.servlet;

import top.faroz.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AskHolidayServlet")
public class AskHolidayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        PrintWriter writer = response.getWriter();

        //字符串格式的日期转换为Date类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate=null;
        Date endDate=null;
        try {
             startDate= sdf.parse(start);
             endDate=sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (StringUtil.isEmpty(type) || StringUtil.isEmpty(start)|| StringUtil.isEmpty(end)) {
            writer.print(-1);//-1 请输入完整的信息
        }
        if (startDate.getTime()<=endDate.getTime()) {
            writer.print(-2);// -2 日期选择错误，起始日期应该小于终止日期
            return;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
