package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author 饮木
 * @Date 2022/7/23 18:26
 * @Description TODO
 */
@Controller
public class MyController {

    @RequestMapping("/origin")
    public String originStore(HttpServletRequest request) {
        request.setAttribute("scope", "origin servlet API");
        //转发会把attribute中存储的数据也转发过去
        return "success";
    }

    /**
     * ModelAndView有Model和View的功能
     * Model主要用于向请求域共享数据
     * View主要用于设置视图，实现页面跳转
     */
    @RequestMapping("/springmvc")
    public ModelAndView springmvcStore() {
        ModelAndView mv = new ModelAndView();
        //向请求域中共享数据
        mv.addObject("scope", "springMVC store object");
        //设置视图，实现页面的跳转
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/model")
    public String model(Model model) {
        model.addAttribute("scope", "model store object");
        return "success";
    }

    @RequestMapping("/map")
    public String map(Map<String, Object> map) {
        map.put("scope", "map store object");
        return "success";
    }

    @RequestMapping("/modelMap")
    public String modelMap(ModelMap modelMap) {
        modelMap.addAttribute("scope", "ModelMap store object");
        return "success";
    }

    @RequestMapping("/session")
    public String session(HttpSession session) {
        session.setAttribute("scope", "session store object");
        return "success";
    }
    @RequestMapping("/application")
    public String toApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("scope", "Servlet Context store object");
        return "success";
    }
}
