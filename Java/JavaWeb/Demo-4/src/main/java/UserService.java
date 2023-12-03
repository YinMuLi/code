import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class UserService {
    private final List<User> users;

    public UserService() {
        //读取csv文件
        InputStream in = LoginServlet.class.getResourceAsStream("/users.csv");
        assert in != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        users = new ArrayList<>();
        try {
            String content;
            while (true) {
                content = reader.readLine();
                if (content == null) break;
                else {
                    String[] columns = content.split(",");
                    Set<String> set = new HashSet<>(Arrays.asList(columns).subList(2, columns.length));
                    users.add(new User(columns[0], columns[1], set));
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByUsername(String username) {
        for (var user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && Objects.equals(user.getPassword(), password)) {
            return user;
        }
        return null;
    }
}
