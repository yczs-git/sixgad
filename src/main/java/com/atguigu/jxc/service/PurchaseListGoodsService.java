package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

/**
 * @author SongMc
 * @date 2021/3/8 20:28
 * @InterfaceName PurchaseListGoodsService
 * version : 1.0
 * Description
 **/
public interface PurchaseListGoodsService {
    ServiceVO updateState(Integer purchaseListId);

}
