package com.atguigu.jxc.service;


import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

/**
 * @author ZJC
 * @date 2021/3/8 14:17
 * @InterfaceName ReturnListGoodsService
 * version : 1.0
 * Description
 **/
public interface ReturnListGoodsService {
    Map<String, Object> queryReturnList(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime);

    Map<String, Object> queryReGoodsList(Integer returnListId);

    ServiceVO deleteReturnList(Integer returnListId);
}
