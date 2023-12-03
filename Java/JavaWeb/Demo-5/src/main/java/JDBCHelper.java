import java.sql.*;
import java.util.function.Function;

public class JDBCHelper {


    public void updateUser() {
        statement((statement) -> {
            String sql = "update t_user set last_login_time=current_timestamp,login_ip= '192.168.1.200' where user_name = 'admin'";
            try {
                statement.executeUpdate(sql);
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void queryUser() {
        Statement statement = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "select * from t_user";
        try {
            conn = DBUtils.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String userName = rs.getString("user_name");
                String pwd = rs.getString("pwd");
                String lastLoginTime = rs.getString("last_login_time");
                String loginIp = rs.getString("login_ip");
                System.out.println("id:" + id + " user_name:" + userName + " pwd:" + pwd + " last_login_time:" + lastLoginTime + " login_ip:" + loginIp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn, statement, rs);
        }
    }

    public void deleteUser() {
        statement((statement -> {
            String sql = "delete from t_user where user_name='test'";
            try {
                statement.executeUpdate(sql);
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    public void createUser() {
        statement((statement) -> {
            try {
                String sql = "insert into t_user(user_name,pwd) value ('test','123')";
                statement.executeUpdate(sql);
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void createAdmin() {
        statement(statement -> {
            try {
                String sql = "insert into t_user(user_name,pwd)value('admin','swqzx123')";
                statement.executeUpdate(sql);
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void createUserWithRoles() {
        statement((statement -> {
            try {
                String sql = "insert into t_user(user_name,pwd) value ('dinghai','dinghai_love')";
                statement.executeUpdate(sql);
                sql = "insert into t_role(role_name) values ('office_operator'),('finace_operator')";
                statement.executeUpdate(sql);
                sql = "select id from t_user where user_name='dinghai'";
                ResultSet rs = statement.executeQuery(sql);
                rs.next();
                int userId = rs.getInt(1);
                sql = "select id from t_role where role_name='office_operator'";
                rs = statement.executeQuery(sql);
                rs.next();
                int roleId1 = rs.getInt(1);
                sql = "select id from t_role where role_name='finace_operator'";
                rs = statement.executeQuery(sql);
                rs.next();
                int roleId2 = rs.getInt(1);
                sql = "insert into t_user_role(user_id, role_id, creater, create_time) values (" + userId + "," + roleId1 + ",'admin',CURRENT_TIMESTAMP)," + "(" + userId + "," + roleId2 + ",'admin',CURRENT_TIMESTAMP)";
                statement.executeUpdate(sql);
                return rs;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private void statement(Function<Statement, ResultSet> fun) {
        Statement statement = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            statement = conn.createStatement();
            conn.setAutoCommit(false);
            rs = fun.apply(statement);
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn, statement, null, rs);
        }
    }
}
