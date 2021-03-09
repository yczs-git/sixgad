package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;

/**
 * @author SongMc
 * @date 2021/3/8 15:20
 * @InterfaceName SaleListGoodsService
 * version : 1.0
 * Description
 **/
public interface SaleListGoodsService {

    ServiceVO save(String saleNumber, SaleList saleList, String saleListGoodsStr);
}
