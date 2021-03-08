package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnListGoods;

import java.util.List;

public interface CustomerReturnListGoodsDao {
    List<CustomerReturnListGoods> queryCustomerReturnListGoods(Integer customerReturnListId);

    Integer deleteBycustomerReturnListGoodsId(Integer customerReturnListId);
}
