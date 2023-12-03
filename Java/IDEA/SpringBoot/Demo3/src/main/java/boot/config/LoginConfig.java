package boot.config;

import boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 饮木
 * @Date 2022/8/4 18:58
 * @Description TODO
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        addPathPatterns("/*")只拦截请求不会拦截静态资源
        addPathPatterns("/**")即会拦截请求也会拦截静态资源
         */
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/", "/login");
    }
}
