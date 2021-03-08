package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import com.atguigu.jxc.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerReturnListDao {

    List<CustomerReturnList> queryCustomerReturnListByCondition(@Param("returnNumber")String returnNumber,@Param("customerId") Integer customerId,@Param("state") Integer state,@Param("sTime") String sTime,@Param("eTime") String eTime);

    Integer deleteBycustomerReturnListById(Integer customerReturnListId);


//    List<Goods> getGoodsList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("goodsName") String goodsName, @Param("goodsTypeId") Integer goodsTypeId);
//
//    Integer getGoodsCount(@Param("goodsName") String goodsName,@Param("goodsTypeId") Integer goodsTypeId);
//
//    String getMaxCode();
//
//    Integer saveGoods(Goods goods);
//
//    Integer updateGoods(Goods goods);
//
//    Integer deleteGoods(Integer goodsId);
//
//    Goods findByGoodsId(Integer goodsId);
//
//    List<Goods> getNoInventoryQuantity(@Param("offSet") Integer offSet,@Param("pageRow") Integer pageRow,@Param("nameOrCode") String nameOrCode);
//
//    Integer getNoInventoryQuantityCount(@Param("nameOrCode") String nameOrCode);
//
//    List<Goods> getHasInventoryQuantity(@Param("offSet") Integer offSet,@Param("pageRow") Integer pageRow,@Param("nameOrCode") String nameOrCode);
//
//    Integer getHasInventoryQuantityCount(@Param("nameOrCode")String nameOrCode);
//
//    List<Goods> getGoodsInventoryList(@Param("offSet") Integer offSet,@Param("pageRow") Integer pageRow, @Param("codeOrName") String codeOrName,@Param("goodsTypeId") Integer goodsTypeId);
//
//    Integer getGoodsInventoryCount(@Param("codeOrName") String codeOrName,@Param("goodsTypeId") Integer goodsTypeId);
//
//    // 查询当前库存小于最小库存的商品
//    List<Goods> getGoodsAlarm();

}
