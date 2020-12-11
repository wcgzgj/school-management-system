package top.faroz.servlet;

import top.faroz.bean.Sta;
import top.faroz.bean.Stu;
import top.faroz.dao.StaDAO;
import top.faroz.dao.StuDAO;
import top.faroz.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");//获得是学生还是老师在登录
        PrintWriter writer = response.getWriter();//用来向ajax的回调函数返回数据
        if (StringUtil.isEmpty(userid) || StringUtil.isEmpty(password)) {//如果输入的信息为空
            writer.print(-1);//-1 信息为空
            return;
        }
        if (!StringUtil.isInteger(userid)) {
            writer.print(-2);//-2 输入的账号不是纯数字
            return;
        }

        if ("teacher".equals(identity)) {//教师登录
            StaDAO staDAO = new StaDAO();
            Sta sta=null;
            sta=staDAO.get(Integer.parseInt(userid));
            if (sta==null) {
                writer.print(-3);//-3 查无此人
                return;
            }
            if (!(sta.getPassword().equals(password))) {
                writer.print(-4);//-4 密码错误
                return;
            }
            //当一切判断正常，要在session中设置登录的相关信息
            request.getSession().setAttribute("user",sta);
            request.getSession().setAttribute("username",sta.getName());
        } else if ("student".equals(identity)) {
            StuDAO stuDAO = new StuDAO();
            Stu stu=null;
            stu=stuDAO.get(Integer.parseInt(userid));
            if (stu==null) {
                writer.print(-3);//-3 查无此人
                return;
            }
            if (!(stu.getPassword().equals(password))) {
                writer.print(-4);//-4 密码错误
                return;
            }
            //在session中设置用户的相关信息
            request.getSession().setAttribute("user",stu);
            request.getSession().setAttribute("username",stu.getName());
        }
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
