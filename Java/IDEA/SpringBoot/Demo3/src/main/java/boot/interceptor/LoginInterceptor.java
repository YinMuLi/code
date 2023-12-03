package boot.interceptor;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author 饮木
 * @Date 2022/8/4 18:34
 * @Description 登录检查
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截的请求路径："+request.getRequestURI());
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }
        //跳转到登录页面
        response.sendRedirect("/");
        return false;
    }
}
