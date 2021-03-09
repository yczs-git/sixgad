package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author : SongMc
 * @date : 2021/3/8 20:28
 * className : PurchaseListGoodsServiceImpl
 * package: com.atguigu.jxc.service.impl
 * version : 1.0
 * Description
 */
@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @Override
    public ServiceVO updateState(Integer purchaseListId) {
        return null;
    }

}
