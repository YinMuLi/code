import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LoginFilter implements Filter {
    private Set<String> ignoreSet;
    private Map<String, Set<String>> roleMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        var urls = filterConfig.getInitParameter("ignore").split(",");
        ignoreSet = new HashSet<>(List.of(urls));
        roleMap = new HashMap<>();
        var elements = filterConfig.getInitParameter("interceptRoles").split(";");
        for (var e : elements) {
            var values = e.split(",");
            roleMap.put(values[0], new HashSet<>(Arrays.asList(values).subList(1, values.length)));
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getServletPath();
        if (ignoreSet.contains(url)) {
            filterChain.doFilter(request, resp);
        }
        if (roleMap.containsKey(url)) {
            PrintWriter out = resp.getWriter();
            out.printf("Need:%s", roleMap.get(url));
            return;
        }
        filterChain.doFilter(request, resp);
    }
}
