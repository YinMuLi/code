package lhc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class LoginServlet extends HttpServlet {
    private Map<String, String> userMap = new HashMap<>();

    /**
     * 读取配置文件并保存在内容中
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        String filePath = config.getInitParameter("fileName");
        InputStream in = LoginServlet.class.getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String content = null;
            while (true) {
                content = reader.readLine();
                if (content == null) break;
                else {
                    String[] results = content.split(",");
                    userMap.put(results[0], results[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        PrintWriter out = resp.getWriter();
        if (userMap.containsKey(account) && userMap.get(account).equals(req.getParameter("password"))) {
            out.println("Success");
        } else {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403
            out.println("Error");
        }
    }
}
