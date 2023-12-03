package hero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作者：饮木
 */
@WebServlet(urlPatterns = "/checkInput")
public class CheckInput extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JDBCUtility.GetConnection();
            String account = request.getParameter("account");//获取前端数据
            String sql = "select * from t_user where account=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);//替换？的值
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
            request.setCharacterEncoding("UTF-8");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtility.Close(conn, ps, rs);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (flag) {
            //查询到数据
            out.print("<font color='red'>sorry this user is registered</font>");
        } else {
            out.print("<font color='green'>legal</font>");
        }
    }
}
