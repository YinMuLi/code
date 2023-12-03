package lhc;

import lhc.dao.Student;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/student", initParams = {@WebInitParam(name = "fileName", value = "/student.csv")
})
public class StudentServlet extends HttpServlet {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        String filePath = config.getInitParameter("fileName");
        InputStream in = LoginServlet.class.getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String content = null;
        try {
            while ((content = reader.readLine()) != null) {
                String[] results = content.split(",");
                studentList.add(new Student(results[0], results[1]));
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("no");
        resp.setContentType("text/html; charset = utf-8");
        PrintWriter out = resp.getWriter();
        if (number == null) return;
        //模糊查询学生
        List<Student> results = studentList.stream().filter(
                s -> s.getNumber().contains(number)
        ).toList();
        results.forEach(System.out::println);
    }

}
