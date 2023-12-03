package utility;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 作者：饮木
 */
public class JDBCUtility {
    private JDBCUtility() {
    }

    private static String user;
    private static String driver;
    private static String password;
    private static String url;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
        user = bundle.getString("user");
        driver = bundle.getString("driver");
        password = bundle.getString("password");
        url = bundle.getString("url");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection conn, ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
