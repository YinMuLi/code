package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author 饮木
 * @Date 2022/7/21 10:38
 * @Description TODO
 */
@Controller
public class HelloController {
    /**
     * //@RequestMapping注解：处理请求和控制器方法之间的映射关系
     * //@RequestMapping注解的value属性可以通过请求地址匹配请求，
     * /表示的当前工程的上下文路径 localhost:8080/springMVC/
     * 当值只有value时可以省略value:@RequestMapping("/")
     */

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

}
