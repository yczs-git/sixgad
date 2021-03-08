package com.atguigu.jxc.dao;


import org.apache.ibatis.annotations.Param;

public interface PurchaseListDao {

    void delete(@Param("purchaseListId")Integer purchaseListId);
}
