package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.SaleOrReturnListGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleListGoodsDao {
    List<SaleOrReturnListGoodsVo> querySaleListGoods(@Param("sTime") String sTime,
                                                     @Param("eTime") String eTime,
                                                     @Param("goodsTypeId") Integer goodsTypeId
            , @Param("codeOrName") String codeOrName);


    void delete(@Param("saleListId")Integer saleListId);
}
