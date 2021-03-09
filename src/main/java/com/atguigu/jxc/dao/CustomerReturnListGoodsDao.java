package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.SaleOrReturnListGoodsVo;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerReturnListGoodsDao {
    List<CustomerReturnListGoods> queryCustomerReturnListGoods(Integer customerReturnListId);

    Integer deleteBycustomerReturnListGoodsId(Integer customerReturnListId);

    List<SaleOrReturnListGoodsVo> queryCustomerReturnListGoodsJson(@Param("sTime") String sTime,
                                                                   @Param("eTime") String eTime,
                                                                   @Param("goodsTypeId") Integer goodsTypeId
            , @Param("codeOrName") String codeOrName);
}
