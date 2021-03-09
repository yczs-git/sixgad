package com.atguigu.jxc.dao;
import com.atguigu.jxc.domain.SaleOrReturnListGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.atguigu.jxc.entity.SaleListGoods;

/**
 * @author wqy
 * @version 1.0 2021/3/8
 */
public interface SaleListGoodsDao {
    void saveSaleListGoods(SaleListGoods saleListGoods);

    List<SaleOrReturnListGoodsVo> querySaleListGoods(@Param("sTime") String sTime,
                                                     @Param("eTime") String eTime,
                                                     @Param("goodsTypeId") Integer goodsTypeId
            , @Param("codeOrName") String codeOrName);


    void delete(@Param("saleListId")Integer saleListId);
}
