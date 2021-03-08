package com.atguigu.jxc.dao;

import org.apache.ibatis.annotations.Param;

public interface SaleListGoodsDao {


    void delete(@Param("saleListId")Integer saleListId);
}
