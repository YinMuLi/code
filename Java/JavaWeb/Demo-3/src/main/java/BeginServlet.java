import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/begin")
public class BeginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成随机数
        int random = (int) (Math.random() * 100);
        HttpSession session = req.getSession();
        session.setAttribute("Answer", random);
        session.setAttribute("History", new ArrayList<Integer>());
        //转发
        RequestDispatcher dispatcher = req.getRequestDispatcher("/guess");
        dispatcher.forward(req, resp);
    }
}
