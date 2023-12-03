package hero;

import java.sql.*;

public class JDBCUtility {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JDBCUtility() {
    }

    public static Connection GetConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/yinmu", "root", "123456");
    }

    public static void Close(Connection conn, Statement state, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (state != null) {
            try {
                state.close();
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