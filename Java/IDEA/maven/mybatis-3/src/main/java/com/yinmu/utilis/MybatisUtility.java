package com.yinmu.utilis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：饮木
 * SqlSessionFactoryBuilder -> SqlSessionFactory -> SqlSession
 */
public class MybatisUtility {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //固定的步骤
            String resource = "mybatis-config.xml";
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件，创建对象(工厂模式)
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
//    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
//    你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
