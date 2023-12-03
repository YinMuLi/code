package controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.User;

/**
 * @Author 饮木
 * @Date 2022/7/28 16:54
 * @Description TODO
 */
@Controller
public class MyController {
    @PostMapping("/requestBody")
    public String getRequestBody(@RequestBody String body) {
        System.out.println("请求体:");
        System.out.println(body);
        return "success";
    }

    @PostMapping("/requestEntity")
    public String getRequestEntity(RequestEntity<String> entity) {
        System.out.println("请求头" + entity.getHeaders());
        System.out.println("请求体" + entity.getBody());
        return "success";
    }

    @RequestMapping("/responseBody")
    @ResponseBody
    public String responseBody() {
        return "responseBody";
    }

    @RequestMapping("/responseJson")
    @ResponseBody
    public User responseObject() {
        return new User("Jack", 1);
    }
    @PostMapping ("/ajax")
    public void toAjax(RequestEntity<String> entity){
        System.out.println(entity.getHeaders());
    }
}
