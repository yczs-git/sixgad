package com.atguigu.jxc.service;


import com.atguigu.jxc.domain.ServiceVO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ZJC
 * @date 2021/3/8 16:48
 * @InterfaceName SaleListGoodsService
 * version : 1.0
 * Description
 **/
public interface SaleListGoodsService {

    Map<String,Object> updateState(String customerName);

}
