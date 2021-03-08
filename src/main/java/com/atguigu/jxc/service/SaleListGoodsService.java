package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;

import java.util.List;

public interface SaleListGoodsService {
    List<SaleList> list(String saleNumber, Integer customerId, Integer state, String sTime, String eTime);

    List<SaleListGoods> getGoodsList(Integer saleListId);

    void delete(Integer saleListId);
}
