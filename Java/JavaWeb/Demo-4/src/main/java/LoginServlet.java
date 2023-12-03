import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
        String username = req.getParameter("username");
        User user = service.login(username, req.getParameter("password"));
        if (user != null) {
            Cookie cookie = new Cookie("username", username);
            resp.addCookie(cookie);
            return;
        }
        resp.setContentType("text/html; charset = utf-8");
        PrintWriter out = resp.getWriter();
        resp.setStatus(403);
        out.print("登录失败");
    }
}
