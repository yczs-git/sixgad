package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.atguigu.jxc.vo.SaleListVo;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : ZJC
 * @date : 2021/3/8 16:55
 * className : SaleListGoodsImpl
 * package: com.atguigu.jxc.service.impl
 * version : 1.0
 * Description
 */
@Service
public class SaleListGoodsImpl implements SaleListGoodsService {
    
    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public Map<String,Object> updateState(String customerName) {

        List<SaleListVo> saleListVos = saleListGoodsDao.querySaleListId(customerName);
        if (CollectionUtils.isEmpty(saleListVos)){
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", saleListVos);

        return map;

    }
}
