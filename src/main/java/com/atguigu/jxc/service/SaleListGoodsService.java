package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.SaleListGoods;

import java.util.List;
import java.util.Map;

public interface SaleListGoodsService {
    String querySaleListGoodsString(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
