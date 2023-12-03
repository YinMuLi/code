package com.shop.dao;

import com.shop.pojo.Shop;

import java.util.List;
import java.util.Map;

/**
 * 作者：饮木
 */
public interface ShopMapper {
    //根据传入的条件查询商品
    List<Shop> queryShops(Map map);

    //更新数据
    void updateShop(Map map);
}
