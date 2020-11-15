package top.faroz.servlet;

import sun.jvm.hotspot.debugger.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BaseBackServlet")
public abstract class BaseBackServlet extends HttpServlet {
    /**
     * abstract Methods
     */
    public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page) ;
    public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page) ;
    public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page) ;
    public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page) ;
    public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page) ;

    /**
     * new DAO
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //
    // }
    //
    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //
    // }
}
