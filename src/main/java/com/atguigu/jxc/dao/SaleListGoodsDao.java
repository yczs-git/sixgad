package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;

/**
 * @author : SongMc
 * @date : 2021/3/8 15:24
 * className : SaleListGoodsDao
 * package: com.atguigu.jxc.dao
 * version : 1.0
 * Description
 */
public interface SaleListGoodsDao {
    ServiceVO<SaleListGoods> update(SaleListGoods saleListGoods);
}
