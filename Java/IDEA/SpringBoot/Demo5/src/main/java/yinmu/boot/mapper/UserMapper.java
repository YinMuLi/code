package yinmu.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import yinmu.boot.bean.User;

/**
 * @Author 饮木
 * @Date 2022/8/6 19:13
 * @Description TODO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryByIdUser( int id);
}
