package yinmu.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import yinmu.boot.bean.User;

/**
 * @Author 饮木
 * @Date 2022/8/6 16:10
 * @Description TODO
 */
@Mapper
public interface UserMapper {
    public User selectUser(int id);
}
