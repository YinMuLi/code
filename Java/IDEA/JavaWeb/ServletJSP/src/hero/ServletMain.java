package hero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：饮木
 */
@WebServlet(urlPatterns = {"/display", "/delete", "/add", "/modify"})
public class ServletMain extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servicePath = request.getServletPath();//获得请求路径
        switch (servicePath) {
            case "/display" -> doDisplay(request, response);
            case "/delete" -> doDelete(request, response);
            case "/add" -> doAdd(request, response);
            case "/modify" -> doModify(request, response);
        }
    }

    private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String id = request.getParameter("id");
        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtility.getConnection();
            //查询语句
            String sql = "update anime set name=?,role=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, role);
            ps.setString(3, id);
            ps.executeUpdate();
            //处理查询结果集
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtility.close(conn, null, ps);
        }
        response.sendRedirect(request.getContextPath() + "/display");
    }

    /**
     * 向数据库添加数据
     */
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String id = request.getParameter("id");
        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtility.getConnection();
            //查询语句
            String sql = "insert into anime (id,role,name) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, role);
            ps.setString(3, name);
            ps.executeUpdate();
            //处理查询结果集
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtility.close(conn, null, ps);
        }
        response.sendRedirect(request.getContextPath() + "/display");
    }

    private void doDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //存储查询出来的数据集合
        List<FormInformation> animeLists = new ArrayList<FormInformation>();
        try {
            conn = JDBCUtility.getConnection();
            //查询语句
            String sql = "select * from anime";
            ps = conn.prepareStatement(sql);
            //处理查询结果集
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                String id = rs.getString("id");
                FormInformation data = new FormInformation(name, role, id);
                //储存数据
                animeLists.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtility.close(conn, rs, ps);
        }
        //转发资源
        //这里用转发不用重定向，因为需要转发资源
        request.setAttribute("list", animeLists);
        request.getRequestDispatcher("/display.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        String id = request.getParameter("id");
        try {
            conn = JDBCUtility.getConnection();
            String sql = "delete from anime where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtility.close(conn, null, ps);
        }
        //重定向
        response.sendRedirect(request.getContextPath() + "/display");
    }
}
