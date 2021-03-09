package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.SaleList;
import org.apache.ibatis.annotations.Param;

/**
 * @author wqy
 * @version 1.0 2021/3/8
 */
public interface SaleListsDao {
    void saveSaleList(SaleList saleList);

    SaleList querySaleListByNumber(@Param("saleNumber") String saleNumber);
}
