import cn.hutool.crypto.SecureUtil;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {
    public int createUser(User user, String creater) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;

        int result = 1;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("select * from t_user where user_name=?");
            //查询是否存在该用户
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                result = 0;
            } else {
                //创建该用户
                ps = conn.prepareStatement("insert into t_user (user_name,pwd)value (?,?)");
                ps.setString(1, user.getUsername());
                ps.setString(2, SecureUtil.md5(user.getPwd()));
                ps.execute();
            }
            //查询用户中的角色是否存在
            ps = conn.prepareStatement("select * from t_role where role_name=?");
            for (Role role : user.getRoles()) {
                ps.clearParameters();
                ps.setString(1, role.getName());
                rs = ps.executeQuery();
                if (!rs.next()) {
                    //插入角色
                    ps1 = conn.prepareStatement("insert into t_role(role_name) value (?)");
                    ps1.setString(1, role.getName());
                    ps1.execute();
                }
                //建立关联
                ps1 = conn.prepareStatement("insert into t_user_role(user_id, role_id, creater, create_time) " + "value ((select id from t_user where user_name=?)," + "(select id from t_role where role_name=?)," + "?,current_timestamp)");
                ps1.setString(1, user.getUsername());
                ps1.setString(2, role.getName());
                ps1.setString(3, creater);
                ps1.execute();
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(rs, ps, ps1, conn);
        }
        return result;
    }

    public int createRole(Role role) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        int change = 1;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("insert into t_role(role_name) value (?)");
            ps.setString(1, role.getName());
            ps.execute();

            ps = conn.prepareStatement("select id from t_role where role_name=?");
            ps.setString(1, role.getName());
            rs = ps.executeQuery();
            if (rs.next()) {
                role.setId(rs.getInt(1));
            } else {
                change = 0;
            }
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(rs, ps, conn);
        }
        return change;
    }

    public User login(String username, String pwd, LoginInfo loginInfo) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            //更新
            ps = conn.prepareStatement("update t_user set last_login_time=?,login_ip=?where user_name=?and pwd=?");
            //格式化时间
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            ps.setString(1, loginInfo.getLoginTime().format(pattern));
            ps.setString(2, loginInfo.getLoginIp());
            ps.setString(3, username);
            ps.setString(4, SecureUtil.md5(pwd));
            ps.executeUpdate();
            //查询数据
            ps = conn.prepareStatement("select t_user.id,tr.id,tr.role_name from  t_user left join t_role tr on tr.id in" + "(select role_id from t_user_role where user_id=(select id from t_user where user_name=? and pwd=?))");
            ps.setString(1, username);
            ps.setString(2, SecureUtil.md5(pwd));
            rs = ps.executeQuery();
            User user = new User();
            while (rs.next()) {
                if (user.getId() == null) {
                    user.setId(rs.getInt(1));
                }
                List<Role> roles = user.getRoles();
                if (roles == null) {
                    roles = new ArrayList<>();
                    user.setRoles(roles);
                }
                Role role = new Role();
                role.setId(rs.getInt(2));
                role.setName(rs.getString(3));
                roles.add(role);
            }
            user.setUsername(username);
            user.setPwd(SecureUtil.md5(pwd));
            conn.commit();
            return user;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(rs, ps, conn);
        }
    }

    public List<User> findUsersWithRole(Role role) {
        ResultSet rs = null;
        ResultSet rs_1 = null;
        PreparedStatement ps = null;
        PreparedStatement ps_1 = null;
        Connection conn = null;
        List<User> users = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            //查询所有具有角色的用户id
            ps = conn.prepareStatement("select * from t_user where id in (select user_id from t_user_role where role_id=?)");
            ps.setInt(1,role.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("user_name"));
                user.setPwd(rs.getString("pwd"));
                //为用户添加角色
                List<Role> roles = new ArrayList<>();
                ps_1 = conn.prepareStatement("select * from t_role where id in (select role_id from t_user_role where user_id=?)");
                ps_1.setInt(1, rs.getInt("id"));
                rs_1 = ps_1.executeQuery();
                while (rs_1.next()) {
                    Role child = new Role();
                    child.setId(rs_1.getInt("id"));
                    child.setName(rs_1.getString("role_name"));
                    roles.add(child);
                }
                user.setRoles(roles);
                users.add(user);
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(rs, rs_1, ps, ps_1, conn);
        }
        return users;
    }
}
