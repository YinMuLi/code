import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认用户输入的是数字
        int value = Integer.parseInt(req.getParameter("value"));
        HttpSession session = req.getSession();
        //历史记录
        List<Integer> history = (List<Integer>) session.getAttribute("History");
        history.add(value);
        //比较大小
        int compare = value - (int) session.getAttribute("Answer");
        int result = Integer.compare(compare, 0);
        req.setAttribute("Result", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/guess");
        dispatcher.forward(req, resp);
    }
}
