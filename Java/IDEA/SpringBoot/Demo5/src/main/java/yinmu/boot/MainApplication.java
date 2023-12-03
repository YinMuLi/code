package yinmu.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 饮木
 * @Date 2022/8/6 19:09
 * @Description TODO
 */
@SpringBootApplication
@MapperScan("yinmu.boot.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
