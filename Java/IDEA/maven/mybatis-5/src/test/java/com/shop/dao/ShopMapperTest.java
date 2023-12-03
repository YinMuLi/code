package com.shop.dao;

import com.shop.pojo.Shop;
import com.shop.utils.MybatisUtility;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：饮木
 */
public class ShopMapperTest extends TestCase {

    public void testQueryShop() {
        SqlSession session = MybatisUtility.getSqlSession();
        ShopMapper mapper = session.getMapper(ShopMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("price", 300);
        map.put("name", "丝袜奶茶");
        List<Shop> shops = mapper.queryShops(map);
        for (Shop item : shops) {
            System.out.println(item);
        }
    }

    public void testUpdateShop() {
        SqlSession session = MybatisUtility.getSqlSession();
        ShopMapper mapper = session.getMapper(ShopMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("price", 900);
        //map.put("name","丝袜奶茶");
        map.put("id", 3);
        mapper.updateShop(map);
        session.commit();
    }
}