package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author 李昊辰
 * @Date 2023/9/12 13:52
 * @Description
 */
@WebServlet(value = "/test")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求ip:" + req.getServletPath());
        System.out.println("token:" + req.getHeader("token"));
        System.out.printf("请求体：name=%s age=%s", req.getParameter("name"), req.getParameter("age"));
        PrintWriter out = resp.getWriter();
        out.println("Hello everybody");
    }
}
