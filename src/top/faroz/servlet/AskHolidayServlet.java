package top.faroz.servlet;

import top.faroz.bean.Holiday;
import top.faroz.bean.Stu;
import top.faroz.bean.StuSta;
import top.faroz.dao.HolidayDAO;
import top.faroz.dao.StuStaDAO;
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
import java.util.List;

/**
 *
 * @Description:
 * 学生申请请假
 *
 * @auther: FARO_Z
 * @date: 下午1:18 2020/12/13
 */
@WebServlet(name = "AskHolidayServlet")
public class AskHolidayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String sta = request.getParameter("sta");//教师id
        Stu stu = (Stu) request.getSession().getAttribute("user");//登录的学生信息
        PrintWriter writer = response.getWriter();

        if (StringUtil.isEmpty(type) || StringUtil.isEmpty(start)||
                StringUtil.isEmpty(end) || StringUtil.isEmpty(sta)) {
            writer.print(-1);//-1 请输入完整的信息
            return;
        }

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
        if (startDate.getTime()>=endDate.getTime()) {
            writer.print(-2);// -2 日期选择错误，起始日期应该小于终止日期
            return;
        }
        //如果一切判断无误，实例化DAO层,准备使用
        HolidayDAO holidayDAO = new HolidayDAO();
        StuStaDAO stuStaDAO = new StuStaDAO();


        // //判断学生id是否出现在stu_sta表中，如果出现的话，说明当前学生有休假正在进行
        // StuSta tmpStu = stuStaDAO.getByStu(stu.getId());
        // if (tmpStu!=null) {
        //     System.out.println(tmpStu);
        //     writer.print(-3); //-3 当前学生有休假正在进行
        //     return;
        // }

        //判断是否有假期正在进行中，改成从holiday表中寻找
        List<Holiday> holidays = holidayDAO.list();
        for (Holiday holiday : holidays) {
            /**
             * 如果请假单中，
             * 有假期的申请id和登录账号相等
             * 且假期的状态，是审核中或者进行中
             * 那么，就判定该学生有假期正在进行
             */
            if (holiday.getStu_id()==stu.getId() &&
                    (holiday.getStatus().equals("underreview") || holiday.getStatus().equals("undergoing"))) {
                writer.print(-3);
                return;
            }
        }


        Holiday holiday = new Holiday();
        holiday.setType(type);
        holiday.setStart(startDate);
        holiday.setEnd(endDate);
        //刚申请的假期，处于审核中的状态
        //当教师同意假期后，会显示为 进行中
        holiday.setStatus("underreview");
        holiday.setStu_id(stu.getId());
        //将请假单信息加入数据库中
        holidayDAO.add(holiday);

        StuSta stuSta = new StuSta();
        stuSta.setStu_id(stu.getId());
        stuSta.setSta_id(Integer.parseInt(sta));
        //只有在学生还没有绑定老师的情况下，才可以插入信息
        if (stuStaDAO.getByStu(stu.getId())!=null) {
            stuStaDAO.add(stuSta);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
