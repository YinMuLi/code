import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Integer result = (Integer) req.getAttribute("Result");
        if (result != null) {
            HttpSession session = req.getSession();
            List<Integer> history = (List<Integer>) session.getAttribute("History");
            if (result == 0) {
                out.printf("<h4 style=\"color: blue\">您一共猜了%d次，本次猜对答案了</h4>\n" +
                        "<a href=\"/demo_3/\">重新开始</a>", history.size());
                return;
            }
            String title = result == 1 ? "大了" : "小了";
            out.printf("<h4 style=\"color: red\">您一共猜了%d次，本次猜%s</h4>", history.size(), title);
        }

        out.print("""
                <form method="post" action="/demo_3/result">
                    <input type="text" name="value" placeholder="请输入猜的数字"/>
                    <button type="submit">猜一猜</button>
                </form>""");
    }
}
