package yinmu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 饮木
 * @Date 2022/8/2 19:01
 * @Description TODO
 */
@Component
@Data
@ConfigurationProperties(prefix = "game")
public class Game {
    String name;
    double price;
}
