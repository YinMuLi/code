import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        //测试A
        User user = new User();
        user.setUsername("admin");
        user.setPwd("123456");
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("李四"));
        roles.add(new Role("王五"));
        roles.add(new Role("赵六"));
        user.setRoles(roles);
        service.createUser(user, "admin");
        //测试B
        Role role = new Role();
        role.setName("张三");
        service.createRole(role);
        //测试C
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginIp("123.256.142");
        loginInfo.setLoginTime(LocalDateTime.now());
        User user1 = service.login("admin", "123456", loginInfo);
        System.out.println(user1);
        //测试D
        Role test = new Role(1, "李四");
        System.out.println(service.findUsersWithRole(test));

    }
}
