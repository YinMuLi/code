package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 作者：饮木
 */
public class CheckInput implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取session对象
        HttpSession session = request.getSession(false);//获取不到不会创建新的session对象
        String serverPath = request.getServletPath();//获取请求的路径
        if (serverPath.equals("/index.jsp") || serverPath.equals("/login")) {
            //如果是登录的界面就不需要检查,直接跳转页面
            chain.doFilter(request, response);
        } else {
            //检查是否登录，即是否有session对象
            if (session == null || session.getAttribute("account") == null) {
                //跳转到登录界面
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                chain.doFilter(request, response);
            }
        }

    }
}
