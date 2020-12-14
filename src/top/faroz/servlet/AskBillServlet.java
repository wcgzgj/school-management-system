package top.faroz.servlet;

import top.faroz.bean.Bill;
import top.faroz.bean.Stu;
import top.faroz.bean.StuStaBill;
import top.faroz.dao.BillDAO;
import top.faroz.dao.StuStaBillDAO;
import top.faroz.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AskBillServlet")
public class AskBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        //这里不但要插入bill表，还要将数据插入 stu_sta_bill表
        Stu stu = (Stu) request.getSession().getAttribute("user");
        String reason = request.getParameter("reason");
        String money = request.getParameter("money");
        String sta_id = request.getParameter("sta_id");

        if (StringUtil.hasEmpty(reason,money,sta_id)) {
            writer.print(-1); //-1 请输入完整信息
            return;
        }
        if (!StringUtil.isFloat(money)) {
            writer.print(-2);//-2 输入的钱数错误
            return;
        }

        BillDAO billDAO = new BillDAO();
        StuStaBillDAO stuStaBillDAO = new StuStaBillDAO();
        //新建bill对象
        Bill bill = new Bill();
        bill.setReason(reason);
        bill.setMoney(Float.parseFloat(money));
        bill.setStatus("underreview");
        bill.setStu_id(stu.getId());

        //新建StuStaBill对象
        StuStaBill stuStaBill = new StuStaBill();
        stuStaBill.setStu_id(stu.getId());
        stuStaBill.setSta_id(Integer.parseInt(sta_id));

        billDAO.add(bill);
        stuStaBillDAO.add(stuStaBill);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
