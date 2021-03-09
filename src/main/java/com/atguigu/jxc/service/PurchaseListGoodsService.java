package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.PurchaseListGoodsVo;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PurchaseListGoodsService {


    List<PurchaseList> list(String purchaseNumber,
                            Integer supplierId,
                            Integer state,
                            String eTime,
                            String sTime);

    List<PurchaseListGoods> queryGoodsListBypurchaseListId(Integer purchaseListId);

    void delete(Integer purchaseListId);
}
