package com.atguigu.jxc.service;


import java.util.Map;

public interface CustomerReturnListGoodsService {
    Map<String, Object> queryCustomerReturnListGoods(Integer customerReturnListId);

    Boolean deleteBycustomerReturnListId(Integer customerReturnListId);
}
