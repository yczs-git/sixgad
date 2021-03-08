package com.atguigu.jxc.dao;


import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseListGoodsDao {


    List<PurchaseList> getPurchaseListGoodsByNumber(@Param("purchaseNumber")String purchaseNumber,
                                                    @Param("supplierId") Integer supplierId,
                                                    @Param("state")Integer state,
                                                    @Param("eTime") String eTime,
                                                    @Param("sTime") String sTime);

    List<PurchaseListGoods> queryGoodsListBypurchaseListId(@Param("purchaseListId")Integer purchaseListId);

    void delete(@Param("purchaseListId")Integer purchaseListId);
}
