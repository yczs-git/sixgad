package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;

/**
 * @author XieHaidong
 * @create 2021-03-08 18:53
 */
public interface PurchaseListService {
    ServiceVO save(PurchaseList purchaseList, String purchaseListGoodsStr, String purchaseNumber);
}
