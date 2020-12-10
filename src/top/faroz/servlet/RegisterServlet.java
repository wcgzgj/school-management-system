package top.faroz.servlet;

import top.faroz.bean.Stu;
import top.faroz.dao.StuDAO;
import top.faroz.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过writer，输出不同的值，这就是ajax回调函数中data的值
        //通过这个值，ajax可以做出判断
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");//获得是学生还是老师在登录
        System.out.println(username+" "+userid+" "+password+" "+identity);

        //保证输入的信息完整
        //如果三个输入框，有一个没有输入，都会显示输入信息不完整
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(userid) ||StringUtil.isEmpty(password)) {
            writer.print(0);
            return;
        }
        if ("student".equals(identity)) {//如果是学生注册

            StuDAO stuDAO = new StuDAO();
            Stu stu=null;
            try {
                Integer.parseInt(userid);
            } catch (Exception e) {
                e.printStackTrace();
                writer.print(-1);//输入的账号不是纯数字
                return;
            }
            stu = stuDAO.get(Integer.parseInt(userid));

            if (!(stu==null)) {
                writer.print(-2);//学生存在
                return;
            }
            stu=new Stu();
            stu.setId(Integer.parseInt(userid));
            stu.setPassword(password);
            stu.setName(username);
            System.out.println(stu.toString());
            stuDAO.add(stu);
            writer.print(-3);//注册成功
            return;
        } else if ("teacher".equals(identity)) {//如果是老师注册

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
