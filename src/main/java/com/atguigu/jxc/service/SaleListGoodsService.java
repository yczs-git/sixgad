package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.SaleList;

/**
 * @author wqy
 * @version 1.0 2021/3/8
 */
public interface SaleListGoodsService {
    Boolean bigSave(String saleNumber, SaleList saleList, String saleListGoodsStr);
}
