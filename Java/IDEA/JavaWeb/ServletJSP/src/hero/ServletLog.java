package hero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utility.JDBCUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作者：饮木
 */
@WebServlet(urlPatterns = {"/login", "/logout"})
public class ServletLog extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servicePath = request.getServletPath();
        if (servicePath.equals("/login")) {
            doLogin(request, response);
        } else if (servicePath.equals("/logout")) {
            doLogout(request, response);
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();//手动销毁会话
            //手动销毁cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie item : cookies) {
                    item.setMaxAge(0);
                    response.addCookie(item);//告诉服务器要删除此cookie
                }
            }
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }


    }

    //表单的提交是post的
    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //获得用户登录的账号和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String freeLogin = request.getParameter("freeLogin");
        //创建session对象
        HttpSession session = request.getSession();
        try {
            conn = JDBCUtility.getConnection();
            String sql = "select * from t_user where account=? and passwords=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            //获取cookie对象
            //是个数组的长度>=1
            //如果没有cookie对象则是null
            Cookie[] cookies = request.getCookies();
            //查询到了数据并且cookie为null表明用户是第一次登录
            if (rs.next()) {
                if (freeLogin != null && freeLogin.equals("true")) {
                    //用户勾选了十分钟免登录存储cookie
                    Cookie cookieAccount = new Cookie("account", account);
                    cookieAccount.setMaxAge(60 * 10);//cookie保存十分钟
                    Cookie cookiePassword = new Cookie("password", password);
                    cookiePassword.setMaxAge(60 * 10);
                    //设置cookie默认的路径是项目名
                    cookiePassword.setPath(request.getContextPath());
                    cookieAccount.setPath(request.getContextPath());
                    //将cookies响应给浏览器
                    response.addCookie(cookieAccount);
                    response.addCookie(cookiePassword);
                }
                session.setAttribute("account", account);//只存储用户名就可以了
                response.sendRedirect(request.getContextPath() + "/display");
            } else if (cookies != null) {
                //删除登录失败的cookie
                cookies[0].setMaxAge(0);
                cookies[1].setMaxAge(0);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtility.close(conn, rs, ps);
        }
    }
}
