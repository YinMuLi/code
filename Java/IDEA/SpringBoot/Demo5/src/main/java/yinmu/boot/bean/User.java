package yinmu.boot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 饮木
 * @Date 2022/8/6 19:11
 * @Description TODO
 */
//User 会默认寻找数据库中的user表单
@Data
@TableName("user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

