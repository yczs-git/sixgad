package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleListDao {


    List<SaleList> list(@Param("saleNumber") String saleNumber, @Param("customerId")Integer customerId,
                        @Param("state")Integer state, @Param("sTime")String sTime, @Param("eTime")String eTime);

    List<SaleListGoods> getGoodsList(@Param("saleListId")Integer saleListId);

    void delete(@Param("saleListId")Integer saleListId);
}
