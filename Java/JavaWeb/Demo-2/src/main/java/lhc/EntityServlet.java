package lhc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class EntityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        AtomicInteger visitCount = (AtomicInteger) context.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = new AtomicInteger(0);
            context.setAttribute("visitCount", visitCount);
        }
        visitCount.incrementAndGet();
    }
}
